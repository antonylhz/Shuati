/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1, n2 = l2;
        ListNode result = null, nr = null;
        boolean leftover = false;
        while(n1!=null || n2!=null || leftover) {
             int sum = (n1==null?0:n1.val) + (n2==null?0:n2.val) + (leftover?1:0);
             ListNode newNode;
             if(sum>9) {
                 newNode = new ListNode(sum-10);
                 leftover = true;
             } else {
                newNode = new ListNode(sum);
                leftover = false;
             }
             if(nr == null) nr = result = newNode;
             else {
                 nr.next = newNode;
                 nr = nr.next;
             }
             if(n1!=null) n1 = n1.next;
             if(n2!=null) n2 = n2.next;
        }
        return result;
    }
}