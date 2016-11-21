package com.example.emrebabur.wordcounter.pojo;

import android.support.annotation.Nullable;

import java.io.Serializable;

/**
 * Created by emre.babur on 18.11.2016.
 */
public class WordCountWithPrimeFlag implements Comparable<WordCountWithPrimeFlag>, Serializable {
    private String word;
    private Integer count;
    public enum Primality {
        TRUE, FALSE, NOT_CALCULATED;
    }

    @Override
    public int compareTo(WordCountWithPrimeFlag wordCountWithPrimeFlag) {
        return -1 * this.count.compareTo(wordCountWithPrimeFlag.count);
    }



    private Primality primality;

    public WordCountWithPrimeFlag(String word, Integer count) {
        this.word = word;
        this.count = count;
        this.primality = Primality.NOT_CALCULATED;
    }

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }

    public Primality getPrimality() {
        return primality;
    }

    public void setPrimality(Primality primality) {
        this.primality = primality;
    }
}
