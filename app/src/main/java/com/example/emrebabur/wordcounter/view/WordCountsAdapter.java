package com.example.emrebabur.wordcounter.view;


import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.emrebabur.wordcounter.R;
import com.example.emrebabur.wordcounter.pojo.WordCountWithPrimeFlag;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by emre.babur on 18.11.2016.
 */
public class WordCountsAdapter extends RecyclerView.Adapter<WordCountsAdapter.WordViewHolder>{

    private List<WordCountWithPrimeFlag> wordCounts;

    public WordCountsAdapter(List<WordCountWithPrimeFlag> wordCounts) {
        this.wordCounts = wordCounts;
    }


    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_word, parent, false);
        WordViewHolder holder = new WordViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        holder.word.setText(wordCounts.get(position).getWord());
        holder.count.setText(wordCounts.get(position).getCount().toString());
        switch (wordCounts.get(position).getPrimality()) {
            case NOT_CALCULATED:
                holder.count.setTextColor(Color.BLACK);
                break;
            case TRUE:
                holder.count.setTextColor(Color.GREEN);
                break;
            case FALSE:
                holder.count.setTextColor(Color.RED);
                break;
            default:
                ;
        }
    }

    @Override
    public int getItemCount() {
        return wordCounts.size();
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.Word) TextView word;
        @BindView(R.id.Count) TextView count;
        public WordViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
