package com.antonylhz.shuati.leetcode.others;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class L313 {
	
	public static void main(String[] args) {
		int[] primes = new int[]{
				3,5,7,11,13,19,31
		};
		System.out.println(nthSuperUglyNumber(60, primes));
	}
	
    public static int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1) return 1;
        n--;
        TreeSet<Integer> cands = new TreeSet<>();
        for(int p : primes) cands.add(p);
        int from = 0, i = 2;
        while(cands.headSet((int)Math.pow(primes[0], i++)).size() < n-1) {
            List<Integer> newCands = new ArrayList<>();
            for(int p : primes) {
                Iterator<Integer> it = cands.iterator();
                while(it.hasNext()) {
                    newCands.add(p*it.next());
                }
            }
            from = cands.size();
            cands.addAll(newCands);
        }
        cands.add((int)Math.pow(primes[0], --i));
        for(i=0; i<n-1; i++) cands.pollFirst();
        return cands.pollFirst();
    }
}
