package it.car.stack;

public class MyStack {

	Node top;

	/**
	 * inserisco l'ultimo valore in cima
	 * @param pN
	 */
	public void push(Node pN){

		if(pN!=null){
			pN.next = top;
			top= pN;
		}
	}

	/**
	 * estraggo l'ultimo valore inserito
	 * @return
	 */
	public Node pop(){

		if(top==null)
			return null;

		Node toReturn = new Node(top.val);
		top = top.next;
		return toReturn;
	}

	/**
	 * restituisco l'ultimo valore inserito senza estrarlo
	 * @return
	 */
	public Node peek(){
		return top;
	}
	
	/**
	 * se il nodo in cime  nullo allora onci sono elementi
	 * @return
	 */
	public boolean isEmpty(){
		return (top == null);
	}

	/**
	 * classe nodo
	 * @author carmelo.iriti
	 *
	 */
	class Node{

		int val;
		Node next;

		public Node(int val) {
			super();
			this.val = val;
		}
	}

}
