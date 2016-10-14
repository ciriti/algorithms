package it.car.wayfair.backtracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by carmeloiriti, 13/10/16.
 */
public class PalindromePartitioning {

    /**
     * LINK - https://leetcode.com/problems/palindrome-partitioning/
     */

    /**

     Given a string s, partition s such that every substring of the partition is a palindrome.

     Return all possible palindrome partitioning of s.

     For example, given s = "aab",
     Return

     [
     ["aa","b"],
     ["a","a","b"]
     ]

     */

    public static List<String> partition(String s) {
        List<String> res = new ArrayList<>(/** factorial os size of s */);

        // filter palindrome
        rec(res, "", s);

        return res;
    }

    public static void rec(List<String> res, String tmp, String original ){
        res.add(tmp);
        if(original.length() == 0)
            return;
        for(int i = 0; i < original.length(); i++){
            String s = tmp + original.substring(i, i+1);
            if(!isPalindrome(s))
                continue;
            rec(res, s, original.substring(i+1));

        }
    }

    public static boolean isPalindrome(String s){
        int lo = 0;
        int up = s.length()-1;
        while(lo < up){
            if(s.charAt(lo) != s.charAt(up))
                return false;
            lo++;
            up--;
        }
        return true;
    }


    public static void main(String args[]){
        System.out.println(partition("aabaa"));
    }
}
