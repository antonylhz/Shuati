/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head, second = first.next, third = second.next;
        third = swapPairs(third);
        second.next = first;
        first.next = third;
        return second;
    }
}