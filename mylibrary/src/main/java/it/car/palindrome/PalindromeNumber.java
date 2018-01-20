package it.car.palindrome;

import java.util.Scanner;

public class PalindromeNumber {

	

	private static boolean isPalindrome(int number) {
		if(number == reverse(number)){
			return true;
		}
		return false;
	}

	private static int reverse(int number){
		int reverse = 0;
		while(number != 0){
			reverse = reverse*10 + number%10; 
			number = number/10;
		}
		return reverse;
	}
	
	/**
	 * ------------------------------------------------------------------------------------------------
	 */
	
	/**
	 * MAIN
	 * @param args
	 */
	
	public static void main(String args[]){

		Scanner scanner = new Scanner(System.in);       
		//int number = scanner.nextInt();
		int[] numbers = {102, 101, 1221, 13321, 13331, 0, 11};

		for(int number: numbers){
			System.out.println("Does number : "
					+ number +" is a palindrome? " + isPalindrome(number));
		}             
	}



}
