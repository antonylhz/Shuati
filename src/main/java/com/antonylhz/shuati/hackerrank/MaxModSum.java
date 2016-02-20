package com.antonylhz.shuati.hackerrank;

import java.util.*;

public class MaxModSum {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            int N = in.nextInt();
            long M = in.nextLong();
            long[] arr = new long[N];
            for(int j=0; j<N; j++) arr[j] = in.nextLong();
            Set<Long> set = new HashSet<Long>();
            set.add(arr[0]%M);
            for(int j=1; j<N; j++) {
                Set<Long> newset = new HashSet<Long>();
                newset.add(arr[j]%M);
                for(Long num : set) {
                    newset.add((num+arr[j])%M);
                }
                set = newset;
            }
            List<Long> list = new ArrayList<Long>(set);
            Collections.sort(list);
            System.out.println(list.get(list.size()-1));
        }
    }
}
