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
    private Map<Integer, Integer> inmap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            inmap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder, 0, preorder.length);
    }

    private TreeNode buildTree(int[] preorder, int ps, int[] inorder, int is, int length) {
        if(length==0) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int llen = inmap.get(root.val) - is;
        root.left = buildTree(preorder, ps+1, inorder, is, llen);
        root.right = buildTree(preorder, ps+llen+1, inorder, is+llen+1, length-llen-1);
        return root;
    }
}