package it.car.rotate;

import java.util.Arrays;

public class RotateArray {

	public static void rotateRigth(int[] arr, int k){
		int dim = arr.length;
		/** normalizzare  lo spostamento */
		k = k % dim;

		int[] copy = new int[arr.length];

		for(int i = 0; i < dim; i++){
			/**
			 * Formula matematica per calcolare il nuovo indice
			 */
			int index = (i+k)<dim ? (i+k) : (i+k)%dim;

			System.out.println("original " + i + " new " + index);
			copy[index] = arr[i];
		}
		/** copiare il contenuto del nuovo array nel vecchio */
		System.arraycopy(copy, 0, arr, 0, arr.length);

	}

	public static void main(String[] args) {

		int[] test = new int[]{1,2,3,4,5};
		rotateRigth(test, 2);
		System.out.println(Arrays.toString(test));

	}


}
