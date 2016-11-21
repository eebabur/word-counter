package com.example.emrebabur.wordcounter;

import com.example.emrebabur.wordcounter.util.Words;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by emre.babur on 21.11.2016.
 */
public class WordsUnitTest {
    @Test
    public void strip() {
        String[] expected;
        String[] calculated;

        expected = new String[]{"this", "is", "the", "result"};
        calculated = Words.strip("This is the result.");
        assertArrayEquals(expected , calculated);

        expected = new String[]{"here", "i", "come"};
        calculated = Words.strip("HEre I @$@$ C^#O#ME                  @!!@#!");
        assertArrayEquals(expected , calculated);

        expected = new String[]{"nice", "try", "but", "no", "cigar"};
        calculated = Words.strip(" ! ! !    Nice    Try   But No Cigar !!!!");
        assertArrayEquals(expected , calculated);

        expected = new String[]{};
        calculated = Words.strip("@#%#%#%#$@$%^$%^#%$@#$@^%#^#%                     ");
        assertArrayEquals(expected , calculated);

        expected = new String[]{};
        calculated = Words.strip("                                          ");
        assertArrayEquals(expected , calculated);

        expected = new String[]{"this", "is", "correct"};
        calculated = Words.strip("This\nis\ncorrect!");
        assertArrayEquals(expected , calculated);
    }
}
