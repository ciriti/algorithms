package it.car.yelp.intrw.string;

public class LongestCommonPrefix {
	
	/**
	 * Longest Common Prefix
	 * 
	 * LINK - https://leetcode.com/problems/longest-common-prefix/
	 * SOLUTION - http://www.lifeincode.net/programming/leetcode-longest-common-prefix-java/
	 * @param strs
	 * @return
	 */

	 public String longestCommonPrefix(String[] strs) {
	        // create the aoutput
	        StringBuffer sb = new StringBuffer();
			
			//limit case
			if(strs ==  null || strs.length == 0) return sb.toString();
			if(strs.length ==  1) return strs[0];
			
			String[] arr = strs;
			
			// for each char of the first string check if all other string have the same char in the same position
			for(int i = 0; i < arr[0].length(); i++){
				for(int j = 1; j < arr.length; j++){
				    // if the j-th string has less char than the first return the sb
					if(i >= arr[j].length())
					    return sb.toString();
					// if the j-th string has the i-th char different from the i-th of the first string return the sb
					if(arr[j].charAt(i) != arr[0].charAt(i)){
					    return sb.toString();
					}
				}
				sb.append(arr[0].charAt(i));
			}
			
			return sb.toString();
	    }

}
