package com.antonylhz.shuati.leetcode.revised;

//Construct Binary Tree from Inorder and Postorder Traversal 

public class L106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null||postorder.length<1) return null;
        return buildTree(postorder, 0, postorder.length, inorder, 0);
    }
    private TreeNode buildTree(int[] postorder, int pstart, int size, int[] inorder, int istart) {
        int root_value = postorder[pstart+size-1];
        TreeNode root = new TreeNode(root_value);
        if(size==1) return root;
        int i = 0;
        while(inorder[istart+i]!=root_value) i++;
        if(i>0) root.left = buildTree(postorder, pstart, i, inorder, istart);
        if(i<size-1) root.right = buildTree(postorder, pstart+i, size-i-1, inorder, istart+i+1);
        return root;
    }
}
