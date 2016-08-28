package it.car.dynamic;

import java.util.Arrays;

/**
 * Created by carmeloiriti, 24/08/16.
 */
public class Ls {

    /**
     * Longest Substring Without Repeating Characters
     *
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Examples:
     *
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * Given "bbbbb", the answer is "b", with the length of 1.
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    public static void main(String[] args){

        System.out.println(maxSubString("abcabcbb").equals("abc")?"OK":"ERROR");
        System.out.println(maxSubString("bbbbb").equals("b")?"OK":"ERROR");
        System.out.println(maxSubString("pwwkew").equals("wke")?"OK":"ERROR");
        System.out.println(maxSubString("cc").equals("c")?"OK":"ERROR");
        System.out.println(maxSubString("c").equals("c")?"OK":"ERROR");
        System.out.println(maxSubString("au").equals("au")?"OK":"ERROR");
        System.out.println(maxSubString("dvdf").equals("vdf")?"OK":"ERROR");

    }

    public static String maxSubString(String s) {

        if (s.length() == 1 || s.length() == 0) {
            return s;
        }

        int k = 0;
        String res = "";
        int[] charPos = new int[256];
        Arrays.fill(charPos, -1);

        for(int i = 0; i < s.length(); i ++){
            if(charPos[s.charAt(i)] >= k){

                String tmp = s.substring(k, i);
                if(tmp.length() > res.length()){
                    res = tmp;
                }

                k = charPos[s.charAt(i)] + 1;
            } if(i == s.length() - 1){
                String tmp = s.substring(k, s.length());
                if(tmp.length() > res.length()){
                    res = tmp;
                }
            }


            charPos[s.charAt(i)] = i;
        }

        return res;
    }

}
