package it.car.yelp.interview.string;

public class LongestPalindromicSubstring_more_speed {

	public static void main(String args[]){

		String test = "bb";

		String res = "";
		long start = System.currentTimeMillis();
		res = longestPalindrome(test);
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(res);
	}

	public static String longestPalindrome(String s) {
		if(s==null) return "";
		if(s.length()==1) return s;

		String sb = "";
		for(int i = 0; i < s.length(); i++){
			String res = helper(s,i,i);//
			if(res.length() > sb.length()){
				sb = res;
			}

			String res2 = helper(s,i,i+1);//
			if(res2.length() > sb.length()){
				sb = res2;
			}

		}
		return sb;
	}

	public static String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}

}
