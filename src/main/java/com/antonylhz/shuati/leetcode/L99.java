package com.antonylhz.shuati.leetcode;

public class L99 {
    TreeNode swap1 = null, swap2 = null, last = null;
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(10);
    	root.left.left = new TreeNode(2);
    	root.left.right = new TreeNode(4);
    	root.right = new TreeNode(12);
    	root.right.left = new TreeNode(3);
    	root.right.right = new TreeNode(13);
    	(new L99()).recoverTree(root);
    }
    
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        morris(root);
        if(swap1!=null&&swap2!=null) {
            int temp = swap1.val;
            swap1.val = swap2.val;
            swap2.val = temp;
        }
    }
    
    private void morris(TreeNode cur) {
        while(cur!=null) {
            if(cur.left==null) {
                report(cur);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while(pre.right!=null&&pre.right!=cur) pre = pre.right;
                if(pre.right==null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    report(cur);
                    cur = cur.right;
                }
            }
        }
    }
    
    private void report(TreeNode node) {
        if(last!=null && node.val<=last.val) {
            if(swap1==null) {
                swap1 = last;
                swap2 = node;
            } else{
                swap2 = node;
            }
        }
        last = node;
    }
}
