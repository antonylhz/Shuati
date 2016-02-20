package com.antonylhz.shuati.leetcode;

//Invert Binary Tree



public class L226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) 
            return root;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
