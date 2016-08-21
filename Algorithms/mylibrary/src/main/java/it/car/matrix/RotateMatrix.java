package it.car.matrix;

public class RotateMatrix {
	
	public static String[][] rotateMatrixOrario(String[][] matrix, int qDim){
		String[][] matrixRes = new String[qDim][qDim];
		for(int i = 0; i < qDim; i++){
			for(int k = 0; k < qDim; k++){
				matrixRes[k][qDim-1-i] = matrix[i][k];;
			}
		}
		
		return matrixRes;
	}
	
	public static String[][] rotateMatrixAntiOrario(String[][] matrix, int qDim){
		String[][] matrixRes = new String[qDim][qDim];
		for(int i = 0; i < qDim; i++){
			for(int k = 0; k < qDim; k++){
				matrixRes[qDim-1-k][i] = matrix[i][k];;
			}
		}
		
		return matrixRes;
	}

	public static void main(String args[]){
		
		String[][] matrix;
		int qDim = 4;
		
		matrix = fillMatrix(qDim);
		printMatrix(matrix, qDim);
		System.out.println("------------------------");
		printMatrix(rotateMatrixOrario(matrix, qDim), qDim);
		System.out.println("------------------------");
		printMatrix(rotateMatrixAntiOrario(matrix, qDim), qDim);

	}
	
	public static void printMatrix(String[][] matrix, int qDim){
		for(int i = 0; i < qDim; i++){
			for(int k = 0; k < qDim; k++){
				System.out.print(String.format("%6s", matrix[i][k]));;
			}
			System.out.println("\n");
		}
	}
	
	public static void  swap(String a, String b){
		String c = a;
		a = b;
		b = c;
	}

	public static String[][] fillMatrix(int qDim){
		String[][] matrix = new String[qDim][qDim];
		for(int i = 0; i < qDim; i++){
			for(int k = 0; k < qDim; k++){
				matrix[i][k] = String.valueOf(i) + "-" +String.valueOf(k);
			}
		}
		return matrix;
	}

}
