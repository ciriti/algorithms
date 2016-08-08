package it.car.yelp.interview.pi;

public class ClimbStairs {

	/**
	 * https://leetcode.com/problems/climbing-stairs/
	 * 
	 * si risolve con fibonacci
	 * 
	 * @param args
	 */

	public static int climbStairs(int n) {
		int[] nums = new int[n+1];
		nums[0] = 1;
		nums[1] = 1;
		for(int i = 2; i < nums.length; i++){
			nums[i] = nums[i-1] + nums[i-2];
		}
		return nums[nums.length-1];
	}

	/**
	 * more speed 
	 * @param args
	 */
	public int climbStairs2(int n) {

		int prec2 = 1;
		int prec = 1;
		int actual = 1;
		for(int i = 2; i <= n; i++){
			actual = prec + prec2;
			prec2 = prec;
			prec = actual;
		}

		return actual;
	}

	public static void main(String args[]){
		System.out.println(climbStairs(4));
	}

}
