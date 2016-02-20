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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode it = head;
        int length = 0;
        while (it != null) {
            it = it.next;
            length++;
        }
        int mid = length / 2 - 1;
        it = head;
        for (int i = 0; i < mid; i++) it = it.next;
        ListNode right = sortList(it.next);
        it.next = null;
        ListNode left = sortList(head);
        //merge left and right
        if (left == null) return right;
        else if (right == null) return left;

        ListNode newHead, prev, itl, itr;
        if (left.val <= right.val) {
            newHead = left;
            prev = newHead;
            itl = prev.next;
            itr = right;
        } else {
            newHead = right;
            prev = newHead;
            itr = prev.next;
            itl = left;
        }

        while (itl != null || itr != null) {
            if (itl == null) {
                prev.next = itr;
                return newHead;
            } else if (itr == null) {
                prev.next = itl;
                return newHead;
            }
            if (itl.val <= itr.val) {
                prev.next = itl;
                prev = prev.next;
                itl = itl.next;
            } else {
                prev.next = itr;
                prev = prev.next;
                itr = itr.next;
            }
        }
        return newHead;
    }
}

