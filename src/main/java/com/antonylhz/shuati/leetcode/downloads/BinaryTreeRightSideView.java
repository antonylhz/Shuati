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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        List<TreeNode> cur = new ArrayList<TreeNode>(), next = new ArrayList<TreeNode>();
        cur.add(root);
        while(cur.size()>0) {
            int last = 0;
            for(TreeNode node : cur) {
                last = node.val;
                if(node.left!=null) next.add(node.left);
                if(node.right!=null) next.add(node.right);
            }
            result.add(last);
            cur.clear();
            cur.addAll(next);
            next.clear();
        }
        return result;
    }
}
