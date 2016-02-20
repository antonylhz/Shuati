/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        maxPathDown(root);
        return max;
    }

    private int maxPathDown(TreeNode root) {
        int left = 0, right = 0;
        if(root.left!=null) {
            left = Math.max(0, maxPathDown(root.left));
        }
        if(root.right!=null) {
            right = Math.max(0, maxPathDown(root.right));
        }
        max = Math.max(max, left+right+root.val);
        return Math.max(left, right) + root.val;
    }
}

