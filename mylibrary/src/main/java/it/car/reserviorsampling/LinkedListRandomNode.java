package it.car.reserviorsampling;

import java.util.Random;

/**
 * Created by carmeloiriti, 29/09/16.
 */
public class LinkedListRandomNode {

    /**
     * LINK - https://leetcode.com/problems/linked-list-random-node/
     */

    /**

     Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

     Follow up:
     What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

     Example:

     // Init a singly linked list [1,2,3].
     ListNode head = new ListNode(1);
     head.next = new ListNode(2);
     head.next.next = new ListNode(3);
     Solution solution = new Solution(head);

     // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
     solution.getRandom();

     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    ListNode head;
    int count = 0;
    Random r;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        r = new Random();
        this.head = head;
        ListNode tmp = head;
        while(tmp != null){
            count++;
            tmp = tmp.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int c = r.nextInt(count);
        ListNode tmp = head;
        while(c > 0){
            c--;
            tmp = tmp.next;

        }
        return tmp != null?tmp.val:1;
    }


}
