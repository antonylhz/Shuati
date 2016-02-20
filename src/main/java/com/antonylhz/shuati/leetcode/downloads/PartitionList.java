/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dumb = new ListNode(x-1);
        ListNode smalltail = dumb, bighead = null, prev = null, node = head;
        while(node!=null) {
            if(node.val<x) {
                if(prev!=null) prev.next = node.next;
                smalltail.next = node;
                smalltail = smalltail.next;
            } else {
                if(bighead==null) bighead = node;
                prev = node;
            }
            node = node.next;
        }
        smalltail.next = bighead;
        return dumb.next;
    }
}
