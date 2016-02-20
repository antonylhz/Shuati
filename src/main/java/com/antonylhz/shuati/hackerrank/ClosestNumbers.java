package com.antonylhz.shuati.hackerrank;

import java.util.*;

public class ClosestNumbers {
    static class Pair {
        int n1, n2;
        public Pair(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }
        public int dist() {
            return this.n2 - this.n1;
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = in.nextInt();
        Arrays.sort(arr);
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(N, new Comparator<Pair>() {
            public int compare(Pair x, Pair y) {
                return x.dist() - y.dist();
            }
        });
        for(int i=1; i<N; i++) pq.add(new Pair(arr[i-1], arr[i]));
        List<Pair> result = new ArrayList<Pair>();
        result.add(pq.poll());
        int closest = result.get(0).dist();
        while(!pq.isEmpty() && pq.peek().dist()==closest) {
            result.add(pq.poll());
        }
        
        Collections.sort(result, new Comparator<Pair>() {
            public int compare(Pair x, Pair y) {
                return x.n1 - y.n1;
            }
        });
        
        for(Pair pair : result) {
            System.out.print(pair.n1 + " " + pair.n2 + " ");
        }
    }
}
