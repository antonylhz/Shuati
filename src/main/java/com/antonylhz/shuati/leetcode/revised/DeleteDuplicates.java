package com.antonylhz.shuati.leetcode.revised;

public class DeleteDuplicates {
	public static void main(String[] args) {
		DeleteDuplicates solution = new DeleteDuplicates();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(3);
		System.out.println(solution.deleteDuplicates(head));
	}
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode dumb = new ListNode(0);
        dumb.next = head;
        ListNode prev = dumb, cur = head, next;
        boolean equal = false;
        int val = 0;
        while(cur!=null) {
            if(cur.next==null) {
                if(equal&&cur.val==val) prev.next = null;
                break;
            } else {
                next = cur.next;
                if(cur.val==next.val) {
                    if(!equal) {
                        equal = true;
                        val = cur.val;
                    }
                    prev.next = next.next;
                    cur = next.next;
                } else {
                    if(equal) equal = false;
                	if(equal&&cur.val==val) prev.next = next;
	                else prev = cur;
                    cur = next;
                }
            }
        }
        return dumb.next;
    }
}
