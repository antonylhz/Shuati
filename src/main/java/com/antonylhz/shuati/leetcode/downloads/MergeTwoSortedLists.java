/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        ListNode dumb = new ListNode(0);
        if (l1.val <= l2.val) merge(l1, l2, dumb);
        else merge(l2, l1, dumb);
        return dumb.next;
    }

    private void merge(ListNode l1, ListNode l2, ListNode head) {
        head.next = l1;
        l1 = l1.next;
        if (l1 == null) head.next.next = l2;
        else if (l1.val <= l2.val) merge(l1, l2, head.next);
        else merge(l2, l1, head.next);
    }
}
