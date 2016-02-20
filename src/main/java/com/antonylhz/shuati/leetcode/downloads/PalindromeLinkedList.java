/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode node = head;
        if(node==null||node.next==null) return true;
        int count = 0;
        for(; node!=null; node=node.next, count++);
        int half = count/2;
        boolean isEven = count%2==0;
        ListNode left = head, next;
        node = head.next;
        left.next = null;
        for(int i=0; i<half-1; i++) {
            next = node.next;
            node.next = left;
            left = node;
            node = next;
        }
        if(!isEven) node = node.next;
        while(left!=null||node!=null) {
            if(left==null||node==null) return false;
            if(left.val!=node.val) return false;
            left = left.next;
            node = node.next;
        }
        return true;
    }
}

