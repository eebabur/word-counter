package com.example.emrebabur.wordcounter.pojo;

/**
 * Created by emre.babur on 18.11.2016.
 */
public class WordCountPrimalityReceivedEvent {
    private WordCountWithPrimeFlag data;
    private Integer position;

    public WordCountPrimalityReceivedEvent(WordCountWithPrimeFlag data, Integer position) {
        this.data = data;
        this.position = position;
    }

    public WordCountWithPrimeFlag getData() {
        return data;
    }
    public Integer getPosition() {
        return position;
    }
}
