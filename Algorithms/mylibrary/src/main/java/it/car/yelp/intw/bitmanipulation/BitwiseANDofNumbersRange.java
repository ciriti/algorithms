package it.car.yelp.intw.bitmanipulation;


/**
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive. 
 * For example, given the range [5, 7], you should return 4.
 * 
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * http://www.programcreek.com/2014/04/leetcode-bitwise-and-of-numbers-range-java/
 * @author carmelo.iriti
 *
 */
public class BitwiseANDofNumbersRange {
	
	public static void main(String args[]){
		System.out.println(rangeBitwiseAnd(5,7));
	}

	public static int rangeBitwiseAnd(int m, int n) {
		
		while(m<n){
			n = n & (n-1);
		}
		
		return n;
	}

}
