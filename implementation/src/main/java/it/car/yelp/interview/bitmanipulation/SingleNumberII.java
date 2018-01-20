package it.car.yelp.intrw.bitmanipulation;

import java.util.Arrays;

public class SingleNumberII {

	public static void main(String args[]){
		System.out.println(singleNumber(new int[]{-2,-2,1,1,-3,1,-3,-3,-4,-2}));
	}

	public static int singleNumber(int[] nums) {

		if(nums == null || nums.length == 0)
			return 0;

		if(nums.length<3){
			return nums[0];
		}


		Arrays.sort(nums);
		int res = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i +=3){
			if((i+2<nums.length)&&(nums[i]!=nums[i+1]||nums[i+2]!=nums[i+1]))
				return nums[i];
		}

		int outRange = nums.length%3;

		if(res == Integer.MIN_VALUE && outRange != 0)
			return nums[nums.length-1];

		return res;
	}

}
