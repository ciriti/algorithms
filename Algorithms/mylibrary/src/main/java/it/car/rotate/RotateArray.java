package it.car.rotate;

public class RotateArray {

	public static void main(String args[]){
//		rotateArray();
//		identical(1);
		int[] arr = new int[10];
		for (int i = 0; i< 10; i++) {
			arr[i] = i;
		}
		rotateArray1(arr, 2);
	}

	private static void rotateArray1(int[] arr, int rot) {
		// TODO Auto-generated method stub
		
		for(int j = 0; j < arr.length; j++){
			System.out.print(String.format("%3d", arr[j]));
		}
		System.out.println();
		
		int rotate = (arr.length + rot) % arr.length;
		for(int j = 0; j < arr.length; j++){
			
			int index = (rotate + j) % arr.length;
			
			int temp = arr[j];
			arr[j] = arr[index];
			arr[index] = temp;
			
		}
		
		for(int j = 0; j < arr.length; j++){
			System.out.print(String.format("%3d", arr[j]));
		}
	}

	public static int[] rotate(int[] array, int count) {
		int length = array.length;
		if (length == 0 || count % length == 0)
			return array;
		int modulo = count % length;
		count = (modulo + length) % length; // limit and make positive
		//		count = count % length;
		int[] dest = new int[length];
		for (int i=0; i<length; i++) {
			int index = (i + count) % length;
			dest[index] = array[i];
		}
		return dest;
	}

	private static void rotateArray() {
		// TODO Auto-generated method stub
		int[] arrayInt = new int[5];
		for(int i = 0; i<5; i++){
			arrayInt[i] = i;
		}

		String[] arrayString = new String[5];
		for(int i = 0; i<5; i++){
			arrayString[i] = String.valueOf(i);
		}
		printArray(arrayString);
		System.out.println("------------------------------------");
		printArray(rotateArray(arrayString, 1));
	}


	private static String[] rotateArray(String[] array, int position) {

		int dim = array.length;
		if(dim == 0 || ((dim + position) % dim) == 0){
			return array;
		}

		/**
		 * IMPORTANTE!!!! tramite questa riga io ruoto a destra o sinistra a seconda se la posizione è negativa o positiva
		 */
		position = (dim + position) % dim;

		String[] newArray = new String[dim];
		for (int i = 0; i < dim; i++){
			/**
			 * calcolo di volta in volta l'indice
			 */
			int index = (i + position) % dim;
			newArray[index] = array[i];
		}
		return newArray;
	}

	public void swapArray(String[] newArray, int i, int j){
		String tmp = newArray[i];
		newArray[i] = newArray[j];
		newArray[j] = tmp;
	}

	private static void printArray(String[] array) {
		// TODO Auto-generated method stub
		for(int i = 0; i<array.length; i++){
			System.out.print(String.format("%3s", array[i]));
		}
		System.out.println("");
	}

	private static void printArray(int[] array) {
		// TODO Auto-generated method stub
		for(int i = 0; i<array.length; i++){
			System.out.print(String.format("%3s", array[i]));
		}
		System.out.println("");
	}

	public static <T> T identical(T source){
		return source;
	}


}
