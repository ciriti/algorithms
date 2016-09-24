package it.car.wayfair.string_;

import java.util.Arrays;

/**
 * Created by carmeloiriti, 23/09/16.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * LINK - https://leetcode.com/problems/longest-substring-without-repeating-characters/
     */

    public static int lengthOfLongestSubstring(String s) {

        int[] visitedChar = new int[256];
        Arrays.fill(visitedChar, -1);
        int max = 0;
        int maxTmp = 0;

        int i = 0;

        while(i < s.length()){
            char x = s.charAt(i);
            if(visitedChar[x] == -1){
                visitedChar[x] = i;
                maxTmp++;
                i++;
            }else{
                max = (max > maxTmp)? max : maxTmp;
                maxTmp = 0;
                i = visitedChar[s.charAt(i)] +1;
                Arrays.fill(visitedChar, -1);
            }
        }
        max = (max > maxTmp)? max : maxTmp;
        return max;
    }

    public static void main(String args[]){
        System.out.println(lengthOfLongestSubstring("abcabcbb") == 3?"SUCCES":"ERROR");
        System.out.println(lengthOfLongestSubstring("bbbbb") == 1?"SUCCES":"ERROR");
        System.out.println(lengthOfLongestSubstring("pwwkew") == 3?"SUCCES":"ERROR");
        System.out.println(lengthOfLongestSubstring("dvdf") == 3?"SUCCES":"ERROR");
    }
}
