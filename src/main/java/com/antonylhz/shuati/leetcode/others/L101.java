package com.antonylhz.shuati.leetcode.others;

//Symmetric Tree
//
//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

public class L101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left, root.right);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left==null) return right==null;
        else if(right==null) return false;
        if(left.val!=right.val) return false;
        return isSymmetric(left.left, right.right)&&isSymmetric(left.right, right.left);
    }
}
