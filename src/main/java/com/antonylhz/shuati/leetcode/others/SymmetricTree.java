package com.antonylhz.shuati.leetcode.others;

import java.util.Stack;


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


public class SymmetricTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2); root.right = new TreeNode(2);
		root.left.right = new TreeNode(3); root.right.left = new TreeNode(3);
		System.out.println((new SymmetricTree()).isSymmetric(root));
	}
	
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        else if(root.left==null&&root.right==null) return true;
        else if(root.left==null||root.right==null) return false;
        else if(root.left.val!=root.right.val) return false;
        else return isIdentical(root.left, root.right);
    }
    //Roots passed to isIdentical() are never null
    private boolean isIdentical(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<TreeNode>(), s2 = new Stack<TreeNode>();
        s1.push(root1); s2.push(root2);
        TreeNode node1, node2;
        while(!s1.empty()&&!s2.empty()) {
            node1 = s1.pop(); node2 = s2.pop();
            if(node1.val!=node2.val) return false;
            if(node1.left==null^node2.right==null || node1.right==null^node2.left==null) return false;
            if(node1.left!=null) s1.push(node1.left);
            if(node1.right!=null) s1.push(node1.right);
            if(node2.left!=null) s2.push(node2.right);
            if(node2.right!=null) s2.push(node2.left);
        }
        return !(!s1.isEmpty() || !s2.isEmpty());
    }
}
