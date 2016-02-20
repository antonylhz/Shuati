/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */



public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast!=null&&slow!=null) {
            if(fast.next!=null&&fast.next.next!=null) fast = fast.next.next;
            else return null;
            if(slow.next!=null) slow = slow.next;
            else return null;
            if(fast==slow) break;
        }
        while(slow!=head) {
            slow = slow.next;
            head = head.next;
        }
        return slow;
    }
}