/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBSTinRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isBSTinRange(TreeNode root, long min, long max) {
        if(root==null || (root.left==null&&root.right==null)) return true;
        else if(root.val<=min || root.val>=max) return false;
        if(root.left!=null) {
            if(root.left.val>=root.val || root.left.val<=min) return false;
            if(!isBSTinRange(root.left, min, root.val)) return false;
        }
        if(root.right!=null) {
            if(root.right.val<=root.val || root.right.val>=max) return false;
            if(!isBSTinRange(root.right, root.val, max)) return false;
        }
        return true;
    }
}