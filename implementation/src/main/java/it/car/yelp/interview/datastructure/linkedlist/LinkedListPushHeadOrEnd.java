package it.car.yelp.intrw.datastructure.linkedlist;


public class LinkedListPushHeadOrEnd {

	public ListNode head;
	public ListNode tail;

	public void addHead(int val){
		ListNode node = new ListNode(val);
		if(head == null){
			head = node;
			tail = node;
		}else{
			node.next = head;
			head = node;
		}
	}

	public static void print(ListNode n){
		while(n!=null){
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}

	public void addEnd(int val){
		ListNode n = new ListNode(val);
		ListNode tmp = head;

		if(head == null){
			head = n;
			return;
		}

		while(tmp.next != null){
			tmp = tmp.next;
		}
		
		tmp.next = n;

	}
	
	public void addEndTail(int val){
		ListNode n = new ListNode(val);

		if(head == null){
			head = n;
			tail = n;
			return;
		}

		tail.next = n;
		tail = n;

	}
	
	public static void printReverseList(ListNode n){
		if(n.next == null){
			System.out.print(n.val + " ");
			return;
		}else if(n.next != null)
			printReverseList(n.next);
		
		System.out.print(n.val + " ");
	}

	public static void main(String args[]){
		LinkedListPushHeadOrEnd ll = new LinkedListPushHeadOrEnd();
		ll.addEndTail(1);
		ll.addEndTail(2);
		ll.addEndTail(3);
		ll.addEndTail(4);
		ll.addEndTail(5);
		ll.addEndTail(6);
		printReverseList(ll.head);
	}

}
