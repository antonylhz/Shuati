/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ListNode slow = head, fast = head, last = slow;
        while(fast.next!=null&&fast.next.next!=null) {
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if(slow!=head) {
            last.next = null;
            root.left = sortedListToBST(head);
        }
        if(slow.next!=null) root.right = sortedListToBST(slow.next);
        return root;
    }
}
