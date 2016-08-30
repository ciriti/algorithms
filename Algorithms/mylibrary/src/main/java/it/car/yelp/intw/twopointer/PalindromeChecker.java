package it.car.yelp.intw.twopointer;

/**
 * Valid Palindrome
 * LINK - https://leetcode.com/problems/valid-palindrome/
 * @author carmelo.iriti
 *
 */
public class PalindromeChecker {

	public static void main(String args[]){
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindromeImprove("ab"));
	}

	public static boolean isPalindrome(String s) {
		s = s.replaceAll("[^a-zA-Z]", "").toLowerCase(); // TODO write a regex
		if(s.length()<=1) return false;
		for(int i = 0; i < s.length(); i ++){
			if(s.charAt(i)!=s.charAt(s.length()-1-i))
				return false;
		}
		return true;
	}

	public static boolean isPalindrome2(String s) {
		int start = 0;
		int end = s.length()-1;
		s = s.toLowerCase();
		while(start<end){
			if(isValidChar(s.charAt(start)) && isValidChar(s.charAt(end))){
				if(s.charAt(start) != s.charAt(end))
					return false;
				start++;
				end--;
			}else{
				if(!isValidChar(s.charAt(start))) start++;
				if(!isValidChar(s.charAt(end))) end--;
			}

		}

		return true;
	}



	private static boolean isValidChar(char charAt) {
		if((charAt>='a' && charAt<='z') || 
				(charAt>='A' && charAt<='Z') ||
				(charAt>='0' && charAt<='9')){
			return true;

		}
		return false;
	}

	public static void testRegex(){
		String s = "abc 12d shd67 6f9,";
		s = s.replaceAll("[a-z0-9],", "*\1*");
		System.out.println(s);
	}

	public static boolean isPalindromeImprove(String s) {

		s = s.replaceAll("[^\\w+]", "").toLowerCase();

		int start = 0;
		int end = s.length()-1;

		while(start < end){
			if(s.charAt(start)!=s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}

		return true;
	}


}
