package it.car.algoritmi;

public class ShellSort {

	/**
	 * LINK - http://interactivepython.org/runestone/static/pythonds/SortSearch/TheShellSort.html
	 * YOUTUBE - https://www.youtube.com/watch?v=M9YCh-ZeC7Y
	 */

	public static int[] sort(int[] arr) {
		int[] arrRes = arr;

		int size = arr.length - 1;
//		print(arr);
		sort(arrRes, 0, size/2);

		return arrRes;
	}

	private static void sort(int[] arr, int pFirst, int pSecond) {
		int first = pFirst;
		int second = pSecond;
		if(second > first){
			for(int i = 0; i < arr.length; i++){
				if((second +i) < arr.length){
					if(arr[first + i] > arr[second +i]){
						
						exchange(arr, first + i, second +i);
//						print(arr);
						int newFirst = (first + i) -(second - first);
						int newSecond = (second + i) -(second - first);
						if(newFirst >= 0){
							second = newSecond ;
							first = newFirst;
							i = -1;
						}

					}
				}
			}

			sort(arr, 0, pSecond/2);
		}


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
