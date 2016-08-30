package it.car.yelp.intw.pi;

public class MaximumProdutSubarray {

	public static void main(String arg[]){
		System.out.println(maxProduct(new int[]{6, -3, -10, 0, 2}));
		String s = "";
	}

	public static int maxProduct(int[] nums) {

		int[] maxLocal = new int[nums.length];
		maxLocal[0] = nums[0];  
		int[] minLocal = new int[nums.length]; 
		minLocal[0] = nums[0];  
		int[] res = new int[nums.length]; 
		res[0] = nums[0];  

		for(int i = 1; i < nums.length; i++){
			maxLocal[i] = Math.max(Math.max(nums[i]*maxLocal[i], nums[i]), nums[i]*minLocal[i]);
			minLocal[i] = Math.min(Math.min(nums[i]*minLocal[i], nums[i]), nums[i]*minLocal[i]);
			res[i] = Math.max(res[i], maxLocal[i]);
		}

		return res[nums.length-1];
	}

}
