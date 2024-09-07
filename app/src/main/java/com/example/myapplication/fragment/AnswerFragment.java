package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.EditText;
import android.text.TextWatcher;
import android.text.Editable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;
import java.util.ArrayList;

import com.example.myapplication.R;
import com.example.myapplication.WordViewModel;
import com.example.myapplication.db.Word;

import androidx.lifecycle.Observer;
import android.util.Log;

import android.content.DialogInterface;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnswerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnswerFragment extends Fragment
{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public AnswerFragment()
    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnswerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnswerFragment newInstance(String param1, String param2)
    {
        AnswerFragment fragment = new AnswerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    // 数据库
    //WordDataBase wordDataBase;
    private WordViewModel wordViewModel;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        //wordDataBase = WordDataBase.getDatabase(getContext());
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        // 共享 ViewModel，通过 requireActivity() 来确保 ViewModel 是与 Activity 共享的
        wordViewModel = new ViewModelProvider(requireActivity()).get(WordViewModel.class);
//        wordViewModel.setNumberPickerValue_year(numberPicker_year.getValue());
//        wordViewModel.setNumberPickerValue_index(numberPicker_index.getValue());
//        // 测试插入数据库
//         wordViewModel.wordRepository.insertWords(new Word("2010","1", "BADAB"));
//         wordViewModel.wordRepository.insertWords(new Word("2010","2", "CDCBA"));
//         wordViewModel.wordRepository.insertWords(new Word("2010","3", "BDACC"));
//         wordViewModel.wordRepository.insertWords(new Word("2010","4", "ADCBD"));
//
//         wordViewModel.wordRepository.insertWords(new Word("2011", "1","CBDBA"));
//         wordViewModel.wordRepository.insertWords(new Word("2011", "2","BDCAC"));
//         wordViewModel.wordRepository.insertWords(new Word("2011", "3","DCBAA"));
//         wordViewModel.wordRepository.insertWords(new Word("2011", "4","CDADB"));
//
//         wordViewModel.wordRepository.insertWords(new Word("2012", "1","DBACD"));
//         wordViewModel.wordRepository.insertWords(new Word("2012", "2","CDADA"));
//         wordViewModel.wordRepository.insertWords(new Word("2012", "3","ABBDC"));
//         wordViewModel.wordRepository.insertWords(new Word("2012", "4","CDBCA"));
//
//         wordViewModel.wordRepository.insertWords(new Word("2013", "1","DBACC"));
//         wordViewModel.wordRepository.insertWords(new Word("2013", "2","ADCBD"));
//         wordViewModel.wordRepository.insertWords(new Word("2013", "3","BBDAC"));
//         wordViewModel.wordRepository.insertWords(new Word("2013", "4","ACBAD"));
//
//         wordViewModel.wordRepository.insertWords(new Word("2014", "1","CADBA"));
//         wordViewModel.wordRepository.insertWords(new Word("2014", "2","DBCDC"));
//         wordViewModel.wordRepository.insertWords(new Word("2014", "3","CBADB"));
//         wordViewModel.wordRepository.insertWords(new Word("2014", "4","ADCBA"));
//
//         wordViewModel.wordRepository.insertWords(new Word("2015", "1","DABDC"));
//         wordViewModel.wordRepository.insertWords(new Word("2015", "2","BCADB"));
//         wordViewModel.wordRepository.insertWords(new Word("2015", "3","BCDCA"));
//         wordViewModel.wordRepository.insertWords(new Word("2015", "4","ADCAB"));
//
//         wordViewModel.wordRepository.insertWords(new Word("2016", "1","ADBCA"));
//         wordViewModel.wordRepository.insertWords(new Word("2016", "2","DACBC"));
//         wordViewModel.wordRepository.insertWords(new Word("2016", "3","BCDBA"));
//         wordViewModel.wordRepository.insertWords(new Word("2016", "4","DABCD"));
//
//         wordViewModel.wordRepository.insertWords(new Word("2017", "1","BCBDA"));
//         wordViewModel.wordRepository.insertWords(new Word("2017", "2","ACDAB"));
//         wordViewModel.wordRepository.insertWords(new Word("2017", "3","DADBC"));
//         wordViewModel.wordRepository.insertWords(new Word("2017", "4","CACCD"));
//
//         wordViewModel.wordRepository.insertWords(new Word("2018", "1","DCADB"));
//         wordViewModel.wordRepository.insertWords(new Word("2018", "2","DCBAB"));
//         wordViewModel.wordRepository.insertWords(new Word("2018", "3","CDBAC"));
//         wordViewModel.wordRepository.insertWords(new Word("2018", "4","BAACD"));
//
//         wordViewModel.wordRepository.insertWords(new Word("2019", "1","BDCAC"));
//         wordViewModel.wordRepository.insertWords(new Word("2019", "2","BDACD"));
//         wordViewModel.wordRepository.insertWords(new Word("2019", "3","ABCDA"));
//         wordViewModel.wordRepository.insertWords(new Word("2019", "4","CDBAB"));
//
//         wordViewModel.wordRepository.insertWords(new Word("2020", "1","CBDBC"));
//         wordViewModel.wordRepository.insertWords(new Word("2020", "2","DACAD"));
//         wordViewModel.wordRepository.insertWords(new Word("2020", "3","ACDCB"));
//         wordViewModel.wordRepository.insertWords(new Word("2020", "4","BDABA"));
//
//         wordViewModel.wordRepository.insertWords(new Word("2021", "1","DBCAA"));
//         wordViewModel.wordRepository.insertWords(new Word("2021", "2","CADDB"));
//         wordViewModel.wordRepository.insertWords(new Word("2021", "3","BCABC"));
//         wordViewModel.wordRepository.insertWords(new Word("2021", "4","ADDBC"));
//
//         wordViewModel.wordRepository.insertWords(new Word("2022", "1","ACDDB"));
//         wordViewModel.wordRepository.insertWords(new Word("2022", "2","CBCDA"));
//         wordViewModel.wordRepository.insertWords(new Word("2022", "3","BAABC"));
//         wordViewModel.wordRepository.insertWords(new Word("2022", "4","DADBC"));
//
//         wordViewModel.wordRepository.insertWords(new Word("2023", "1","CBACD"));
//         wordViewModel.wordRepository.insertWords(new Word("2023", "2","ADBCD"));
//         wordViewModel.wordRepository.insertWords(new Word("2023", "3","ACAAD"));
//         wordViewModel.wordRepository.insertWords(new Word("2023", "4","BCABD"));

    }

    private NumberPicker numberPicker_year;
    private NumberPicker numberPicker_index;
    private TextView textView;
    private EditText editText;
    private LiveData<Integer> year;
    private LiveData<Integer> index;
    private Word currentWord;

    private String answer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_answer, container, false);
        this.numberPicker_year = view.findViewById(R.id.numberPicker1);
        EditText editText = view.findViewById(R.id.editText);
        Button button = view.findViewById(R.id.button);

        numberPicker_year.setMaxValue(2024);
        numberPicker_year.setMinValue(2010);
        numberPicker_year.setValue(2010);

        numberPicker_index = view.findViewById(R.id.numberPicker0);
        numberPicker_index.setMaxValue(4);
        numberPicker_index.setMinValue(1);
        numberPicker_index.setValue(1);

        wordViewModel.setNumberPickerValue_year(numberPicker_year.getValue());
        wordViewModel.setNumberPickerValue_index(numberPicker_index.getValue());

        // 得到 year
        numberPicker_year.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // 更新 ViewModel 中的 LiveData
                wordViewModel.setNumberPickerValue_year(newVal);
                year = wordViewModel.getNumberPickerValue_year();
                //textView.setText(String.valueOf(year.getValue()));
            }
        });
        // 得到 index
        numberPicker_index.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // 更新 ViewModel 中的 LiveData
                wordViewModel.setNumberPickerValue_index(newVal);
                index = wordViewModel.getNumberPickerValue_index();
                //textView.setText(String.valueOf(index.getValue()));
            }
        });

        // 设置 TextWatcher 来监听文本变化保存到 answer
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 文本变化之前的操作
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 文本变化时调用，这里你可以获取当前输入的内容
                Log.d("EditText", "Current text: " + s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
                answer = s.toString();
                Log.d("EditText", "Answer: " + answer);
            }
        });

        //由 numberPicker_year 和 numberPicker_index 的变化得到 answer 的变化
        wordViewModel.getWordsLiveData().observe(getViewLifecycleOwner(), new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                // 处理 LiveData<List<Word>> 的变化
                if (words != null) {
                    currentWord = words.get(0);
                    Log.d("WordViewModel", words.get(0).getYear() + words.get(0).getIndex());
                }
            }
        });

        // 设置按钮点击监听器
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建 AlertDialog.Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                if(answer == null)
                {
                    builder.setTitle("提示")
                            .setMessage("未输入答案！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // 当用户点击确定按钮时执行的操作
                                    // 在这里处理确定按钮点击后的逻辑
                                }
                            });
                }
                else if(answer.length() != 5)
                {
                    builder.setTitle("提示")
                            .setMessage("答案有且只有5个！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // 当用户点击确定按钮时执行的操作
                                    // 在这里处理确定按钮点击后的逻辑
                                }
                            });
                }
                else if(containsLowerCaseLetter(answer))
                {
                    builder.setTitle("提示")
                            .setMessage("请不要输入小写字符！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // 当用户点击确定按钮时执行的操作
                                    // 在这里处理确定按钮点击后的逻辑
                                }
                            });
                }
                else if(containsOtherCharacters(answer))
                {
                    builder.setTitle("提示")
                            .setMessage("答案只能是A或B或C或D！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // 当用户点击确定按钮时执行的操作
                                    // 在这里处理确定按钮点击后的逻辑
                                }
                            });
                }

                else
                {
                    Log.e("answer",  currentWord.getCorrectAnswer());
                    int wrongCount = 5 - countSame(compareStrings(answer,currentWord.getCorrectAnswer()));

                    //全对情况
                    if(wrongCount ==0)
                    {
                        builder.setTitle("提示")
                                .setMessage("全对！")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // 当用户点击确定按钮时执行的操作
                                        // 在这里处理确定按钮点击后的逻辑
                                    }
                                });
                    }
                    //有错情况
                    else{
                        builder.setTitle("提示")
                                .setMessage("错" + String.valueOf(wrongCount) +"个")
                                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // 确认按钮的操作
                                    }
                                })
//                                .setNegativeButton("错题题号", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        // 取消按钮的操作
//                                        (AlertDialog)dialog.show("CustomDialog");
//                                    }
//                                })
//                                .setNeutralButton("正确答案", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        // 忽略按钮的操作
//                                    }
//                                })
                                .create();
                    }
                }
                // 创建并显示弹窗
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        //测试word的字段数量
//        wordViewModel.getWordCount().observe(getViewLifecycleOwner(), new Observer<Integer>() {
//                @Override
//                public void onChanged(Integer count) {
//                    try {
//                        if (count != null) {
//                            textView.setText(count.toString());
//                            Log.w("WordViewModel", count.toString());
//                        } else {
//                            Log.w("WordViewModel", "Received null count");
//                        }
//                    } catch (Exception e) {
//                        Log.e("WordViewModel", "Error updating UI", e);
//                    }
//                }
//            });

        //
        //        Log.e("WordViewModel",  String.valueOf(year.getValue()));
        //        Log.e("WordViewModel",  String.valueOf(index.getValue()));
        // Inflate the layout for this fragment

        return view;

    }

    //检查字符串内有没有小写
    private static boolean containsLowerCaseLetter(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }
    //检查有没有 ABCD 以外的字符
    private static boolean containsOtherCharacters(String str) {
        for (char c : str.toCharArray()) {
            if (c != 'A' && c != 'B' && c != 'C' && c != 'D') {
                return true; // 如果找到非A、B、C、D的字符，则返回true
            }
        }
        return false; // 如果没有其他字符，则返回false
    }

    //比较两个 String
    private static String compareStrings(String str1, String str2)
    {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str1.length(); i++)
        {
            if (str1.charAt(i) == str2.charAt(i))
            {
                result.append('1'); // 对应位置字符相同
            } else
            {
                result.append('0'); // 对应位置字符不同
            }
        }
        return result.toString();
    }

    //对 String 的比较结果进行判断
    private static int countSame(String s)
    {
        int count = 0;
        for(char c: s.toCharArray()){
            if (c == '1'){
                count ++;
            }
        }
        return count;
    }
}