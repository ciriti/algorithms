package it.car.stack;

public class LinkedStack<T> {

	int size = 0;
	Node<T> first;

	public void push (T data){
		size ++;
		Node<T> tmp = first;
		first = new Node<T>(data);
		first.next = tmp;
	}

	public T pop(){

		if(size == 0){
			System.out.println("no element");
			return null;
		}
		Node<T> tmp = first;
		first = first.next;
		size--;

		return tmp.data;
	}

	public void print(){
		if(size == 0)
			new java.util.NoSuchElementException();

		Node<T> tmp = first;
		while(tmp != null){
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}

	private static class Node<T>{
		private T data;
		private Node<T> next;

		public Node(T data){
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String args[]){
		LinkedStack<Integer> stack = new LinkedStack<>();

		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}

		stack.print();

		for (int i = 0; i < 10; i++) {
			stack.pop();
		}

		stack.print();
	}


}
