package com.example.emrebabur.wordcounter.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.emrebabur.wordcounter.R;
import com.example.emrebabur.wordcounter.WordCounterApplication;
import com.example.emrebabur.wordcounter.model.DataManager;
import com.example.emrebabur.wordcounter.pojo.WordCountPrimalityReceivedEvent;
import com.example.emrebabur.wordcounter.pojo.WordCount;
import com.example.emrebabur.wordcounter.pojo.WordCountsReceivedEvent;
import com.example.emrebabur.wordcounter.util.Constants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.RecyclerView)
    RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private WordCountsAdapter wordCountsAdapter;
    private ArrayList<WordCount> wordCounts;
    private final String DATA_TAG = "data";
    @Inject
    public DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        if(savedInstanceState == null) {
            wordCounts = new ArrayList<WordCount>();
            setRecyclerViewAdapter();
        }
        ((WordCounterApplication) getApplication()).getDataManagerComponent().inject(this);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        wordCounts = (ArrayList<WordCount>) savedInstanceState.getSerializable(DATA_TAG);
        setRecyclerViewAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
        if(wordCounts.size() == 0)
            dataManager.loadWords(Constants.NAME_BOOK);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putSerializable(DATA_TAG, wordCounts);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onWordsReceived(WordCountsReceivedEvent event) {
        wordCounts.clear();
        wordCounts.addAll(event.getData());
        wordCountsAdapter.notifyDataSetChanged();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onWordCountPrimalityReceived(WordCountPrimalityReceivedEvent event) {
        wordCounts.get(event.getPosition()).setPrimality(event.getData().getPrimality());
        wordCountsAdapter.notifyItemChanged(event.getPosition());
    }

    private void setRecyclerViewAdapter() {
        wordCountsAdapter = new WordCountsAdapter(wordCounts);
        recyclerView.setAdapter(wordCountsAdapter);
    }
}
