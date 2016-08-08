package it.car.tree.binaryheap;

public class BinaryHeapStructure<T extends Comparable<T>> {
	
	T[] arr;
	int numElem;
	int size;
	static final int DEFAULT_SIZE = 100;
	static final int START_INDEX = 1;
	
	/**
	 * parent n children 2n and 2n+1
	 * 
	 * http://people.na.infn.it/~murano/LASD0506/LASD0506-nona%20lezione%20-%20Heap%20e%20Heapsort.pdf
	 * @param size
	 */
	
	public BinaryHeapStructure(int size) {
		super();
		this.size = size;
		arr = (T[]) new Comparable[size];
	}
	
	public BinaryHeapStructure() {
		super();
		this.size = DEFAULT_SIZE;
		arr = (T[]) new Comparable[DEFAULT_SIZE];
	}
	
	public boolean add(T item){
		if(numElem == arr.length){
			return false;
		}
		numElem++;
		arr[numElem] = item;
		swim(numElem);
		return true;
	}
	
	private void swim(int size) {
		if(size == 1) return;
		if(arr[size].compareTo(arr[size/2])>0){
			swap(size, size/2);
			swim((size/2));
		}
	}

	public T peekMax(){
		return arr[START_INDEX];
	}
	
	public T getMax(){
		if(numElem == 0) 
			return null;
		T max = arr[START_INDEX];
		arr[START_INDEX] = arr[numElem-1];
		arr[numElem-1] = null;
		numElem--;
		sync();
		return max;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	private void sync(){
		syncRec(START_INDEX);
	}
	
	//TODO
	private void syncRec(int index){
		int indexChild = findIndexMaxChild(index);
		if(indexChild != -1){
			if(arr[index].compareTo(arr[indexChild])<0){
				swap(index, indexChild);
				syncRec(indexChild);
			}
		}
	}
	
	private int findIndexMaxChild(int index){
		if(2*index+1 <= numElem-1)
		if(arr[2*index].compareTo(arr[2*index+1])>0){
			return 2*index;
		}else{
			return 2*index+1;
		}
		
		if(2*index <= numElem-1){
			return 2*index;
		}
		
		return -1;
	}
	
	private void swap(int indexChidOne, int indexChildTwo){
		T elem = arr[indexChidOne];
		arr[indexChidOne] = arr[indexChildTwo];
		arr[indexChildTwo] = elem;
	}
	
	

}
