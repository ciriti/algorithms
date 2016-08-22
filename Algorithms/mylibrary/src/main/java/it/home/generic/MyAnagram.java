package it.home.generic;
import java.util.ArrayList;
import java.util.Collections;


public class MyAnagram {
	
	/**
	 * scambia due elementi in una collezione
	 */
	private static void swap(ArrayList<String> charArr, int i, int j) {
		Collections.swap(charArr, i, j);
	}
	
	/**
	 *  con n caratteri ho n! combinazioni di parole
	 */
	public static void makeAnagram(ArrayList<String> charArr, int i){

		if(i == (charArr.size()-1)){
			printArray(charArr);
		}else{
			for(int j = i; j<charArr.size(); j++){

				swap(charArr, i, j);
				makeAnagram(charArr, i+1);
				swap(charArr, i, j);
			}
		}
	}
	
	/**
	 * --------------------------------------------------------------------------------
	 */
	
	private static void anagramma() {
		// TODO Auto-generated method stub
		String test = "abcdefg";

		char[] charArr = test.toCharArray();

		ArrayList<String> testArr = new ArrayList<String>();
		testArr.add("a");
		testArr.add("b");
		testArr.add("c");
		testArr.add("c");

		makeAnagram(testArr, 0);
	}

	public static void main(String args[]){

		anagramma();
//		System.out.println("is Palindrome? " + palindrome());
	}

	private static boolean palindrome() {
		// TODO Auto-generated method stub
		String test = "ca";
		char[] charTest = test.toLowerCase().toCharArray();
		int dim = test.length();
		if(dim<2) return false;
		for(int i = 0; i < dim/2; i++){
			if(charTest[i]!=charTest[(dim-1)-i]){
				return false;
			}
		}
		return true;

	}


	public static void makeAnagram(char[] charArr, int i){

		if(i == (charArr.length-1)){
			printArray(charArr);
		}else{

			for(int j = i; j<charArr.length; j++){

				swap(charArr, i, j);
				makeAnagram(charArr, i+1);
				swap(charArr, i, j);
			}
			//			

		}

	}

	private static void swap(char[] charArr, int i, int j) {
		// TODO Auto-generated method stub
		char c = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = c;
	}

	

	private static void printArray(char[] charArr) {
		System.out.print(charArr);
		System.out.println("");
	}

	private static void printArray(ArrayList charArr) {
		System.out.print(charArr);
		System.out.println("");
	}

}
