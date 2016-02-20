package com.antonylhz.shuati.leetcode.revised;

//Binary Tree Maximum Path Sum
//
//Given a binary tree, find the maximum path sum.
//
//The path may start and end at any node in the tree.

public class L124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        maxPathDown(root);
        return max;
    }
    
    /*
     * 1. determine which side (left or right) produces a path with largest sum
     * 2. calculate the largest sum for the paths have current node as root, and update max
     */
    private int maxPathDown(TreeNode root) {
        int left = 0, right = 0;
        if(root.left!=null) {
            left = Math.max(0, maxPathDown(root.left));
        }
        if(root.right!=null) {
            right = Math.max(0, maxPathDown(root.right));
        }
        max = Math.max(max, left+right+root.val);
        return Math.max(left, right) + root.val;
    }
}
