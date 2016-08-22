package it.coursera.algoritmi.week3;

public class EsercitazioneMergeSort {
	
	public static void main(String arg[]){
		initTestAlgoritmoIntero();
	}
	
	public static void initTestAlgoritmoIntero(){
		int[] a = new int[]{3, 7, 4, 8, 6, 1, 0, 9, 3, 5};
		sort(a);
		for(int elem : a)
			System.out.print(elem + " ");
	}
	
	public static void testAllAlgorhitms(){
		int[] a = new int[]{9, 0, 1, 8, 2, 7, 3, 6, 4, 5};
		sort(a);
	}
	
	
	private static void sort(int[] a) {
		// TODO Auto-generated method stub
		int[] aux = java.util.Arrays.copyOf(a, a.length);
		sort(a, aux, 0, aux.length-1);
	}

	private static void sort(int[] a, int[] aux, int lo, int hi) {
		// TODO Auto-generated method stub
		if(lo >= hi) return;
		int mid = lo + (hi-lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}

	/*
	 * a -> 6 7 8 9 10 1 2 3 4 5
	 */
	public static void unitTestMerge(){
		
		int[] a = new int[]{6, 7, 8, 9, 10, 1, 2, 3, 4, 5};
		int[] aux = new int[a.length];
		merge(a, aux, 0, 4, 9);
		
		for(int elem : a)
			System.out.print(elem + " ");
	}
	
	public static void merge(int[] a, int[] aux, int lo, int mid, int hi){
		
//		aux = java.util.Arrays.copyOf(a, a.length);
		
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		int i = lo;
		int j = mid + 1;
		
		for(int k = lo; k <= hi; k++){
			
			if(i > mid){
				a[k] = aux[j++];
			}else if(j > hi){
				a[k] = aux[i++];
			}else if(aux[j] < aux[i]){
				a[k] = aux[j++];
			}else{
				a[k] = aux[i++];
			}
			
		}
	}

}
