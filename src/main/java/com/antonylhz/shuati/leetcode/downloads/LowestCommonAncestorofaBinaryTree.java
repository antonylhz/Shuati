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

    TreeNode lca, p, q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        boolean[] state = dfs(root);
        return state[0] && state[1] ? lca : null;
    }

    private boolean[] dfs(TreeNode node) {
        boolean[] state = new boolean[2];
        if (node == null) return state;
        boolean[] lstate = dfs(node.left);
        boolean[] rstate = dfs(node.right);
        state[0] = node == p || lstate[0] || rstate[0];
        state[1] = node == q || lstate[1] || rstate[1];
        if (state[0] && state[1] && lca == null) lca = node; //there is only one change to assign lca
        return state;
    }
}
