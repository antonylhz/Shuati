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
    private TreeNode swap1 = null, swap2 = null, last = null;

    public void recoverTree(TreeNode root) {
        if (root != null) morris(root);
        if (swap1 != null && swap2 != null) {
            int temp = swap1.val;
            swap1.val = swap2.val;
            swap2.val = temp;
        }
    }

    private void morris(TreeNode cur) {
        while (cur != null) {
            if (cur.left == null) {
                report(cur);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while (pre.right != null && pre.right != cur) pre = pre.right;
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    report(cur);
                    cur = cur.right;
                }
            }
        }
    }

    private void report(TreeNode node) {
        if (last != null && last.val >= node.val) {
            if (swap1 == null) swap1 = last;
            swap2 = node;
        }
        last = node;
    }
}
