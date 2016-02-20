package com.antonylhz.shuati.hackerrank;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            int N = in.nextInt(), M = in.nextInt();
            List<Map<Integer, Integer>> graph = new ArrayList<>(N+1);
            for(int j=0; j<N+1; j++) graph.add(new LinkedHashMap<Integer, Integer>());
            for(int j=0; j<M; j++) {
                int x = in.nextInt(), y = in.nextInt(), r = in.nextInt();
                if(x!=y) {
                    addEdge(graph, x, y, r);
                    addEdge(graph, y, x, r);
                }
            }
            int s = in.nextInt();
            int[] dist = bfs(graph, s);
            for(int j=1; j<dist.length; j++) {
                if(j!=s) {
                    System.out.print(dist[j]);
                    if(j<dist.length-1) System.out.print(" ");
                }
            }
            if(i<T-1) System.out.println();
        }
    }
    
    static void addEdge(List<Map<Integer, Integer>> graph, int x, int y, int r) {
        Map<Integer, Integer> edges = graph.get(x);
        if(!edges.containsKey(y) || edges.get(y)>r) {
            edges.put(y, r);
        }
    }
    
    static int[] bfs(List<Map<Integer, Integer>> graph, int s) {
        int[] dist = new int[graph.size()];
        boolean[] visited = new boolean[dist.length];
        Arrays.fill(dist, -1);
        dist[s] = 0;
        List<Integer> layer = new ArrayList<Integer>();
        layer.add(s);
        while(!layer.isEmpty()) {
            List<Integer> newLayer = new ArrayList<Integer>();
            for(Integer x : layer) {
                visited[x] = true;
                Map<Integer, Integer> edges = graph.get(x);
                for(int y : edges.keySet()) {
                    if(!visited[y]) newLayer.add(y);
                    int r = edges.get(y);
                    if(dist[y]<0) dist[y] = dist[x] + r;
                    else dist[y] = Math.min(dist[y], dist[x] + r);
                }
            }
            layer = newLayer;
        }
        return dist;
    }
    
}