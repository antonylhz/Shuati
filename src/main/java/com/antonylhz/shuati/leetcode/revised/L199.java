package com.antonylhz.shuati.leetcode.revised;

//Binary Tree Right Side View
//
//Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

import java.util.ArrayList;
import java.util.List;

public class L199 {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        List<TreeNode> cur = new ArrayList<TreeNode>(), next = new ArrayList<TreeNode>();
        cur.add(root);
        while(cur.size()>0) {
            int last = 0;
            for(TreeNode node : cur) {
                last = node.val;
                if(node.left!=null) next.add(node.left);
                if(node.right!=null) next.add(node.right);
            }
            result.add(last);
            cur.clear();
            cur.addAll(next);
            next.clear();
        }
        return result;
    }
}
