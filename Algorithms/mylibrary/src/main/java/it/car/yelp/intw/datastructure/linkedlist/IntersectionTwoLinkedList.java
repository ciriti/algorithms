package it.car.yelp.intw.datastructure.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class IntersectionTwoLinkedList {
	
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Boolean> map = new HashMap<>();
        ListNode headATmp = headA;
        ListNode headBTmp = headB;
        while(headATmp != null || headBTmp != null){
            
            if(map.containsKey(headATmp)){
                return headATmp;
            }else
                map.put(headATmp, true);
            if(headATmp != null)
                headATmp = headATmp.next;
                
            if(map.containsKey(headBTmp)){
                return headATmp;
            }else
                 map.put(headBTmp, true);
            if(headBTmp != null)
                headBTmp = headBTmp.next;
            
        }
        
        return null;
        
    }

}
