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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> values = new ArrayList<Integer>();
            List<TreeNode> level = new ArrayList<TreeNode>();
            for (TreeNode node : q) {
                values.add(node.val);
                if (node.left != null) level.add(node.left);
                if (node.right != null) level.add(node.right);
            }
            q = level;
            result.add(0, values);
        }
        return result;
    }
}