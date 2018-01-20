package it.car.yelp.intrw.array;

public class RotateArray {
	
	/**
	 * Rotate Array
	 * Rotate an array of n elements to the right by k steps.
	 * 
	 * https://leetcode.com/problems/rotate-array/
	 */
	
	public static void main(String args[]){
		int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
		rotateRight(a, 3);
		print(a);
		rotateLeft(a, 3);
	}
	
	public static void rotateRight(int[] nums, int k) {
		int[] tmp = new int[nums.length];
		k = k%nums.length;
		for(int i = 0; i < nums.length; i++){
			tmp[(i+k)%nums.length] = nums[i];
		}
		System.arraycopy(tmp, 0, nums, 0, nums.length);
	}
	
	public static void rotateLeft(int[] nums, int k) {
		int[] tmp = new int[nums.length];
		k = k%nums.length;
		for(int i = 0; i < nums.length; i++){
			
		}
		System.arraycopy(tmp, 0, nums, 0, nums.length);
	}
	
	static void print(int[] a){
		for(int b : a){
			System.out.print(b + " ");
		}
		System.out.println();
	}

}
