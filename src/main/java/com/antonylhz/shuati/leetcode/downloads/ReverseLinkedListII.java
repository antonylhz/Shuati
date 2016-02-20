/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode prev = dump, cur = head, next, lead, start;
        int i = 1;
        while (i < m) {
            prev = cur;
            cur = cur.next;
            i++;
        }
        lead = prev;
        start = cur;
        prev = cur;
        cur = cur.next;
        i++;
        while (i <= n) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        lead.next = prev;
        start.next = cur;
        return dump.next;
    }
}
