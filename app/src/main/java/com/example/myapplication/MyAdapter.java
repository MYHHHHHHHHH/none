package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.db.Word;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    List<Word> allWords = new ArrayList<>();
    public void setAllWords(List<Word> allWords)
    {
        this.allWords = allWords;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        Word word = allWords.get(position);
        holder.index.setText(String.valueOf(word.getId()));
    }

    @Override
    public int getItemCount()
    {
        return allWords.size();
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.cell_normal,parent,false);
        return new MyViewHolder(itemView);
    }
    //内部类的MyViewHolder的Constructor
    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView index;
        EditText number ,year;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            index = itemView.findViewById(R.id.index);
            number = itemView.findViewById(R.id.number);
            year = itemView.findViewById(R.id.year);
        }
    }
}
