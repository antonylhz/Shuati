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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = pathSum2(root, sum);
        for (List<Integer> p : paths) Collections.reverse(p);
        return paths;
    }

    private List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
        } else if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(sum);
                res.add(tmp);
            }
        } else {
            if (root.left != null) {
                List<List<Integer>> paths = pathSum2(root.left, sum - root.val);
                for (List<Integer> p : paths) {
                    p.add(root.val);
                }
                res.addAll(paths);
            }
            if (root.right != null) {
                List<List<Integer>> paths = pathSum2(root.right, sum - root.val);
                for (List<Integer> p : paths) {
                    p.add(root.val);
                }
                res.addAll(paths);
            }
        }
        return res;
    }
}
