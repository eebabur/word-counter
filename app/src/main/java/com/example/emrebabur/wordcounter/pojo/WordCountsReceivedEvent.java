package com.example.emrebabur.wordcounter.pojo;

import java.util.List;

/**
 * Created by emre.babur on 18.11.2016.
 */
public class WordCountsReceivedEvent {

    private List<WordCountWithPrimeFlag> data;

    public WordCountsReceivedEvent(List<WordCountWithPrimeFlag> data) {
        this.data = data;
    }

    public List<WordCountWithPrimeFlag> getData() {
        return data;
    }
}
