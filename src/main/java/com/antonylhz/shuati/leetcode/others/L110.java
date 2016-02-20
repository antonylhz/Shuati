package com.antonylhz.shuati.leetcode.others;

//Balanced Binary Tree
//
//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

public class L110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null) {
            root.val = 1;
            return true;
        } 
        int left = 0, right = 0;
        if(root.left!=null) {
            if(!isBalanced(root.left)) return false;
            left = root.left.val;
        }
        if(root.right!=null) {
            if(!isBalanced(root.right)) return false;
            right = root.right.val;
        }
        
        if(Math.abs(left-right)>1) return false;
        root.val = Math.max(left, right) + 1;
        return true;
    }
}
