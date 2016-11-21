package com.example.emrebabur.wordcounter.util;

import com.example.emrebabur.wordcounter.pojo.WordCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by emre.babur on 21.11.2016.
 */
public class Words {
    private Words(){
        throw new AssertionError();
    }

    public static String[] strip(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[\\s]+", " ");
        s = s.replaceAll("[^\\w ]", "");
        s = s.replaceAll("[\\s]+", " ");
        s = s.trim();
        return (s.length() > 0) ? s.split(" ") : new String[]{};
    }

    public static Map<String, Integer> count(String[] words) {
        Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
        for(String word: words) {
            Integer count = wordCountMap.containsKey(word) ? wordCountMap.get(word) : 0 ;
            wordCountMap.put(word, count + 1);
        }
        return wordCountMap;
    }

    public static List<WordCount> convertMapToList(Map<String, Integer> wordCountMap) {
        List<WordCount> wordCountList = new ArrayList<WordCount>();
        for(String word: wordCountMap.keySet()) {
            wordCountList.add(new WordCount(word, wordCountMap.get(word)));
        }
        return wordCountList;
    }
}
