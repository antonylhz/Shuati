package com.antonylhz.shuati.hackerrank.worldcup15;

import java.util.*;

public class NimSum {

    static int cnt = 0;
    static int[] arr;
    static Set<String> result = new HashSet<String>();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = in.nextInt();
        }
        int nsum = 0;
        for(int num : arr) {
            nsum ^= num;
        }
        
        count(0, nsum, 0, new StringBuilder());
        
        System.out.println(cnt);
    }
    
    static void count(int cur, int nsum, int sum, StringBuilder past) {
        if(cur>=arr.length) {
            if(sum>0) {
                past.append(sum).append(" ");
                nsum ^= sum;
            }
            if(nsum==0) {
                String cand = past.toString();
                if(!result.contains(cand)) {
                    cnt++;
                    System.out.println(cand);
                    result.add(cand);
                }
            }
        } else {
            if(sum==0) {
            	// just move on
            	count(cur+1, nsum, 0, (new StringBuilder(past)).append(arr[cur]).append(" "));
                if(cur+1<arr.length) {
                	int tsum = arr[cur] + arr[cur+1], tnsum = nsum ^ arr[cur] ^ arr[cur+1];
                    count(cur+2, tnsum ^ tsum, 0, (new StringBuilder(past)).append(tsum).append(" "));
                    count(cur+2, tnsum, tsum, new StringBuilder(past));
                }
            } else {
            	int tsum = sum + arr[cur], tnsum = nsum ^ arr[cur];
            	count(cur+1, tnsum^tsum, 0, (new StringBuilder(past)).append(tsum).append(" "));
            	count(cur+1, tnsum, tsum, new StringBuilder(past));
            }
        }
    }
}
