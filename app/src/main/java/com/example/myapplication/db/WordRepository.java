package com.example.myapplication.db;

import androidx.lifecycle.LiveData;

import java.util.List;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class WordRepository
{
    // Field
    private final LiveData<List<Word>> allWordsLive;
    public WordDao wordDao;
    private final ExecutorService executor;
    WordDataBase wordDatabase;

    // Property
    public LiveData<List<Word>> getAllWordsLive()
    {
        return allWordsLive;
    }

    // Constructor
    public WordRepository(Context context)
    {
        wordDatabase = wordDatabase.getDatabase(context.getApplicationContext());
        this.wordDao = wordDatabase.getWordDao();
        this.allWordsLive = wordDao.getAllWordsLive();
        this.executor = Executors.newSingleThreadExecutor();
    }

    // 创建一个 Runnable 任务
    static private class InsertWordsRunnable implements Runnable
    {
        private final WordDao wordDao;
        private final Word[] words;

        InsertWordsRunnable(WordDao wordDao, Word[] words)
        {
            this.wordDao = wordDao;
            this.words = words;
        }

        @Override
        public void run()
        {
            // 在后台线程中执行任务
            wordDao.insertWords(words);
        }
    }


    // 插入数据库
    public void insertWords(Word... words)
    {
        executor.execute(new InsertWordsRunnable(wordDao, words));
    }

    // 清理资源
    public void shutdown()
    {
        executor.shutdown();
    }

    //查询数据库
    public  LiveData<List<Word>> getWordByYearAndIndex(String year, String index)
    {
        return wordDao.getWordByYearAndIndex(year, index);
    }
}
