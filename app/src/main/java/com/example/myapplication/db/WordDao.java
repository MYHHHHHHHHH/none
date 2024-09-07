package com.example.myapplication.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;


@Dao
public interface WordDao
{
    @Insert
    void insertWords(Word... words);

    @Update
    void updateWords(Word... words);

    @Delete
    void deleteWords(Word... words);

    @Query("DELETE FROM WORD")
    void deleteAllWords();

    //检查数据表是否为空
    @Query("SELECT COUNT(*) FROM WORD")
    int getWordCount();

    // 获取唯一年份
    @Query("SELECT DISTINCT YEAR FROM WORD")
    LiveData<List<String>> getDistinctYears();

    @Query("SELECT * FROM Word ORDER BY ID DESC")
    LiveData<List<Word>> getAllWordsLive();

    @Query("SELECT * FROM Word WHERE year = :year AND `index` = :index")
    LiveData<List<Word>> getWordByYearAndIndex(String year, String index);

}
