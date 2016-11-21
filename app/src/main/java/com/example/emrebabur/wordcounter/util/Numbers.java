package com.example.emrebabur.wordcounter.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emre.babur on 18.11.2016.
 */
public class Numbers {
    private Numbers(){
        throw new AssertionError();
    }
    public static Boolean testPrimality(Integer num) {
        if(!memo.containsKey(num)) {
            if ( num < 1 || (num % 2 == 0 && num > 2)) {
                memo.put(num, false);
                return false;
            }
            int top = (int) Math.sqrt(num) + 1;
            for(long i = 3; i < top; i+=2){
                if(num % i == 0){
                    memo.put(num, false);
                    return false;
                }
            }
            memo.put(num, true);
            return true;
        }
        else {
            return memo.get(num);
        }
    }

    public static Map<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
}
