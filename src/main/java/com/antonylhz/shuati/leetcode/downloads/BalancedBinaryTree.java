/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            root.val = 1;
            return true;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            if (!isBalanced(root.left)) return false;
            left = root.left.val;
        }
        if (root.right != null) {
            if (!isBalanced(root.right)) return false;
            right = root.right.val;
        }

        if (Math.abs(left - right) > 1) return false;
        root.val = Math.max(left, right) + 1;
        return true;
    }
}
