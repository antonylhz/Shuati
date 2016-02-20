package com.antonylhz.shuati.leetcode;

import java.util.*;

public class L216 {
	public static void main(String[] args) {
		System.out.println((new L216()).combinationSum3(3, 9));
	}
    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(k, n, 9);
    }
    List<List<Integer>> combinationSum3(int k, int n, int max) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(k==1) {
            List<Integer> temp = new ArrayList<Integer>();
            if(n<=max) temp.add(n);
            result.add(temp);
        } else {
            for(int last = Math.min(n-1, max); last > n/k; last--) {
                List<List<Integer>> partial = combinationSum3(k-1, n-last, last-1);
                if(partial.isEmpty()) continue;
                for(List<Integer> temp : partial) temp.add(last);
                result.addAll(partial);
            }
        }
        return result;
    }
}
