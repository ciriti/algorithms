package it.car.graph;

import it.car.graph.util.StdIn;
import it.car.graph.util.StdOut;

import java.util.NoSuchElementException;


public class MyBag<T> implements Iterable<T>{

	private int numElem = 0; // numero di elementi
	private Node<T> firstElem;

	// helper class linked list
	private static class Node<T>{
		private T item;
		private Node<T> next;
	}



	public MyBag() {
		super();
		this.numElem = 0;
		this.firstElem = null;
	}

	public boolean empty(){
		return firstElem == null;
	}

	public int size(){
		return numElem;
	}

	public void add(T item){
		Node<T> oldNode = firstElem;
		firstElem = new Node<T>();
		firstElem.item = item;
		firstElem.next = oldNode;
		numElem++;
	}

	@Override
	public java.util.Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator(firstElem);
	}

	private class Iterator implements java.util.Iterator<T>{

		private Node<T> currNode;

		public Iterator(Node<T> firstElem) {
			super();
			this.currNode = firstElem;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currNode != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if(!hasNext()) throw new NoSuchElementException();


			/*
			 * ERRORE
			 * currNode = currNode.next;
			 * return currNode.item;
			 */

			T item = currNode.item;
			currNode = currNode.next; 
			return item;


		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

	}

	public static void main(String args[]){
		MyBag<String> bag = new MyBag<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();

			bag.add(item);
			if(item.equals("-")){
				break;
			}
		}

		StdOut.println("size of bag = " + bag.size());
		for (String s : bag) {
			StdOut.println(s);
		}
	}

}
