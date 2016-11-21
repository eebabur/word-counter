package com.example.emrebabur.wordcounter;

import com.example.emrebabur.wordcounter.util.Numbers;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

/**
 * Created by emre.babur on 21.11.2016.
 */
public class NumbersUnitTest {

    @Test
    public void testPrimality() {
        Random rand = new Random();
        Boolean expected;
        Boolean calculated;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 67, 71, 10007, 10093, 10099};

        expected = false;
        for(int i=0; i<1000; i++) {
            int n = primes[rand.nextInt(primes.length)] * rand.nextInt(Integer.MAX_VALUE / 10099);
            calculated = Numbers.testPrimality(n);
            assertEquals("n = " + n, expected, calculated);
        }

        expected = false;
        for(int i=0; i<100; i++) {
            int n = -1 * rand.nextInt(Integer.MAX_VALUE);
            calculated = Numbers.testPrimality(n);
            assertEquals("n = " + n, expected, calculated);
        }

        for(int i=0; i<primes.length; i++)
            assertTrue(Numbers.testPrimality(primes[i]));

        assertTrue(Numbers.testPrimality(Integer.MAX_VALUE));
    }
}
