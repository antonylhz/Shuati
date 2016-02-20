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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        else return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left==null && right==null) return true;
        else if(left!=null && right!=null) {
            return left.val==right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        } else return false;
    }
}