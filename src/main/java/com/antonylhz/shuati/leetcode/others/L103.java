package com.antonylhz.shuati.leetcode.others;

//Binary Tree Zigzag Level Order Traversal 
//
//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

import java.util.ArrayList;
import java.util.List;


public class L103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        List<TreeNode> cur = new ArrayList<TreeNode>(), next = new ArrayList<TreeNode>();
        cur.add(root);
        boolean reverse = false;
        while(cur.size()>0) {
            List<Integer> curvalues = new ArrayList<Integer>();
            for(TreeNode node : cur) {
                if(reverse) curvalues.add(0, node.val);
                else curvalues.add(node.val);
                if(node.left!=null) next.add(node.left);
                if(node.right!=null) next.add(node.right);
            }
            result.add(curvalues);
            cur.clear();
            cur.addAll(next);
            next.clear();
            reverse = !reverse;
        }
        return result;
    }
}
