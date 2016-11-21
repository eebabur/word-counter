package com.example.emrebabur.wordcounter.pojo;

import java.io.Serializable;

/**
 * Created by emre.babur on 18.11.2016.
 */
public class WordCount implements Comparable<WordCount>, Serializable {
    private String word;
    private Integer count;
    public enum Primality {
        TRUE, FALSE, NOT_CALCULATED;
    }

    @Override
    public int compareTo(WordCount wordCount) {
        return -1 * this.count.compareTo(wordCount.count);
    }



    private Primality primality;

    public WordCount(String word, Integer count) {
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
