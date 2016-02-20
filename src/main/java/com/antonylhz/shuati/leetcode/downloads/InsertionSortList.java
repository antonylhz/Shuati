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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head, node = head.next, it;
        while (node != null) {
            if (node.val < head.val) {
                prev.next = node.next;
                node.next = head;
                head = node;
                node = prev.next;
                continue;
            }
            it = head;
            while (it.next != node && it.next.val <= node.val) it = it.next;
            if (it.next.val > node.val) {
                prev.next = node.next;
                node.next = it.next;
                it.next = node;
                node = prev.next;
            } else { //node is at its right place
                prev = node;
                node = node.next;
            }
        }
        return head;
    }
}