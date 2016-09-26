package it.car.wayfair.array;

import java.util.LinkedHashMap;

/**
 * Created by ciriti on 25/09/16.
 */

public class LongestSubstring {
    public static int longestSubstring(String s, int k) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();


        return 0;
    }

    public static void main(String args[]){
        System.out.println(longestSubstring("ababacb", 3) == 0?"SUCCES":"ERROR");
        System.out.println(longestSubstring("aaabb", 3) == 3?"SUCCES":"ERROR");
        System.out.println(longestSubstring("ababbc", 2) == 5?"SUCCES":"ERROR");
    }
}
