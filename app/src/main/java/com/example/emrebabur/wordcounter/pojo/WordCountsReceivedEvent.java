package com.example.emrebabur.wordcounter.pojo;

import java.util.List;

/**
 * Created by emre.babur on 18.11.2016.
 */
public class WordCountsReceivedEvent {

    private List<WordCount> data;

    public WordCountsReceivedEvent(List<WordCount> data) {
        this.data = data;
    }

    public List<WordCount> getData() {
        return data;
    }
}
