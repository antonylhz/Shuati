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
    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode node = root, left = node.left, right = node.right;
        if(left != null) {
            flatten(left);
            node.left = null;
            node.right = left;
            while(node.right != null) {
                node = node.right;
            }
        }
        flatten(right);
        node.right = right;
    }
}