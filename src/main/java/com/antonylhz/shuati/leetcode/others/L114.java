package com.antonylhz.shuati.leetcode.others;

//Flatten Binary Tree to Linked List
//
//Given a binary tree, flatten it to a linked list in-place.

public class L114 {
    public void flatten(TreeNode root) {
        if(root!=null) flat(root);
    }
    
    private TreeNode[] flat(TreeNode root) {
        if(root.left==null&&root.right==null) return new TreeNode[]{root, root};
        TreeNode lhead = null, ltail = null, rhead = null, rtail = null;
        if(root.right!=null) {
            TreeNode[] temp = flat(root.right);
            rhead = temp[0];
            rtail = temp[1];
        }
        if(root.left==null) return new TreeNode[]{root, rtail};
        TreeNode[] temp = flat(root.left);
        lhead = temp[0];
        ltail = temp[1];
        
        root.left = null;
        root.right = lhead;
        ltail.right = rhead;
        return new TreeNode[]{root, rtail==null?ltail:rtail};
    }
}
