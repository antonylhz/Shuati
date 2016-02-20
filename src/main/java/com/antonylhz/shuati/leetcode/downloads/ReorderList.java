/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode nodeS = head, nodeF = head;
        while (nodeF.next != null && nodeF.next.next != null) {
            nodeS = nodeS.next;
            nodeF = nodeF.next.next;
        }
        if (nodeF.next != null) nodeF = nodeF.next;
        ListNode prev = nodeS.next, cur = prev.next, next;
        nodeS.next = null;
        prev.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        ListNode node1 = head, next1, next2;
        while (node1 != null && nodeF != null) {
            next1 = node1.next;
            next2 = nodeF.next;
            node1.next = nodeF;
            nodeF.next = next1;
            node1 = next1;
            nodeF = next2;
        }
    }
}
