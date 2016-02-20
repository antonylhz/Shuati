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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        while (head.next != null && head.val == head.next.val) head = head.next;
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) node.next = node.next.next;
            else node = node.next;
        }
        return head;
    }
}