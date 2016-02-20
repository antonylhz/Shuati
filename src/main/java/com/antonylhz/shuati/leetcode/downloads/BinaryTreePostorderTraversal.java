import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        HashMap<TreeNode, Boolean> visited = new HashMap<TreeNode, Boolean>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode node = s.peek();
            if(visited.containsKey(node)) {
                result.add(s.pop().val);
            } else {
                if(node.right!=null) s.push(node.right);
                if(node.left!=null) s.push(node.left);
                visited.put(node, true);
            }
        }
        return result;
    }
}
