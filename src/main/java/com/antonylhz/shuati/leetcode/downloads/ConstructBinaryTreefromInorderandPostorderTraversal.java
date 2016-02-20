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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    private TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        if((instart-inend)==0||(inend-instart)!=(postend-poststart)) return null;
        TreeNode root = new TreeNode(postorder[postend-1]);
        int leftLen = 0, i = instart;
        for(; i<inend; i++) {
            if(inorder[i]==root.val) {
                leftLen = i - instart;
                break;
            }
        }
        root.left = buildTree(inorder, instart, i, postorder, poststart, poststart+leftLen);
        root.right = buildTree(inorder, i+1, inend, postorder, poststart+leftLen, postend-1);
        return root;
    }
}
