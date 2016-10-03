package it.car.wayfair.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by carmeloiriti, 23/09/16.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * LINK - https://leetcode.com/problems/longest-substring-without-repeating-characters/
     */

    /**
     * Complexity -> O(n^2)
     * @param s
     * @return
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
    public static int lengthOfLongestSubstringImprooved(String s) {

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
                visitedChar[s.charAt(i)] = -1;
            }
        }
        max = (max > maxTmp)? max : maxTmp;
        return max;
    }

    /**
     * Complexity -> O(n)
     * @param s
     * @return
     */

    public static int lengthOfLongestSubstringMap(String s) {
        int dim = s.length();
        if(dim == 1 || dim == 0){
            return dim;
        }

        int max = 0;

        int[] visitedChar = new int[128];
        Arrays.fill(visitedChar, -1);

        int lo = 0;
        int i = 0;
        while(i < dim){
            char c = s.charAt(i);
            if(visitedChar[c] != -1){
                lo = Math.max(lo, visitedChar[c] + 1);
            }
            visitedChar[c] = i;
            max = Math.max(max, i - lo + 1);
            i++;
        }

        return max;
    }

    public static int lengthOfLongestSubstringT(String s) {
        if(s.length() < 2) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int lo = 0;
        int max = 0;
        for(int up = 0; up < s.length(); up++){
            char c = s.charAt(up);
            if(map.containsKey(c)){
                max = Math.max(max, up - Math.max(lo, map.get(c)));
                lo = Math.max(lo, map.get(c)) + 1;
            }
            max = Math.max(max, up - lo +1);
            map.put(s.charAt(up), up);
        }

        return max;
    }

    public static void main(String args[]){

        System.out.println(lengthOfLongestSubstringT("abcabcbb") == 3?"SUCCES":"ERROR");
        System.out.println(lengthOfLongestSubstringT("bbbbb") == 1?"SUCCES":"ERROR");
        System.out.println(lengthOfLongestSubstringT("pwwkew") == 3?"SUCCES":"ERROR");
        System.out.println(lengthOfLongestSubstringT("dvdf") == 3?"SUCCES":"ERROR");
        System.out.println(lengthOfLongestSubstringT("ckilbkd") == 5?"SUCCES":"ERROR");
        System.out.println(lengthOfLongestSubstringT("abba") == 2?"SUCCES":"ERROR");
    }
}
