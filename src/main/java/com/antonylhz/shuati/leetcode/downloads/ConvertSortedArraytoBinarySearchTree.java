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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0) return null;
        return sortedArrayToBST(nums, 0, nums.length);
    }
    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if(mid==start) return root;
        if(mid>start) root.left = sortedArrayToBST(nums, start, mid);
        if(mid<end-1) root.right = sortedArrayToBST(nums, mid+1, end);
        return root;
    }
}