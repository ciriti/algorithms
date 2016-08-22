package it.car.yelp.interview.string;

public class LongestCommonPrefix2 {
	
	/**
	 * http://codereview.stackexchange.com/questions/46965/longest-common-prefix-in-an-array-of-strings
	 * @param strings
	 * @return
	 */
	
	public static String longestCommonPrefix(String[] strings) {
	    if (strings.length == 0) {
	        return "";   // Or maybe return null?
	    }

	    for (int prefixLen = 0; prefixLen < strings[0].length(); prefixLen++) {
	        char c = strings[0].charAt(prefixLen);
	        for (int i = 1; i < strings.length; i++) {
	            if ( prefixLen >= strings[i].length() ||
	                 strings[i].charAt(prefixLen) != c ) {
	                // Mismatch found
	                return strings[i].substring(0, prefixLen);
	            }
	        }
	    }
	    return strings[0];
	}

}
