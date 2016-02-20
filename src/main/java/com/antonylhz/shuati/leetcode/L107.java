package com.antonylhz.shuati.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        List<TreeNode> cur = new ArrayList<TreeNode>(), next = new ArrayList<TreeNode>();
        cur.add(root);
        while(cur.size()>0) {
            List<Integer> curvalues = new ArrayList<Integer>();
            for(TreeNode node : cur) {
                curvalues.add(node.val);
                if(node.left!=null) next.add(node.left);
                if(node.right!=null) next.add(node.right);
            }
            result.add(0, curvalues);
            cur.clear();
            cur.addAll(next);
            next.clear();
        }
        return result;
    }
}
