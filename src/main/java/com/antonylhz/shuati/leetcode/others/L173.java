package com.antonylhz.shuati.leetcode.others;

//Binary Search Tree Iterator
//
//Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//
//Calling next() will return the next smallest number in the BST.
//
//Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

import java.util.Stack;

public class L173 {
	
}

class BSTIterator {
    private Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        if(root==null) return; 
        s.push(root);
        expand();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(!hasNext()) return Integer.MIN_VALUE;
        TreeNode node = s.pop();
        if(node.right!=null) {
            s.push(node.right);
            expand();
        }
        return node.val;
    }
    
    private void expand() {
        if(!s.isEmpty()) {
            TreeNode node = s.peek();
            while(node.left!=null) {
                node = node.left;
                s.push(node);
            }
        }
    }
}
