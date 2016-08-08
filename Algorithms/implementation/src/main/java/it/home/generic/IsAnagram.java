package it.home.generic;

import java.util.Arrays;

public class IsAnagram {
	
	public static void main(String args[]){
		String test1 = "ahsgdf";
		String test2 = "asdfgh";
		long start = 0;
		start = System.nanoTime();
		System.out.println("is anagram: " + isAnagram(test1, test2) + " in ns " + (System.nanoTime()-start));
		start = System.nanoTime();
		System.out.println("is anagram2: " + isAnagram2(test1, test2) + " in ns " + (System.nanoTime()-start));
		start = System.nanoTime();
		System.out.println("is anagram3: " + isAnagram3(test1, test2) + " in ns " + (System.nanoTime()-start));
	}

	private static boolean isAnagram(String test1, String test2) {
		// TODO Auto-generated method stub
		if(test1.length() != test2.length()) return false;
		
		int[] res = new int[256];
		for(int i = 0; i < test1.length(); i++){
			res[test1.charAt(i)]++;
			res[test2.charAt(i)]--;
		}
		
		for(int i = 0; i < test1.length(); i++){
			if(res[test1.charAt(i)]!=0)
				return false;
		}
		
		return true;
	}
	
	private static boolean isAnagram2(String test1, String test2) {
		
		char[] a = test1.toCharArray();
		Arrays.sort(a); 
		char[] b = test2.toCharArray();
		Arrays.sort(b); 
		for(int i = 0; i<a.length; i++){
			if(a[i]!=b[i])
				return false;
		}
		
		return true;
	}
	
	private static boolean isAnagram3(String firstWord, String secondWord){
		char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
	     char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
	     Arrays.sort(word1);
	     Arrays.sort(word2);
	     return Arrays.equals(word1, word2);
	}

}
