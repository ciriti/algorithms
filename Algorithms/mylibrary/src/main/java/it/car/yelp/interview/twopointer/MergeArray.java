package it.car.yelp.interview.twopointer;

public class MergeArray {

	public static void main(String args[]){
		int[] A = new int[20];
		int count = 0;
		for(int i = 1; i < 9; i+=2){
			A[count] = i;
			count++;
		}
		int[] B = new int[]{};

		merge(A, count, B, B.length);

		for(int i = 0; i < 20; i++){
			System.out.print(A[i] + " ");
		}

	}

	public static void merge(int A[], int m, int B[], int n) {

		int tot = n + m - 1;
		int i = m-1;
		int j = n-1; 

		while(tot>=0){
			if(i>=0 && j>=0){
				if(A[i]>B[j]){
					A[tot] = A[i];
					i--;
				}else{
					A[tot] = B[j];
					j--;
				}
			}else if(i>=0){
				A[tot] = A[i];
				i--;
			}else if(j>=0){
				A[tot] = B[j];
				j--;
			}
				
			tot--;
		}
	}

}
