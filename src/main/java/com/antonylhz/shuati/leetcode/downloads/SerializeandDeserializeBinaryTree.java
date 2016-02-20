/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> reslist = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root != null) list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.removeFirst();
            if (node == null) {
                reslist.add("null");
            } else {
                reslist.add(Integer.toString(node.val));
                list.add(node.left);
                list.add(node.right);
            }
        }
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < reslist.size(); i++) {
            res.append(reslist.get(i));
            if (i < reslist.size() - 1) res.append(",");
        }
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 2) return null;
        String[] tokens = data.substring(1, data.length() - 1).split(",");
        if (tokens[0] == null) return null;
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        for (int i = 1; i < tokens.length; i += 2) {
            TreeNode node = list.removeFirst();
            if (!tokens[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(tokens[i]));
                list.add(node.left);
            }
            if (!tokens[i + 1].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(tokens[i + 1]));
                list.add(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));