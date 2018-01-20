package it.coursera.algoritmi;

public class QuickUnionUF extends AUnion{
	
	public int root(int idNode){
		int root = idNode;
		while(id[root] != root){
			root = id[root];
		}
		return root;
	}
	
	@Override
	public boolean connected(int p, int q){
		if(root(p) == root(q))
			return true;
		return false;
	}
	
	@Override
	public void union(int p, int q){
		if(!connected(p, q)){
			int pRoot = root(p);
			int qRoot = root(q);
			id[pRoot] = qRoot;
		}
	}
	
	/*
	 * 			ALBERO RISULTANTE
	 * 
	 * 		0			6			4
	 * 		|			|
	 * 		8			2
	 * 					|
	 * 					5
	 * 					|\
	 * 					9 3	
	 * 					|
	 * 					1	 
	 * 					|
	 * 					7 
	 */
	
	public static void main(String args[]){
		QuickUnionUF mUnion = new QuickUnionUF();
		
		mUnion.union(8,0);
		
		mUnion.union(7,1);
		mUnion.union(3,5);
		mUnion.union(1,9);
		mUnion.union(9,5);
		mUnion.union(5,2);
		mUnion.union(2,6);
		
		mUnion.print();
	}


}
