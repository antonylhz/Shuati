package com.antonylhz.shuati.leetcode.others;

//Path Sum
//
//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.


public class L112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        int target = sum - root.val;
        if(root.left==null&&root.right==null) return target==0;
        if(root.left!=null&&hasPathSum(root.left, target)) return true;
        return root.right != null && hasPathSum(root.right, target);
    }
}
