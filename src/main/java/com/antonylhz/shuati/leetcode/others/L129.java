package com.antonylhz.shuati.leetcode.others;

//Sum Root to Leaf Numbers 
//
//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//Find the total sum of all root-to-leaf numbers.

public class L129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root!=null) dfs(root);
        return sum;
    }
    private void dfs(TreeNode root) {
        if(root.left==null&&root.right==null) sum += root.val;
        else {
            int cur = root.val;
            if(root.left!=null) {
                root.left.val += cur * 10;
                dfs(root.left);
            }
            if(root.right!=null) {
                root.right.val += cur * 10;
                dfs(root.right);
            }
        }
    }
}
