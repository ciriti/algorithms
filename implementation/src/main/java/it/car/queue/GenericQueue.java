package it.car.queue;

public class GenericQueue<T>{

	private Node<T> first, last = null;
	
	public GenericQueue(){
		
	}

	/**
	*
	*/
	private static class Node<T>{
		private T data;
		private Node<T> next	= null;
		
		public Node(T data){
			this.data = data;
		}
	}
	
	/**
	*
	*/
	public void enqueue(T data){
		Node<T> newNode = new Node(data);
		if(first == null){
			first = newNode;
		}else if(last == null){
			last = newNode;
			first.next = last;
		}else{
			last.next = newNode;
			last = newNode;
		}		
	}
	
	/**
	*	
	*/
	public T dequeue(){
		if(first == null)
			throw new java.util.NoSuchElementException();
			
		
		T data = first.data;
		first = first.next;
		
		return data;
		
	}
	
	public void print(){
		
		if(first == null){
			System.out.println("No elements");
		}
		
		Node<T> tmp = first;
		while(tmp != null){
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println("");
	}
	
	public static void main(String args[]){
		GenericQueue<Integer> queue = new GenericQueue<Integer>();
		
		for(int i = 0; i< 10; i++){
			queue.enqueue(i);
		}
		
		queue.print();
		
		for(int i = 0; i< 7; i++){
			queue.dequeue();
		}
		
		queue.print();
		
	}

}