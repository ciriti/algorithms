package it.car.sort;

public class SelectionSort {
	
	static int count = 0;
	
	public static void main(String a[]){
        
        int[] arr1 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] arr2 = doSelectionSort(arr1);
        for(int i:arr2){
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.print("count[" + count +"]");
    }
	
/*
				I passi sono i seguenti:
				
				si inizializza un puntatore i che va da 1 a n (dove n  la lunghezza dell'array).
				Si cerca il pi piccolo elemento dell'array
				Scambia l'elemento pi piccolo con l'elemento alla posizione i
				Incrementa l'indice i e si torna al passo uno fino alla fine dell'array.	 
*/

	private static int[] doSelectionSort(int[] arr) {
		// TODO Auto-generated method stub
		int dim = arr.length;
		int index;
		for(int i = 0; i<dim-1; i++){
			index = i;
			for(int j = i+1; j<dim; j++ ){
				if(arr[index]>arr[j])
					index = j;
			}
			swapNumbers(index, i, arr);
		}
		return arr;
	}
	
	private static void swapNumbers(int i, int j, int[] array) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		count++;
	}

}
