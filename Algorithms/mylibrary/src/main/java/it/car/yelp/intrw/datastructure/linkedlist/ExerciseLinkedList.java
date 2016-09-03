package it.car.yelp.intrw.datastructure.linkedlist;


public class ExerciseLinkedList {
	
	/**
	 * algoritm per ordinare una linkedlist
	 * @param head
	 * @return
	 */
	public static ListNode order(ListNode head){
		
		ListNode res = new ListNode(Integer.MIN_VALUE);
		
		while(head != null){
			
			build(res, head.val);
			head = head.next;
		}
		
		return res.next;
	}

	private static void build(ListNode res, int headVal) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(headVal);
		while(res!=null){
			if(res.next == null){
				res.next = head;
				break;
			}else if(head.val < res.next.val){
				ListNode tmp = res.next;
				res.next = head;
				head.next = tmp;
				break;
			}
			res = res.next;
		}
	}

	/**
	 * algoritmo per spezzare a metà una linked list
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode[] breakInMiddleList(ListNode head){

		if(head == null || head.next == null) 
			return new ListNode[]{head,null};

		ListNode first = head;
		ListNode tmp = first;
		ListNode second = null;
		ListNode[] res = null;
		int count = 0;
		while(tmp != null){
			count ++;
			tmp = tmp.next;
		}


		tmp = first;
		int cnt = 0;
		while(tmp != null){
			cnt++;
			if(cnt>=count/2){
				ListNode tmpNode = tmp.next;
				tmp.next = null;
				second = tmpNode;
				break;
			}
			tmp = tmp.next;

		}

		res = new ListNode[]{first, second};

		return res;
	}
	
	public static ListNode[] breaListMiddle(ListNode head){
	    ListNode[] res = null;
	    int count = 0;
	    ListNode tmp = head;
	    
	    while(tmp != null){
	        tmp = tmp.next;
	        count++;
	    }
	    
	    
	    ListNode first = head;
	    tmp = first;
	    ListNode second = null;
	    int cnt = 0;
	    while(tmp != null){
	        cnt++;
	        if(cnt==count/2){
	            second = tmp.next;
	            tmp.next = null;
	            break;
	        }
	        tmp = tmp.next;
	        
	    }
	    
	    res = new ListNode[]{first, second};
	    return res;
	}

	/**
	 * algoritmo per mergiare 2 linked list
	 * @param head
	 * @param head1
	 * @return
	 */
	public static ListNode mergeList(ListNode head, ListNode head1){

		ListNode res = new ListNode(Integer.MAX_VALUE);
		ListNode res1 = res;

		while(head != null || head1 != null){

			if(head != null && head1 != null){
				res.next = new ListNode(head.val < head1.val?head.val:head1.val);
				res = res.next;
				if(head.val < head1.val)
					head = head.next;
				else 
					head1 = head1.next;
			}else if(head != null){
				res.next = new ListNode(head.val);
				head = head.next;
			}else{
				res.next = new ListNode(head1.val);
				res = res.next;
				head1 = head1.next;
			}

		}

		return res1.next;
	}

	public static void printBinaryMethodList(ListNode head, ListNode head1){

	}

	public static void main(String args[]){

		int[] arr = new int[]{-1, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		ListNode l1 = new ListNode(arr[1]);
		ListNode l2 = new ListNode(arr[2]);
		ListNode l3 = new ListNode(arr[3]);
		ListNode l4 = new ListNode(arr[4]);
		ListNode l5 = new ListNode(arr[5]);
		ListNode l6 = new ListNode(arr[6]);
		ListNode l7 = new ListNode(arr[7]);
		ListNode l8 = new ListNode(arr[8]);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;

		l1 = order(l1);
		print(l1);
		
		ListNode[] breakList = breaListMiddle(l1);//sortList(l1);
		
		print(breakList[0]);
		print(breakList[1]);
		ListNode rev = reverse(breakList[1]);
		System.out.println("reverse ");
		print(rev);
		System.out.println("merged:");
		ListNode merged = mergeList(breakList[0], breakList[1]);
		print(merged);

	}
	
	public static ListNode reverse(ListNode head){
	    ListNode tmp = null;
	    ListNode curr = head;
	    ListNode next = curr.next;
	    
	    if(next == null) return curr;
	    
	    tmp = reverse(next);
	    next.next = curr;
	    curr.next = null;
	    
	    return tmp;
	    
	}

	public static void print(ListNode n){
		while(n!=null){
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}

}
