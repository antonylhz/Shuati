class Node {
    int index;
    List<Node> neighbors;

    public Node(int index) {
        this.index = index;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node n) {
        this.neighbors.add(n);
    }
}

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Node[] graph = new Node[n];
        Set<Integer> res = new HashSet<>();
        for(int i=0; i<n; i++) {
            graph[i] = new Node(i);
            res.add(i);
        }
        for(int i=0; i<n-1; i++) {
            graph[edges[i][0]].addNeighbor(graph[edges[i][1]]);
            graph[edges[i][1]].addNeighbor(graph[edges[i][0]]);
        }
        while(res.size()>2) {
            List<List<Integer>> removals = new ArrayList<>();
            Iterator<Integer> it = res.iterator();
            while(it.hasNext()) {
                int idx = it.next();
                if(graph[idx].neighbors.size() == 1) {
                    it.remove();
                    List<Integer> temp = new ArrayList<>(2);
                    temp.add(idx);
                    temp.add(graph[idx].neighbors.get(0).index);
                    removals.add(temp);
                }
            }
            for(List<Integer> e : removals) {
                Node n1 = graph[e.get(0)], n2 = graph[e.get(1)];
                n1.neighbors.remove(n2);
                n2.neighbors.remove(n1);
            }
        }
        return new ArrayList<Integer>(res);
    }
}