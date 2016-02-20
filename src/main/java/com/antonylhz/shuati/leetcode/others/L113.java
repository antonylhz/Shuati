package com.antonylhz.shuati.leetcode.others;

//Path Sum II 
//
//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

import java.util.ArrayList;
import java.util.List;

public class L113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        int target = sum - root.val;
        if(root.left==null&&root.right==null) {
            if(target==0){
                List<Integer> path = new ArrayList<Integer>();
                path.add(root.val);
                result.add(path);
            }
        } else {
            if(root.left!=null) {
                List<List<Integer>> paths = pathSum(root.left, target);
                for(List<Integer> path : paths) {
                    path.add(0, root.val);
                    result.add(path);
                }
            }
            if(root.right!=null) {
                List<List<Integer>> paths = pathSum(root.right, target);
                for(List<Integer> path : paths) {
                    path.add(0, root.val);
                    result.add(path);
                }
            }
        }
        return result;
    }
}
