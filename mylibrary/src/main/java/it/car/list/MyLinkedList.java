package it.car.list;
class MyLinkedList{
	private MyNode head;
	private MyNode tail;

	public MyLinkedList(){
		this.head = new MyNode("head");
		tail = head;
	}

	public MyNode head(){
		return head;
	}

	public void add(MyNode node){
		tail.next = node;
		tail = node;
	}

	public static class MyNode{
		private MyNode next;
		private String data;

		public MyNode(String data){
			this.data = data;
		}

		public String data() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public MyNode next() {
			return next;
		}

		public void setNext(MyNode next) {
			this.next = next;
		}

		public String toString(){
			return this.data;
		}
	}
}

