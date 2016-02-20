package com.antonylhz.shuati.leetcode.others;

//Convert Sorted List to Binary Search Tree

public class L109 {
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
