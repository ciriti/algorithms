package it.car.algoritmi;

public class BubbleSort {
	
	
	/**
	 * LINK - http://interactivepython.org/runestone/static/pythonds/SortSearch/TheBubbleSort.html
	 */
	
	/**
	 * Analisys for n elements:
	 * 
	 * n + (n - 1) + (n - 2) + (n - 3) + (n - 4) + ... + (n - n -1 ) + 0 ---->  O(n) = 1/2 n^2
	 * 
	 * @param arr
	 * @return
	 */
	
	/**
	 * Scorro l'array facendo "galleggiare" l'elemento minore fino in "superficie"
	 * @param arr
	 * @return
	 */
	
	public static int[] sort(int[] arr){
		int[] arrRes = arr;
		for(int i = 0; i < arrRes.length; i++){
			for(int j = i; j < arrRes.length; j++){
				if(j+1 < arrRes.length && arrRes[j + 1] < arrRes[i])
					exchange(arrRes, j+1, i);
			}
//			int count = i;
//			while(count < arrRes.length){
//				if(count+1 < arrRes.length && arrRes[count + 1] < arrRes[count])
//					exchange(arrRes, count+1, count);
//				count++;
//			}
		}
		return arrRes;
	}
	
//	public static int[] sort(int[] arr){
//		int[] arrRes = arr;
//		for(int i = 0; i < arrRes.length; i++){
//			int count = i;
//			while(count < arrRes.length){
//				if(arr[count]<arr[i])
//					exchange(arrRes, i, count);
//				count++;
//			}
//		}
//		return arrRes;
//	}
	
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
