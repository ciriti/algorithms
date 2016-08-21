package it.car.yelp.interview.datastructure.linkedlist;

public class Partition {
	
	
	
	 public ListNode partition(ListNode head, int x) {
	        
	        if(head == null)
	            return head;
	        ListNode less = new ListNode(-1);
	        ListNode greater = new ListNode(-1);
	        ListNode tmp = head;
	        while(tmp!=null){
	            if(tmp.val < x){
	                less.next = new ListNode(tmp.val);
	                less = less.next;
	            }else{
	                greater.next = new ListNode(tmp.val);
	                greater = greater.next;
	            }
	            tmp = tmp.next;
	        }
	        
	        tmp = less;
	        while(tmp!=null){
	            if(tmp.next == null){
	                tmp.next = greater.next;
	                break;
	            }
	            tmp = tmp.next;
	        }
	        if(less.next == null)
	            return greater.next;
	        return less.next;
	        
	    }

}
