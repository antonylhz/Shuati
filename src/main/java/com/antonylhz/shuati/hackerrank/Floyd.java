package com.antonylhz.shuati.hackerrank;

import java.util.*;

public class Floyd {
	static class Node {
        int index;
        Map<Integer, Integer> neighbors;
        Map<Node, Integer> cache;
        public Node(int index) {
            this.index = index;
            neighbors = new HashMap<>();
            cache = new HashMap<>();
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        Node[] graph = new Node[n];
        for(int i=0; i<n; i++) {
            graph[i] = new Node(i);
        }
        for(int i=0; i<m; i++) {
            Node orig = graph[in.nextInt()-1];
            int dest = in.nextInt()-1, dist = in.nextInt();
            orig.neighbors.put(dest, Math.min(dist, 
            		orig.neighbors.containsKey(dest) ? orig.neighbors.get(dest) : Integer.MAX_VALUE
            ));
        }
        int q = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<q; i++) {
            sb.append(getDistance(graph, in.nextInt()-1, in.nextInt()-1)).append("\n");
        }
        in.close();
        System.out.print(sb.toString());
    }
    
    private static int getDistance(Node[] graph, int s, int d) {
    	System.err.println(s + "->" + d);
    	int res = Integer.MAX_VALUE;
        if(s == d) {
            res = 0;
        } else if(graph[s].neighbors.size() == 0) {
            res = -1;
        } else if(graph[s].cache.containsKey(graph[d])) {
            return graph[s].cache.get(graph[d]);
        } else {
	        graph[s].cache.put(graph[d], -1);
	        for(int n : graph[s].neighbors.keySet()) {
	            int nd = getDistance(graph, n, d);
	            if(nd < 0) continue;
	            res = Math.min(res, graph[s].neighbors.get(n) + nd);
	        }
	        if(res == Integer.MAX_VALUE) res = -1;
	        graph[s].cache.put(graph[d], res);
        }
        System.err.println(res);
        return res;
    }
}
