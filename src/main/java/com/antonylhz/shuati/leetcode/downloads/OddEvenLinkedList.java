/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddtail = head, even = head.next, eventail = even;
        ListNode it = even.next;
        boolean odd = true;
        while (it != null) {
            if (odd) {
                oddtail = (oddtail.next = it);
            } else {
                eventail.next = it;
                eventail = eventail.next;
            }
            it = it.next;
            odd = !odd;
            System.out.println(oddtail.val);
        }
        oddtail.next = even;
        eventail.next = null;
        return head;
    }
}