package it.coursera.algoritmi;

public abstract class AUnion {
	
	int[] id;

	public AUnion(){
		id = new int [10];
		for(int i = 0; i<10; i++){
			id[i] = i;
		}
	}

	public abstract boolean connected(int p, int q);

	public abstract void union(int p, int q);

	public void print(){
		for(int i : id)
			System.out.print(i + " - ");
	}

}
