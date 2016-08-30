package it.car.yelp.intw.bitmanipulation;

public class FingMinimumRotate {

	public static void main(String args[]){

		System.out.println(findMin(new int[]{1,2,3,4}));

	}

	public static int findMin(int[] nums) {

		if(nums.length == 1 || nums[0]<nums[nums.length-1])
			return nums[0];

		if(nums.length == 2)
			if(nums[0]<nums[1])
				return nums[0];
			else
				return nums[1];


		return findMinRec(nums, 1, nums.length-2);
	}

	static int findMinRec(int[] nums, int start, int end){

		int mid = (start+end)/2;

		if(nums[mid] > nums[mid+1])
			return nums[mid+1];
		
		else if(nums[mid] < nums[mid-1]){
			return nums[mid];
		}
		
		if(nums[mid] < nums[start - 1])
			return findMinRec(nums, start, mid-1);

		return findMinRec(nums, (mid+1), end);
	}

}
