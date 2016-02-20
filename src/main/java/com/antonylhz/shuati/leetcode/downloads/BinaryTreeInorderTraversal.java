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
    Stack<TreeNode> s = new Stack<TreeNode>();

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        s.push(root);
        expand();
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            result.add(node.val);
            if (node.right != null) {
                s.push(node.right);
                expand();
            }
        }
        return result;
    }

    private void expand() {
        if (!s.isEmpty()) {
            TreeNode node = s.peek();
            while (node.left != null) {
                node = node.left;
                s.push(node);
            }
        }
    }
}

