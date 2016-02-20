/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        if (root == null) return;
        s.push(root);
        expand();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (!hasNext()) return Integer.MIN_VALUE;
        TreeNode node = s.pop();
        if (node.right != null) {
            s.push(node.right);
            expand();
        }
        return node.val;
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

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
 