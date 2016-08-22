package it.car.yelp.interview.combinator;

import java.util.Arrays;

public class PermutationsOfK {

	/**
	 * with n element and gtoups of size k I can obtain P(n, k) = n! / (n-k)! 
	 */

	public static void main(String args[]){
		int i = 3;
		char [] arr = new char[]{'c','i','a','o'};
		char [] tmp1 = Arrays.copyOfRange(arr, 0, i);
		char [] tmp2 = Arrays.copyOfRange(arr, i+1, arr.length);
		char[] newLength = new char[arr.length-1];
		System.arraycopy(tmp1, 0, newLength, 0, tmp1.length);
		System.arraycopy(tmp2, 0, newLength, tmp1.length, tmp2.length);
		for(char c : newLength){
			System.out.print(c);
		}
		System.out.println();

	}

}
