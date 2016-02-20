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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode node = root;
        int leftheight = 0, rightheight = 0;
        while (node != null) {
            leftheight++;
            node = node.left;
        }
        node = root;
        while (node != null) {
            rightheight++;
            node = node.right;
        }
        int result = (int) (Math.pow(2, leftheight) - 1), fullrow = (int) Math.pow(2, leftheight - 1);
        if (leftheight == rightheight) return result;
        node = root;
        while (true) {
            leftheight--;
            rightheight--;
            TreeNode tempnode = node.left;
            int count = 0;
            while (tempnode != null) {
                tempnode = tempnode.right;
                count++;
            }
            if (count < leftheight) {
                result -= fullrow / 2;
                node = node.left;
                fullrow /= 2;
                continue;
            }
            tempnode = node.right;
            count = 0;
            while (tempnode != null) {
                tempnode = tempnode.left;
                count++;
            }
            if (count == rightheight) {
                result -= fullrow / 2;
                break;
            } else {
                node = node.right;
                fullrow /= 2;
            }
        }
        return result;
    }
}
