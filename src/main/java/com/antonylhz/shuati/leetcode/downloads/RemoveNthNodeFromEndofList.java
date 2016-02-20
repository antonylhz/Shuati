/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumb = new ListNode(0);
        dumb.next = head;
        ListNode last = dumb, target = head, tail = head;
        for (int i = 1; i < n; i++) tail = tail.next;
        while (tail.next != null) {
            last = target;
            target = target.next;
            tail = tail.next;
        }
        last.next = target.next;
        return dumb.next;
    }
}