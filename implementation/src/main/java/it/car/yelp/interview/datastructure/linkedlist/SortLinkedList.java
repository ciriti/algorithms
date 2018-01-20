package it.car.yelp.intrw.datastructure.linkedlist;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

/**
 * http://www.programcreek.com/2012/11/leetcode-solution-merge-sort-linkedlist-in-java/
 * @author carmelo.iriti
 *
 */

public class SortLinkedList {

	// merge sort
	public static ListNode mergeSortList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		// count total number of elements
		int count = 0;
		ListNode p = head;
		while (p != null) {
			count++;
			p = p.next;
		}

		// break up to two list
		int middle = count / 2;

		ListNode l = head, r = null;
		ListNode p2 = head;
		int countHalf = 0;
		while (p2 != null) {
			countHalf++;
			ListNode next = p2.next;

			if (countHalf == middle) {
				p2.next = null;
				r = next;
			}
			p2 = next;
		}

		// now we have two parts l and r, recursively sort them
		ListNode h1 = mergeSortList(l);
		ListNode h2 = mergeSortList(r);

		// merge together
		ListNode merged = merge(h1, h2);

		return merged;
	}

	public static ListNode merge(ListNode l, ListNode r) {

		ListNode newList = new ListNode(100);
		ListNode tmp = newList;

		ListNode p1 = l;
		ListNode p2 = r;

		while(p1 != null || p2 != null){
			if(p1 == null ){
				tmp.next = p2;
				p2 = p2.next;
				tmp = tmp.next;
			}else if(p2 == null ){
				tmp.next = p1;
				p1 = p1.next;
				tmp = tmp.next;
			}else{
				ListNode min;
				ListNode max;
				if(p1.val < p2.val){
					min = p1;
					max = p2;
				}else{
					min = p2;
					max = p1;
				}
				tmp.next = new ListNode(min.val);
				tmp.next.next = new ListNode(max.val);
				tmp = tmp.next.next;
				p1 = p1.next;
				p2 = p2.next;
			}
		}

		return newList.next;

	}

	public static void main(String[] args) {
		reverseLinkedListMain();
	}

	public static void reverseLinkedListMain(){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);


		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		//		n1 = reverseLinkedListLinearRecursive(n1);
		n1 = reverseLinkedListLinearRecursiveMyImpl(n1);
		printList(n1);
	}

	public static void deleteDuplicatesMain(){
		ListNode n1 = new ListNode(-2);
		ListNode n2 = new ListNode(0);
		ListNode n3 = new ListNode(0);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);


		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		n1 = deleteDuplicates(n1);
		printList(n1);
	}

	public static void removeElement(){
		ListNode n1 = new ListNode(1);
		//		ListNode n2 = new ListNode(2);
		//		ListNode n3 = new ListNode(3);
		//		ListNode n4 = new ListNode(4);
		//
		//
		//		n1.next = n2;
		//		n2.next = n3;
		//		n3.next = n4;

		//		n1 = removeNthFromStart(n1, 5);

		n1 = removeNthFromEnd(n1, 1);

		printList(n1);
	}

	public static void rotateRightMain(){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);


		n1.next = n2;
		//		n2.next = n3;
		//		n3.next = n4;
		//		n4.next = n5;

		n1 = rotateRight(n1, 3);
		printList(n1);
	}

	public static void swapPairsMain(){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);


		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		n1 = swapPairs(n1);
		printList(n1);
	}


	public static void sum(){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(1);

		ListNode nn1 = new ListNode(9);
		ListNode nn2 = new ListNode(9);
		ListNode nn3 = new ListNode(9);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		nn1.next = nn2;
		nn2.next = nn3;

		n1 = addTwoNumbers(n1, nn1);;

		printList(n1);
	}

	public static void merge(){
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);

		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		n1 = mergeSortList(n1);

		printList(n1);
	}

	public static ListNode swapPairs(ListNode head) {

		ListNode newList = new ListNode(0);
		ListNode tmp = newList;
		ListNode p1 = head;

		while(p1 != null){
			if(p1.next != null){
				//				p1 = p1.next;
				//				p1.next = tmp;
				tmp.next = new ListNode(p1.next.val);
				tmp.next.next = new ListNode(p1.val);
				tmp = tmp.next.next;
				p1 = p1.next.next;
			}else{
				tmp.next = new ListNode(p1.val);
				p1 = p1.next;

			}
		}


		return newList.next;
	}

	public static ListNode rotateRight(ListNode head, int k) {

		ListNode newList = new ListNode(0);
		ListNode tmp = newList;

		ListNode pCount = head;
		ListNode p1 = head;
		ListNode p2 = head;
		ListNode p3 = head;

		int size = 0;
		int count = 1;
		int count2 = 1;
		int count3 = 1;

		while(pCount != null){
			pCount = pCount.next;
			size ++;
		}

		k = k%size; 


		while(p1 != null){

			if(count > k){
				tmp.next = new ListNode(p1.val);
			}
			p1 = p1.next;
			count ++;
		}

		while(p2!=null){

			if(count2 > count - k -1){
				tmp.next = new ListNode(p2.val);
				tmp = tmp.next;
			}
			count2 ++;
			p2 = p2.next;
		}

		while(p3!=null){

			if(count3 <= count - k -1){
				tmp.next = new ListNode(p3.val);
				tmp = tmp.next;
			}
			count3 ++;
			p3 = p3.next;
		}


		return newList.next;
	}


	public static ListNode deleteDuplicates(ListNode head) {

		ListNode newList = new ListNode(0);
		ListNode tmp = newList;
		ListNode p1 = head;
		int oldValue = -111111111;


		while(p1 != null){
			while(p1.next != null && p1.val == p1.next.val){
				oldValue = p1.val;
				p1 = p1.next;
			}

			if(p1 != null && oldValue != p1.val){
				tmp.next = new ListNode(p1.val);
				tmp = tmp.next;
			}

			p1 = p1.next;
		}

		return newList.next;
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode newList = new ListNode(0);
		ListNode tmp = newList;

		ListNode p1 = l1; 
		ListNode p2 = l2;

		int carry = 0;
		int result = 0;

		while(p1 != null || p2 != null){
			if(p1 == null){
				result = carry + p2.val;
			}else if(p2 == null){
				result = carry + p1.val;
			}else{
				result = carry + p1.val + p2.val;
			}
			carry = result/10;
			result = result%10;
			if(p1!=null) p1 = p1.next;
			if(p2!=null) p2 = p2.next;
			tmp.next = new ListNode(result) ;
			tmp = tmp.next;
		}

		if(carry != 0){
			tmp.next = new ListNode(carry) ;
		}


		return newList.next;
	}

	public static ListNode removeNthFromStart(ListNode head, int n) {

		ListNode newList = new ListNode(0);
		ListNode tmp = newList;

		ListNode p1 = head;

		int count = 1;

		while(p1 != null){

			if(count != n){
				tmp.next = new ListNode(p1.val);
				tmp = tmp.next;
			}

			p1 = p1.next;

			count++;
		}

		return newList.next;
	}

	public static ListNode reverseLinkedListLinear(ListNode head){

		ListNode p1 = head;
		ListNode prev = null;
		ListNode curr = null;

		while(p1 != null){
			curr = new ListNode(p1.val);
			curr.next = prev;
			prev = curr;
			p1 = p1.next;
		}

		return curr;
	}

	//	public static ListNode scorriLinkedListLinearRecursive(ListNode head){
	//
	//		ListNode p1 = head;
	//		ListNode nextElem = null;
	//		ListNode curr = null;
	//
	//		if(p1.next == null){
	//			return p1;
	//		}
	//
	//		if(p1 !=null){
	//			//			curr = new ListNode(p1.val);
	//			curr = scorriLinkedListLinearRecursive(p1.next);
	//			curr.next = p1;
	//			p1.next = null;
	//		}
	//
	//
	//		return curr;
	//	}

	public static ListNode reverseLinkedListLinearRecursiveMyImpl(ListNode head){

		ListNode curr = head;
		ListNode tmp = null;
		ListNode nextElem = head.next;


		if(nextElem != null){
			tmp = reverseLinkedListLinearRecursiveMyImpl(nextElem);
			nextElem.next = curr;
			curr.next = null;
		}else{
			return curr;
		}

		return tmp;
	}

	public static ListNode reverseLinkedListLinearRecursive(ListNode head){

		if (head == null) 
			return null; 

		if (head.next == null) 
			return head; 

		ListNode secondElem = head.next;
		head.next = null;

		ListNode reverseRest = reverseLinkedListLinearRecursive(secondElem);

		secondElem.next = head;

		return reverseRest;
	}


	public static ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode newList = new ListNode(0);
		ListNode tmp = newList;

		ListNode p1 = head;
		ListNode p2 = head;

		int count = 0;

		System.out.println("n[" + n +"]");

		while(p1 != null){
			if(n <= count){
				tmp.next = new ListNode(p2.val);
				tmp = tmp.next;
				p2 = p2.next;
			}
			p1 = p1.next;
			count++;
		}

		if(p2!=null){
			//			if(n<=count)
			p2 = p2.next;
			while(p2 != null){
				tmp.next = new ListNode(p2.val);
				tmp = tmp.next;
				p2 = p2.next;
			}	
		}


		return newList.next;
	}

	public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}

	}


}