package it.car.yelp.intrw.combinator;

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

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>(/** factorial os size of s */);

        // filter palindrome

        Iterator<List<String>> i = res.iterator();

        return res;
    }


    public static void main(String args[]){
        System.out.println(partition("aab"));
    }
}
