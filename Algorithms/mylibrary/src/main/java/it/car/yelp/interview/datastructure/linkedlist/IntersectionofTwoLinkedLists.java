package it.car.yelp.interview.datastructure.linkedlist;


public class IntersectionofTwoLinkedLists {

	public ListNode head;
	public ListNode tail;
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ""+val;
		}
	}

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
	
	public void addArray(int[] data){
		for(int i : data){
			addHead(i);
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
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null ||  headB == null)
           return null;
       
       ListNode headATmp = headA;
       ListNode headBTmp = headB;
       
      while(headATmp != headBTmp){
          headATmp = headATmp==null?headB:headATmp.next;
          headBTmp = headBTmp==null?headA:headBTmp.next;
      }
      
      return headATmp;
       
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
		IntersectionofTwoLinkedLists ll = new IntersectionofTwoLinkedLists();
		ll.addArray(new int[]{1,2, 4});
		IntersectionofTwoLinkedLists ll2 = new IntersectionofTwoLinkedLists();
		ll2.addArray(new int[]{3});
		print(ll.head);
		print(ll2.head);
		System.out.println(getIntersectionNode(ll.head, ll2.head));
	}

}
