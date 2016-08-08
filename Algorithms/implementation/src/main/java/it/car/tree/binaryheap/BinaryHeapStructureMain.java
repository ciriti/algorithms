package it.car.tree.binaryheap;

public class BinaryHeapStructureMain {

	public static void main(String args[]){

		BinaryHeapStructure<Integer> bh = new BinaryHeapStructure<>(20);

		for(int i = 0; i < 19; i++){
			if(i%2==0)
				bh.add(Integer.valueOf(i));
			else{
				bh.add(Integer.valueOf(18-i));
			}
		}

		for(int i = 0; i < 19; i++){
			System.out.print(bh.getMax() + " ");
		}


	}

}
