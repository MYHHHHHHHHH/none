package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;
import androidx.lifecycle.LiveData;

import com.example.myapplication.db.Word;
import com.example.myapplication.db.WordRepository;

import androidx.lifecycle.Transformations;
import androidx.lifecycle.MutableLiveData;

public class WordViewModel extends AndroidViewModel
{
    public final WordRepository wordRepository;
    public LiveData<List<Word>> allWords;
    private final LiveData<List<Word>> wordsLiveData;

    //Construct
    public WordViewModel(@NonNull Application application)
    {
        super(application);
        wordRepository = new WordRepository(application);
        allWords = wordRepository.getAllWordsLive();

        wordsLiveData = Transformations.switchMap(numberPickerValue_year, year ->
                Transformations.switchMap(numberPickerValue_index, index ->
                        wordRepository.getWordByYearAndIndex(year.toString(), index.toString())
                )
        );
    }


    public LiveData<List<Word>> getAllWordsLive()
    {
        return allWords;
    }
    // 获取单词数量的 LiveData
    public LiveData<Integer> getWordCount() {
        return Transformations.map(allWords, List::size);
    }

    // 获取查询到 Word 的变化
    public LiveData<List<Word>> getWordsLiveData() {
        return wordsLiveData;
    }


    // 获取 year 的变化
    private final MutableLiveData<Integer> numberPickerValue_year = new MutableLiveData<>(2000);
    public LiveData<Integer> getNumberPickerValue_year() {
        return numberPickerValue_year;
    }
    public void setNumberPickerValue_year(int value) {
        numberPickerValue_year.setValue(value);
    }
    // 获取 index 的变化
    private final MutableLiveData<Integer> numberPickerValue_index = new MutableLiveData<>(1);
    public LiveData<Integer> getNumberPickerValue_index() {
        return numberPickerValue_index;
    }
    public void setNumberPickerValue_index(int value) {
        numberPickerValue_index.setValue(value);
    }
}
