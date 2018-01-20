package it.car.yelp.intrw.bitmanipulation;


public class FindMinimumRotateSortArray {

	public static void main(String args[]){
		System.out.println("min:" + findMin(new int[]{0,1,1,2,0,0}));
	}

	public static int findMin(int[] nums) {

		int res = -1;
		int index = -1;

		index = recursive(nums, 0, nums.length - 1);
		System.out.println("index[" + index + "]");

		return nums[index];
	}
	// 8 1 2 3 4 5 6 7
	// 2 3 4 5 6 7 8 1
	// 5 6 7 8 1 2 3 4 

	// 0 1 2 3 4 5 6 7

	private static int recursive(int[] nums, int start, int end) {

		if(nums.length == 1 || (nums.length == 2 && nums[0]<=nums[1]))
			return 0;
		else if(nums.length == 2)
			return 1;


		if(end == start){
			return start;
		}

		if(end == start+1)
			if(nums[start]<=nums[end]){
				return start;
			}else
				return end;

		int mid = (start + end) /2;
		int res = start>0?start:0;
		int incR = 1;
		int incL = 1;

		while(nums[mid] == nums[mid-incL] && nums[mid] == nums[mid+incR] && (mid + incR+1)<nums.length && (mid - incL-1)>=0){
			incR++;
			incL++;
		}
		
		while(nums[mid] == nums[mid-incL] && (mid - incL-1)>=0){
			incL++;
		}
		
		while(nums[mid] == nums[mid+incR] && (mid + incR+1)<nums.length){
			incR++;
		}

		if(nums[mid] == nums[mid+incR]){
			if(nums[mid]>nums[end])
				return recursive(nums, mid+incR, end);
			else
				return recursive(nums, start, (mid-mid+incL));
		}

		if(nums[mid] > nums[mid+incR]){
			return mid+1;
		}

		if(nums[mid] < nums[mid-incL]){
			return mid;
		}

		if(nums[mid] < nums[start]){
			return recursive(nums, start, (mid-incL));
		}


		return recursive(nums, mid+incR, end);
	}



}
