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
                    if(!equal) equal = true;
                    val = cur.val;
                    prev.next = next.next;
                    cur = next.next;
                } else {
                	if(equal&&cur.val==val) prev.next = next;
	                else prev = cur;
                    cur = next;
                    if(equal) equal = false;
                }
            }
        }
        return dumb.next;
    }
}
