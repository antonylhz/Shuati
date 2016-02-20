package com.antonylhz.shuati.leetcode;

//Same Tree 
//
//Given two binary trees, write a function to check if they are equal or not.
//
//Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

public class L100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null) return q==null;
        else if(q==null) return false;
        //from now on, both trees are not null
        if(p.val!=q.val) return false;
        return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
    }
}
