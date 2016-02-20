package com.antonylhz.shuati.leetcode.others;

//Binary Tree Level Order Traversal
//
//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

import java.util.ArrayList;
import java.util.List;

public class L102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        List<TreeNode> q = new ArrayList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            List<Integer> values = new ArrayList<Integer>();
            List<TreeNode> level = new ArrayList<TreeNode>();
            for(TreeNode node : q) {
                values.add(node.val);
                if(node.left!=null) level.add(node.left);
                if(node.right!=null) level.add(node.right);
            }
            result.add(values);
            q = level;
        }
        return result;
    }
}
