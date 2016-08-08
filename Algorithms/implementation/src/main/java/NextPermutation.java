import java.util.Arrays;

public class NextPermutation {

	/**
	 * LINK - https://leetcode.com/problems/next-permutation/
	 * 
	 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

	 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

	 The replacement must be in-place, do not allocate extra memory.

	 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	 1,2,3 → 1,3,2
	 3,2,1 → 1,2,3
	 1,1,5 → 1,5,1
	 */

	public static void main(String[] args){
		int[] nums = new int[]{0, 1, 2, 5, 3, 3, 0};
		int[] nums1 = new int[]{3,2,1};
		nextPermutation(nums);
	}

	/**
	 * 1. find the largest i such that nums[i] < nums[i+1]
	 * 2. find the largest j such that j>i and nums[j] > nums[i-1]
	 * 3. swap nums[j] with nums[i-1]
	 * 4. reverse the order of the sub sequence from i to the end of the string
	 * @param nums
	 */
	public static void nextPermutation(int[] nums) {
		int i = nums.length-1;
		int j = nums.length-1;
		
		for(int k = nums.length-1; k >0; k--){
			if(nums[k]>nums[k-1]){
				i = k;
				break;
			}
		}
		
		for(int k = nums.length-1; k >= i; k--){
			if(nums[k]>nums[i-1]){
				j = k;
				break;
			}
		}
		
		int copy = nums[i-1];
		nums[i-1] = nums[j];
		nums[j] = copy;
		
		int c;
		
		for(int ii = i; ii < nums.length; ii ++){
			c = nums[ii];
			nums[ii] = nums[nums.length-1-ii];
			nums[nums.length-1-ii] = c;
		}
		
		for(int ii = 0; ii < nums.length; ii ++){
			System.out.print(nums[ii] + ",");
		}
		
	}

}
