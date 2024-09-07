package com.example.myapplication.db;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import android.content.Context;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.ContentValues;
import androidx.room.OnConflictStrategy;

import android.util.Log;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordDataBase extends RoomDatabase
{
    private static volatile WordDataBase INSTANCE;

    public abstract WordDao getWordDao();

    private static final Executor executor = Executors.newSingleThreadExecutor();

    //初始化数据表
    private static RoomDatabase.Callback roomDatabaseCallback(final Context context) {
        return new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                // 使用传入的 context 读取 SQL 文件并执行语句
                try {
                    List<String> sqlStatements = readSqlFile(context, "init.sql");
                    for (String sql : sqlStatements) {
                        Log.d("SQLStatements", sql);
                    }
                    for (String sql : sqlStatements) {
                        db.execSQL(sql);
                        Log.d("SQLExecution", "Executing: " + sql);
                    }
                    Log.d("WordDataBase", "Database initialized with SQL file");
                } catch (IOException e) {
                    Log.e("WordDataBase", "Error reading SQL file", e);
                }
            }

            // 读取文件的方法
            private List<String> readSqlFile(Context context, String fileName) throws IOException {
                StringBuilder sqlLines = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(context.getAssets().open(fileName)))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sqlLines.append(line).append("\n");
                    }
                }

                // 将整个内容转换为 String 并以分号分割成多个 SQL 语句
                String[] statementsArray = sqlLines.toString().split(";");
                List<String> sqlStatements = new ArrayList<>();
                for (String statement : statementsArray) {
                    statement = statement.trim(); // 去除前后空格
                    if (!statement.isEmpty()) {
                        String st = statement + ';';
                        sqlStatements.add(st); // 只添加非空语句
                    }
                }
                return sqlStatements;
            }
        };
    }

    public static WordDataBase getDatabase(final Context context) {
        if (INSTANCE == null)
        {
            //`volatile` 和 `synchronized` 确保在多线程环境中安全地创建和访问数据库实例
            synchronized (WordDataBase.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(),
                                            WordDataBase.class, "word_database")
                                    .addCallback(roomDatabaseCallback(context))
                                    .build();
                    Log.d("WordDataBase", "Database instance created");
                }
            }
        }
        return INSTANCE;
    }

}
