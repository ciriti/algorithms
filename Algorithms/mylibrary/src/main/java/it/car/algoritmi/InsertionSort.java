package it.car.algoritmi;

public class InsertionSort {
	
	/**
	 * LINK - http://interactivepython.org/runestone/static/pythonds/SortSearch/TheInsertionSort.html
	 */
	
	/**
	 * Analisys for n elements:
	 * 
	 * n + (n - 1) + (n - 2) + (n - 3) + (n - 4) + ... + (n - n -1 ) + 0 ---->  O(n) = 1/2 n^2
	 * 
	 * @param arr
	 * @return
	 */
	
	
	public static int[] sort(int[] arr){
		int[] arrRes = arr;
		
		for(int i = 0; i < arrRes.length; i++){
			int count = i;
			while(count > 0){
				
				if(arrRes[count]<arrRes[count-1]){
					exchange(arrRes, count-1, count);
				}
				count --;
			}
		}
		
		return arrRes;
	}
	
	public static void exchange(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String args[]){
		int[] arr = new int[]{101, 1, 67, 2, 23, 90};
		int[] res = sort(arr);
		for(int i : res){
			System.out.print(i + " ");
		}
	}

}
