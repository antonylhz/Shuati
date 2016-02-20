package com.antonylhz.shuati.leetcode.revised;

//Validate Binary Search Tree
//
//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.


public class L98 {
	public static void main(String[] args) {
		
	}
	
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long min, long max) {
        if(root==null) return true;
        long value = (long)root.val;
        if(value>max||value<min) return false;
        return isValidBST(root.left, min, value-1)&&isValidBST(root.right, value+1, max);
    }
}
