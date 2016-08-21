package it.coursera.algoritmi.week3;

public class QuickSort {

	public static void main(String args[]){
		testPartition();
//		testAlgoritmo();
	}


	private static void testAlgoritmo() {
		// TODO Auto-generated method stub
		int[] a = new int[]{6, 5, 8, 9, 10, 1, 2, 3, 4, 7};
		sort(a);
		for(int elem : a)
			System.out.print(elem + " ");
		
	}

	public static void sort(int[] a)
	{
//		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	private static void sort(int[] a, int lo, int hi)
	{
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}


	private static void testPartition() {
		// TODO Auto-generated method stub
		int[] a = new int[]{6, 5, 8, 9, 10, 1, 2, 3, 4, 7};
		int[] b = new int[]{6, 5, 8, 9, 10, 1, 2, 3, 4, 7};
		for(int elem : a)
			System.out.print(elem + " ");
		System.out.print(" prima \n \n");
		//		System.out.println(partitionPdf(a, 1, a.length-1));
//		partitionPdf(a, 1, a.length -1);
		partition(b, 0, b.length-1);
		System.out.print(" \n  fine \n");
		for(int elem : b)
			System.out.print(elem + " ");
	}

	/*
	 * a -> 6 7 8 9 10 1 2 3 4 5
	 * 1. [6, 5, 8, 9, 10, 1, 2, 3, 4, 7]
	 * 2. [6, 5, 4, 9, 10, 1, 2, 3, 8, 7]
	 * 3. [6, 5, 4, 3, 10, 1, 2, 9, 8, 7]
	 * 4. [6, 5, 4, 3, 2, 1, 10, 9, 8, 7]
	 */
	public static int partitionPdf(int[] a, int p, int r)
	{
		int x 		= a[p];
		int i 		= p - 1;
		int j 		= r + 1;
		boolean fine = false;

		do
		{
			while(a[--j] <= x)
				break;

			while(a[++i] >= x)
				break;

			if(i < j)
				exch(a, i, j);
			else
				fine = true;
		}while(!fine);

		//			if (i >= j) 
		//				break;
		//			exch(a, i, j);
		//			
		//			for(int elem : a)
		//				System.out.print(elem + " ");
		//			System.out.print("\n");
		//		exch(a, p, j);
		for(int elem : a)
			System.out.print(elem + " ");
		System.out.print("\n fine " + j + " \n");
		return j;
	}


	/*
	 * a -> 6 7 8 9 10 1 2 3 4 5
	 * 1. [6, 5, 8, 9, 10, 1, 2, 3, 4, 7]
	 * 2. [6, 5, 4, 9, 10, 1, 2, 3, 8, 7]
	 * 3. [6, 5, 4, 3, 10, 1, 2, 9, 8, 7]
	 * 4. [6, 5, 4, 3, 2, 1, 10, 9, 8, 7]
	 */
	public static int partition(int[] a, int lo, int hi)
	{
		int i = lo;
		int j = hi+1;
		int pivot = a[i];
		
		while (true)
		{
			while (a[++i] < pivot){
				if (i == hi) {
					break;
				}
			}
					
			while (a[--j] > pivot){ 
				if (j == lo) {
					break;
				}
			}

			if (i >= j){
				break;
				
			}
				
			exch(a, i, j);
		}
		
		exch(a, lo, j);
		
		return j;
	}

	private static void exch(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int aElem = a[i];
		a[i] = a[j];
		a[j] = aElem;
	} 


}
