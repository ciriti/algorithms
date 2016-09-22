package it.car.yelp.intrw.twopointer;

public class MoveZeroToRight {
	
	public static void main(String args[]){
		int[] a = new int[]{1,2,0, 0, 0, 3,8,0,2,2,0,10};
		moveZero(a);
		for(int elem : a)
			System.out.print(elem + " ");
		System.out.println("\n1 2 3 8 2 2 10 0 0 0 0 0");
	}

	private static void moveZero(int[] a) {
		// TODO Auto-generated method stub
		int tmp = -1;
		for(int i = 0; i < a.length; i++){
			if(tmp == -1 && a[i]==0){
				tmp = i;
			}else if(a[i]!=0 && tmp != -1){
				a[tmp] = a[i];
				a[i] = 0;
				tmp++;
			}
		}
	}

}
