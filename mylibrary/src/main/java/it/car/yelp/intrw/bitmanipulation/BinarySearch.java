package it.car.yelp.intrw.bitmanipulation;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String args[]){

		boolean res = search(new int[]{50, 1, 34, -2, -30, 80, 100}, 50);
		System.out.println(res);
	}

	private static boolean search(int[] is, int i) {
		boolean res = false;
		Arrays.sort(is);

		return binarySearch(is, 0, is.length-1, i);
	}
		//[-30, -2, 1, 34, 50, 80, 100]
	static boolean binarySearch(int[] arr, int start, int end, int target){
		if(start==end && arr[start] == target)
			return true;
		else if(start<end){
			int mid = (start + end) /2;
			if(arr[mid] == target || arr[start] == target || arr[end] == target){
				return true;
			}else if(target < arr[mid]){
				return binarySearch(arr, start, mid-1, target);
			}else{
				return binarySearch(arr, mid+1, end, target);
			}
		}
		return false;
	}

}
