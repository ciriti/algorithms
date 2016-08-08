package it.car.queue;


public class MyQueue {

	Node first, last = null;

	public void queue(int param){

		Node pNode = new Node(param);

		if(last == null && first == null){
			first = last = pNode;
		}else{
			last.next = pNode;
			last = pNode;
		}

	}

	public boolean isEmpty(){
		return (first==null);
	}

	public int dequeue(){

		if(first != null){
			Node tmp = new Node(first.val);
			first = first.next;
			return tmp.val;
		}

		return -1;
	}

	public static void main(String[] args) {
		//       int max = Integer.parseInt(args[0]);
		MyQueue queue = new MyQueue();

		for(int i = 0; i<10; i++){
			queue.queue(i);
			System.out.println("push[" + i + "]");
		}

		while(!queue.isEmpty()){
			System.out.println("pop[" + queue.dequeue() + "]");
		}

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
