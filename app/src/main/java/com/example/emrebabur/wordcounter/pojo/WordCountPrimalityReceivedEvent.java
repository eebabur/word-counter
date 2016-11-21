package com.example.emrebabur.wordcounter.pojo;

/**
 * Created by emre.babur on 18.11.2016.
 */
public class WordCountPrimalityReceivedEvent {
    private WordCount data;
    private Integer position;

    public WordCountPrimalityReceivedEvent(WordCount data, Integer position) {
        this.data = data;
        this.position = position;
    }

    public WordCount getData() {
        return data;
    }
    public Integer getPosition() {
        return position;
    }
}
