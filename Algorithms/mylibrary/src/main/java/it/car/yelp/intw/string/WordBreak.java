package it.car.yelp.intw.string;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	/**
	 * 
	 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
	 * For example, given 
	 * s = "leetcode", 
	 * dict = ["leet", "code"]. 
	 * 
	 * Return true because "leetcode" can be segmented as "leet code".
	 * 
	 * LINK-  http://www.programcreek.com/2012/12/leetcode-solution-word-break/
	 * 
	 * https://leetcode.com/problems/word-break/
	 */


	public static boolean wordBreak(String s, Set<String> wordDict) {

		if(s==null || wordDict.size()==0) return false;

		StringBuilder sb = new StringBuilder();

		for(String word : wordDict){
			sb.append(word).append("|");
		}
		String regex = "(" + sb.toString().substring(0, sb.length()-1) + ")*";
		return s.matches(regex);
	}
	
	public static void main(String args[]){
		Set<String> wordDict = new HashSet<>();
		wordDict.add("a");
		wordDict.add("b");
		System.out.println(wordBreak("ab", wordDict));
	}

}
