package it.car.algoritmi;

import java.util.Arrays;

public class MergeSort {

	/**
	 * LINK - http://interactivepython.org/runestone/static/pythonds/SortSearch/TheMergeSort.html
	 */
	
	/**
	 * Analisys
	 * 
	 * In order to analyze the mergeSort function, we need to consider the two distinct processes that make up its implementation. 
	 * First, the list is split into halves. We already computed (in a binary search) that we can divide a list in half logn times where n is the length of the list. 
	 * The second process is the merge. Each item in the list will eventually be processed and placed on the sorted list. 
	 * So the merge operation which results in a list of size n requires n operations. The result of this analysis is that logn splits, 
	 * each of which costs n for a total of nlogn operations. A merge sort is an O(nlogn) algorithm. 
	 * 
	 * Recall that the slicing operator is O(k) where k is the size of the slice. 
	 * In order to guarantee that mergeSort will be O(nlogn) we will need to remove the slice operator. 
	 * Again, this is possible if we simply pass the starting and ending indices along with the list when we make the recursive call. 
	 */
	
	/**
	 * 
	 * @param arr
	 * @return
	 */
	
	public static int[] sort(int[] arr) {
		if(arr.length <= 1)
			return arr;
		int start = 0;
		int finish = arr.length;
		int[] first = sort(Arrays.copyOfRange(arr, start, (finish-start)/2));
		int[] second = sort(Arrays.copyOfRange(arr,start+((finish-start)/2), finish));
		int[] res = new int[first.length + second.length];
		int coutFirst = 0;
		int coutSecond = 0;
		for(int k = 0; k < res.length; k++){
			if(coutFirst < first.length && coutSecond < second.length){
				if(first[coutFirst]<second[coutSecond]){
					res[k] = first[coutFirst];
					coutFirst++;
				}
				else{
					res[k] = second[coutSecond];
					coutSecond++;
				}

			}else if(coutFirst < first.length){
				res[k] = first[coutFirst];
				coutFirst++;
			}else if(coutSecond < second.length){
				res[k] = second[coutSecond];
				coutSecond++;
			}
		}
		return res;
	}

	/**
	 * scambia 2 valori in un array
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static void exchange(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void print(int[] res){
		for(int i : res){
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String args[]){
		int[] arr = new int[]{101, 1, 67, 2, 23, 90};
		int[] res = sort(arr);
		for(int i : res){
			System.out.print(i + " ");
		}

	}

}
