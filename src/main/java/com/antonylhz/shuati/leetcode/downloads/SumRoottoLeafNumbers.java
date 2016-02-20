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
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        List<TreeNode> leaf = new ArrayList<TreeNode>();
        List<Integer> value = new ArrayList<Integer>();
        leaf.add(root);
        value.add(root.val);
        int result = root.val, size, temp;
        while(!leaf.isEmpty()) {
            size = leaf.size();
            for(int i=0; i<size; i++) {
                TreeNode node = leaf.get(i);
                if(node.left==null&&node.right==null) continue;
                result -= value.get(i);
                if(node.left!=null) {
                    temp = value.get(i)*10+node.left.val;
                    leaf.add(node.left);
                    value.add(temp);
                    result += temp;
                }
                if(node.right!=null) {
                    temp = value.get(i)*10+node.right.val;
                    leaf.add(node.right);
                    value.add(temp);
                    result += temp;
                }
            }
            for(int i=0; i<size; i++) {
                leaf.remove(0);
                value.remove(0);
            }
        }
        return result;
    }
}
