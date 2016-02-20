package com.antonylhz.shuati.leetcode.others;

//Given a complete binary tree, count the number of nodes.
//
//In a complete binary tree every level, except possibly the last, 
//is completely filled, and all nodes in the last level are as far left as possible. 
//It can have between 1 and 2h nodes inclusive at the last level h.

public class L222 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		System.out.println((new L222()).countNodes(root));
	}
	
    public int countNodes(TreeNode root) {
    	if(root==null) return 0;
    	TreeNode node = root;
    	int leftheight = 0, rightheight = 0;
    	while(node!=null) {
    		leftheight++;
    		node = node.left;
    	}
    	node = root;
    	while(node!=null) {
    		rightheight++;
    		node = node.right;
    	}
    	int result = (int)(Math.pow(2, leftheight)-1), fullrow = (int)Math.pow(2, leftheight-1);
    	if(leftheight==rightheight) return result;
    	node = root;
    	while(true) {
    		leftheight--;
    		rightheight--;
    		TreeNode tempnode = node.left;
    		int count = 0;
    		while(tempnode!=null) {
    			tempnode = tempnode.right;
    			count++;
    		}
    		if(count<leftheight) {
    			result -= fullrow/2;
    			node = node.left;
    			fullrow /= 2;
    			continue;
    		}
    		tempnode = node.right;
    		count = 0;
    		while(tempnode!=null) {
    			tempnode = tempnode.left;
    			count++;
    		}
    		if(count==rightheight) {
    			result -= fullrow/2;
    			break;
    		} else {
    			node = node.right;
    			fullrow /= 2;
    		}
    	}
    	return result;
    }
}
