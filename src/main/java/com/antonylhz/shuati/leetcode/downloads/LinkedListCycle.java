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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(slow!=null && fast!=null) {
            if(slow.next!=null) slow = slow.next;
            else return false;
            if(fast.next!=null&&fast.next.next!=null) fast = fast.next.next;
            else return false;
            if(slow==fast) return true;
        }
        return false;
    }
}