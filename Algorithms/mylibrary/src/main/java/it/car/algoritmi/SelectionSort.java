package it.car.algoritmi;

public class SelectionSort {

	/**
	 * LINK - http://interactivepython.org/runestone/static/pythonds/SortSearch/TheSelectionSort.html
	 */

	/**
	 * Analisys for n elements:
	 * 
	 * n + (n - 1) + (n - 2) + (n - 3) + (n - 4) + ... + (n - n -1 ) + 0 ---->  O(n) = 1/2 n^2
	 * 
	 * E' pi? veloce del bubble sort perche' esegue un solo confronto per trovare il minimo per
	 * ogni sotto iterazione
	 * 
	 * @param arr
	 * @return
	 */

	public static int[] sort(int[] arr) {
		int[] arrRes = arr;
		for(int i = 0; i < arrRes.length; i++){
			int indexMin = searchIndexMin(arrRes, i);
			exchange(arrRes, indexMin, i);
		}
		return arrRes;
	}

	/**
	 * Ricerca l'indice dell'elemento minore nel sotto array dall'offset in poi
	 * 
	 * @param arr
	 * @param offSet
	 * @return 
	 */
	public static int searchIndexMin(int[] arr, int offSet){
		int indexMin = offSet;
		for(int i = offSet + 1; i < arr.length; i++){
			if(arr[i] < arr[indexMin])
				indexMin = i;
		}
		return indexMin;
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

	public static void main(String args[]){
		int[] arr = new int[]{101, 1, 67, 2, 23, 90};
		int[] res = sort(arr);
		for(int i : res){
			System.out.print(i + " ");
		}
	}


}
