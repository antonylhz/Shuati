package com.antonylhz.shuati.leetcode.revised;

public class ReverseGroupK {

    ListNode tail, next = null;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		(new ReverseGroupK()).reverseKGroup(head, 2);
	}

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k<2) return head;
        head = reverseK(head, k);
        while(next!=null) {
            tail.next = reverseK(next, k);
        }
        if(tail!=null) tail.next = null;
        return head;
    }
    private ListNode reverseK(ListNode head, int k) {
    	if(head==null||head.next==null) {
    		next = null;
    		tail = null;
    		return head;
    	}
        next = head;
        int i=0;
        for(; next.next!=null&&i<k-1; i++) 
        	next = next.next;
        if(i<(k-1)) {
    		next = null;
    		tail = null;
    		return head;
    	}
        ListNode oldhead = head, cur = head, last;
        next = cur.next;
        for(i=0; i<k-1; i++) {
            last = cur;
            cur = next;
            next = cur.next;
            cur.next = last;
        }
        tail = oldhead;
        return cur;
    }
}
