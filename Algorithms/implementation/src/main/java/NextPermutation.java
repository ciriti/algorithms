import java.util.Arrays;

public class NextPermutation {

	/**
	 * LINK - https://leetcode.com/problems/next-permutation/
	 * LIKN - https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
	 *
	 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

	 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

	 The replacement must be in-place, do not allocate extra memory.

	 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	 1,2,3 → 1,3,2
	 3,2,1 → 1,2,3
	 1,1,5 → 1,5,1
	 */

	/**
	 Input: 	[1,5,1]
	 Output: 	[1,1,5]
	 Expected: 	[5,1,1]
	 * @param args
	 */



	public static void main(String[] args){
		// res : 0, 1, 3, 0, 2, 3, 5
		int[] nums = new int[]{0, 1, 2, 5, 3, 3, 0};
		int[] nums1 = new int[]{3,2,1};
		int[] nums2 = new int[]{1,5,1};
		nextPermutation(nums2);
	}

	/**
	 * 1. find the largest i such that nums[i] < nums[i+1]
	 * 2. find the largest j such that j>i and nums[j] > nums[i-1]
	 * 3. swap nums[j] with nums[i-1]
	 * 4. reverse the order of the sub sequence from i to the end of the string
	 * @param nums
	 */
	public static void nextPermutation(int[] nums) {
		int i = nums.length - 1;

		/**
		 * 1. find the largest i such that nums[i] < nums[i+1]
		 */

		while(i > 0 &&  nums[i-1] >= nums[i]){
			i--;
		}

		if(i == 0){
			Arrays.sort(nums);
			System.out.print(Arrays.toString(nums));
			return;
		}


		int j = nums.length - 1;

		while(i > 0 && j > i && nums[j] <= nums[i-1]){
			j--;
		}


		nums[i-1] = nums[i-1] ^nums[j];
		nums[j] = nums[i-1] ^nums[j];
		nums[i-1] = nums[i-1] ^nums[j];

		/*
		x = x xor y
		y = x xor y
		x = x xor y
		*/


		/** reverse array */
		j = nums.length - 1;
		while( i < j){
			nums[i] = nums[i] ^ nums[j];
			nums[j] = nums[i] ^ nums[j];
			nums[i] = nums[i] ^ nums[j];
			i++;
			j--;
		}

		System.out.print(Arrays.toString(nums));

	}

}
