package it.car.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Created by ciriti on 04/09/16.
 */

public class LengthOfLastWord {

    /**
     *
     * LINK - https://leetcode.com/problems/length-of-last-word/
     *
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
     * If the last word does not exist, return 0.
     * Note: A word is defined as a character sequence consists of non-space characters only.
     * For example,
     * Given s = "Hello World",
     * return 5.
     */

    public static void main(String arg[]){
        System.out.println(new LengthOfLastWord().lengthOfLastWord("a   b   "));
        Arrays.sort(new int[]{});
        Collections.sort(null);
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() < 2) return s.length();
        int count = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ' ')break;
            count++;
        }
        return count;
    }

}
