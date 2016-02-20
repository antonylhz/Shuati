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
    public int kthSmallest(TreeNode root, int k) {
        int lcount = count(root.left);
        if(lcount>=k) return kthSmallest(root.left, k);
        else if(k>lcount+1) return kthSmallest(root.right, k-lcount-1);
        return root.val;
    }
    private int count(TreeNode node) {
        if(node==null) return 0;
        return 1 + count(node.left) + count(node.right);
    }
}