/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k<=0) return head;
        ListNode newhead = head, tail = head, newtail = head;
        int count = 0;
        while(tail!=null) {
            count++;
            tail = tail.next;
        }
        k %= count;
        if(k==0) return head;
        tail = head;
        for(int i=1; i<k; i++) {
            if(tail.next==null) tail = head;
            else tail = tail.next;
        }
        newhead = newhead.next;
        tail = tail.next;
        while(tail.next!=null) {
            newhead = newhead.next;
            tail = tail.next;
            newtail = newtail.next;
        }
        newtail.next = null;
        tail.next = head;
        return newhead;
    }
}
