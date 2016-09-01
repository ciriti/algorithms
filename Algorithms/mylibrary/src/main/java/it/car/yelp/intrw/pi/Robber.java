package it.car.yelp.intrw.pi;

public class Robber {

	public static void main(String args[]){
		int [] arr = new int[]{1,1,1};
		System.out.print(rob1(arr));
		System.out.print("\n"+ rob(arr));
//		System.out.print("\n"+maxSubArray(arr));
	}

	static int maxSubArrayPersonal(int[] A){
		int max = A[0];
		int[] B = new int[A.length];
		B[0] = A[0];
		for(int i = 1; i < B.length; i++){
			B[i] = Math.max(A[i], A[i]+B[i-1]);
			max = Math.max(B[i], A[i]);
		}

		return max;
	}

	/**
	 * https://leetcode.com/problems/house-robber/
	 * @param num
	 * @return
	 */
	public static int rob(int[] num) {
		if (num==null || num.length==0) return 0;
		int maxToPos[] = new int[num.length+1]; //the maximum amount to the i'th house 
		maxToPos[0] = 0;
		maxToPos[1] = num[0];
		for (int i=2; i<maxToPos.length; i++){
			maxToPos[i] = Math.max(maxToPos[i-1],maxToPos[i-2]+num[i-1]);
		}
		return maxToPos[maxToPos.length-1];
	}

	/**
	 * Maximum Subarray (Java) [http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/]
	 * @param A
	 * @return
	 */
	public static int maxSubArray(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];

		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			max = Math.max(max, sum[i]);
		}

		return max;
	}

	public static int rob1(int[] nums) {

		if(nums==null || nums.length < 1) return 0;
		if(nums.length == 1) return nums[0];

		int max = nums[0];

		int[] tmp = new int[nums.length+1];
		tmp[0] = 0;
		tmp[1] = nums[0];

		for(int i = 2; i < tmp.length; i++){
			tmp[i] = Math.max(tmp[i-1], nums[i-1]+tmp[i-2]);
			max = Math.max(max, tmp[i]);
		}

		return max;
	}

}
