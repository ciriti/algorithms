package it.coursera.algoritmi;

public class QuickFindUF extends AUnion{

	@Override
	public boolean connected(int p, int q){
		if(id[p] == id[q])
			return true;
		return false;
	}

	@Override
	public void union(int p, int q){
		int valP = id[p];
		int valQ = id[q];
		for(int i = 0; i < 10; i++){
			if(id[i] == valP){
				id[i] = valQ;
			}
		}
	}

	public static void main(String args[]){
		QuickFindUF quick = new QuickFindUF();
		
		quick.union(0, 5);
		quick.union(6, 5);
		quick.union(1, 2);
		quick.union(6, 1);
		quick.union(7, 2);
		
		quick.union(8, 3);
		quick.union(4, 3);
		quick.union(4, 9);
		
		quick.print();
	}

}
