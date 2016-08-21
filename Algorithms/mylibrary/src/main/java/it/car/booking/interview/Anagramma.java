package it.car.booking.interview;

import java.util.Arrays;

public class Anagramma {
	
	public static void main(String args[]){
		System.out.println(isAnagramma("ciao", "cia")); //false
		System.out.println(isAnagramma("aaabb", "bbaba")); //false
		System.out.println(isAnagramma("ciao", "caio")); // true
		
		System.out.println("-------------------------------");
		
		System.out.println(isAnagramma2("ciao", "cia")); //false
		System.out.println(isAnagramma2("aaabb", "bbaba")); //false
		System.out.println(isAnagramma2("ciao", "caio")); // true
		
		System.out.println("-------------------------------");
		
		long start = System.nanoTime();
		System.out.println(isAnagramma("aaabb", "bbaba"));
		System.out.println("isAnagramma[" + (System.nanoTime() - start) + "]");
		
		start = System.nanoTime();
		System.out.println(isAnagramma2("aaabb", "bbaba"));
		System.out.println("isAnagramma2[" + (System.nanoTime() - start) + "]");
	}
	
	public static boolean isAnagramma2(String s1, String s2){
		
		if(s1.length()!=s2.length()) return false;
		
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		for(int i = 0; i < s1.length(); i++){
			if(arr1[i]!=arr2[i]){}
		}
		
		for(int i = 0; i < s1.length(); i++){
			if(arr1[i]!=arr2[i])
				return false;
		}
		
		return true;
	}
	
	public static boolean isAnagramma(String s1, String s2){
		
		if(s1.length()!=s2.length()) return false;
		
		int[] arr1 = new int[256];
		int[] arr2 = new int[256];
		
		for(int i = 0; i < s1.length(); i++){
			arr1[s1.charAt(i)]++;
			arr2[s2.charAt(i)]++;
		}
		
		for(int i = 0; i < s1.length(); i++){
			if(arr1[s1.charAt(i)]!=arr2[s1.charAt(i)])
				return false;
		}
		
		return true;

	}
}
