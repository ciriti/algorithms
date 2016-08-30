package it.car.yelp.intw.pi;

public class UniqueBinarySearchTrees {
	
	/**
	 * 
	 * https://leetcode.com/problems/unique-binary-search-trees/
	 * http://www.lifeincode.net/programming/leetcode-unique-binary-search-trees-i-and-ii-java/
	 * @param args
	 */

	public static void main(String args[]){
		for(int i = 1; i < 6; i++)
			System.out.println("i[" + i + "]: " + numTrees(i));
	}

	public static int numTrees(int n) {

		if(n==1) return 1;

		int[] res = new int[n+1];
		res[0] = 1;

		for(int i = 1; i < res.length; i++){
			for(int j = 0; j<i; j++){
				res[i] = res[i] + res[j]*res[i-j-1];
			}

		}
		return res[n];
	}
}
