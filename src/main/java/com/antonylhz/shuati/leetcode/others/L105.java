package com.antonylhz.shuati.leetcode.others;

//Construct Binary Tree from Preorder and Inorder Traversal 

public class L105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length<1) return null;
        return buildTree(preorder, 0, preorder.length, inorder, 0);
    }
    private TreeNode buildTree(int[] preorder, int pstart, int size, int[] inorder, int istart) {
        int root_value = preorder[pstart];
        TreeNode root = new TreeNode(root_value);
        if(size==1) return root;
        int i = 0;
        while(inorder[istart+i]!=root_value) i++;
        if(i>0) root.left = buildTree(preorder, pstart+1, i, inorder, istart);
        if(i<size-1) root.right = buildTree(preorder, pstart+i+1, size-i-1, inorder, istart+i+1);
        return root;
    }
}
