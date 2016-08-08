package it.coursera.algoritmi.week3;

public class MergeSortEx1 {

	static int[] aux;
	static int[] a;

	public static void main(String arg[]){
		initTestAlgoritmoIntero();
	}
	
	
	
	public static void initTestAlgoritmoIntero(){
		int[] a = new int[]{3, 7, 4, 8, 6, 1, 0, 9, 3, 5};
		sort(a);
		for(int elem : a)
			System.out.print(elem + " ");
	}

	public static void unitTestMerge(){
		int[] a = new int[]{6, 7, 8, 9, 10, 1, 2, 3, 4, 5};
		int[] aux = new int[10];
		merge(a, aux, 0, 4, 9);
	}

	/**
	 * I� step
	 * @param a
	 */
	public static void sort(int[] a)
	{
		aux = new int[a.length];
		sort(a, aux, 0, a.length - 1);
	}

	/**
	 * II� step
	 * @param a
	 * @param aux
	 * @param lo
	 * @param hi
	 */
	public static void sort(int[] a, int[] aux, int lo, int hi)
	{
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}


	/*
	 * a -> 6 7 8 9 10 1 2 3 4 5
	 */
	/**
	 * Final steps
	 * @param a
	 * @param aux
	 * @param lo
	 * @param mid
	 * @param hi
	 */
	public static void merge(int[] a, int[]aux, int lo, int mid, int hi){

		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];

		int i = lo, 
			j = mid+1;

		for (int k = lo; k <= hi; k++) 
		{
			if (i > mid) 
				a[k] = aux[j++];
			else if (j > hi) 
				a[k] = aux[i++];
			else if (aux[j]<aux[i]) 
				a[k] = aux[j++];
			else 
				a[k] = aux[i++];
		}
	}

}
