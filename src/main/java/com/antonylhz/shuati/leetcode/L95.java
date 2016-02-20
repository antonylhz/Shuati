package com.antonylhz.shuati.leetcode;

//Unique Binary Search Trees II
//
//Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

import java.util.*;

public class L95 {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    private List<TreeNode> generateTrees(int start, int end) { //inclusive
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(end<start) {
            result.add(null);
            return result;
        }
        else if(end==start) {
            result.add(new TreeNode(start));
            return result;
        }
        for(int i=start; i<=end; i++) {
            List<TreeNode> leftlist = generateTrees(start, i-1);
            List<TreeNode> rightlist = generateTrees(i+1, end);
            if(leftlist.isEmpty()) leftlist.add(null);
            if(rightlist.isEmpty()) rightlist.add(null);
            for(int m=0; m<leftlist.size(); m++)
            for(int n=0; n<rightlist.size(); n++) {
                TreeNode root = new TreeNode(i);
                root.left = leftlist.get(m);
                root.right = rightlist.get(n);
                result.add(root);
            }
        }
        return result;
    }
}
