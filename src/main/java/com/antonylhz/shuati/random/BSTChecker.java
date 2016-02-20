package com.antonylhz.shuati.random;

public class BSTChecker {
	static class Node {
		int val;
		Node left, right;
		public Node(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		/*
		 * 			5
		 * 		3		7
		 *    1   4   6   8
		 */
		Node root = new Node(5);
		root.left = new Node(3);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right = new Node(7);
		root.right.left = new Node(6);
		root.right.right = new Node(8);
		System.out.println(isBST(root));
	}
	
	private static boolean isBST(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private static boolean isBST(Node root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.val < min || root.val > max) {
			System.err.println(root.val+" " +min+" "+max);
			return false;
		}
		return isBST(root.left, min, root.val - 1) && isBST(root.right, root.val + 1, max);
	}
}	
