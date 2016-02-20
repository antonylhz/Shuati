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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode nodeA = headA, nodeB = headB;
        int countA = 0, countB = 0;
        while(nodeA!=null) {
            countA++;
            nodeA = nodeA.next;
        }
        while(nodeB!=null) {
            countB++;
            nodeB = nodeB.next;
        }
        int diff = Math.abs(countA-countB);
        ListNode nodeL = headA, nodeS = headB;
        if(countA<countB) {
            nodeL = headB;
            nodeS = headA;
        }
        for(int i=0; i<diff; i++) nodeL = nodeL.next;
        while(nodeL!=null&&nodeS!=null){
            if(nodeL==nodeS) return nodeL;
            nodeL = nodeL.next;
            nodeS = nodeS.next;
        }
        return null;
    }
}
