package com.example.myapplication.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word
{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "year")
    private String year;

    @ColumnInfo(name = "index")
    private String index;

    @ColumnInfo(name = "correct_answer")
    private String correctAnswer;

    public Word(String year, String index,String correctAnswer)
    {
        this.year = year;
        this.index = index;
        this.correctAnswer = correctAnswer;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getIndex()
    {
        return index;
    }

    public void setIndex(String index)
    {
        this.index = index;
    }

    public String getCorrectAnswer()
    {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
