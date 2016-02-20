/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 * int label;
 * List<UndirectedGraphNode> neighbors;
 * UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, Boolean> visited = new HashMap<UndirectedGraphNode, Boolean>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        q.add(node);
        map.put(node, root);
        while (!q.isEmpty()) {
            UndirectedGraphNode curnode = q.poll();
            UndirectedGraphNode newnode = map.get(curnode);
            for (UndirectedGraphNode neighbor : curnode.neighbors) {
                if (visited.containsKey(curnode)) continue;
                if (!map.containsKey(neighbor)) {
                    UndirectedGraphNode newneighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newneighbor);
                }
                newnode.neighbors.add(map.get(neighbor));
                if (!visited.containsKey(neighbor)) {
                    q.add(neighbor);
                }
            }
            visited.put(curnode, true);
        }
        return root;
    }
}