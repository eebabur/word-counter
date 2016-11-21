package com.example.emrebabur.wordcounter.model;


import com.example.emrebabur.wordcounter.pojo.WordCountPrimalityReceivedEvent;
import com.example.emrebabur.wordcounter.pojo.WordCount;
import com.example.emrebabur.wordcounter.pojo.WordCountsReceivedEvent;
import com.example.emrebabur.wordcounter.util.Numbers;
import com.example.emrebabur.wordcounter.util.Words;

import org.greenrobot.eventbus.EventBus;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Observer;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by emre.babur on 18.11.2016.
 */
public class DataManager {
    private ApiService apiService;

    @Inject
    public DataManager(ApiService apiService) {
        this.apiService = apiService;
    }

    public void loadWords(String bookName) {
        apiService.getBook(bookName)
                .subscribeOn(Schedulers.io())
                .map(new Func1<String, String[]>() {

                    @Override
                    public String[] call(String s) {
                        return Words.strip(s);
                    }
                })
                .map(new Func1<String[], Map<String, Integer>>() {
                    @Override
                    public Map<String, Integer> call(String[] words) {
                        return Words.count(words);
                    }
                })
                .map(new Func1<Map<String,Integer>, List<WordCount>>() {
                    @Override
                    public List<WordCount> call(Map<String, Integer> wordCountMap) {
                        return Words.convertMapToList(wordCountMap);
                    }
                })
                .subscribe(new Observer<List<WordCount>>() {
                    List<WordCount> wordCountList;
                    @Override
                    public void onCompleted() {
                        for(int i=0; i< wordCountList.size(); i++) {
                            WordCount wordCount = wordCountList.get(i);
                            if(Numbers.testPrimality(wordCount.getCount()) == true) {
                                wordCount.setPrimality(WordCount.Primality.TRUE);
                            }
                            else {
                                wordCount.setPrimality(WordCount.Primality.FALSE);
                            }
                            EventBus.getDefault().post(new WordCountPrimalityReceivedEvent(wordCount, i));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<WordCount> wordCountList) {
                        Collections.sort(wordCountList);
                        this.wordCountList = wordCountList;
                        EventBus.getDefault().post(new WordCountsReceivedEvent(wordCountList));
                    }
                });
    }
}
