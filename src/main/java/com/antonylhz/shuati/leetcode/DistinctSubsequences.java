package com.antonylhz.shuati.leetcode;
import java.util.*;
public class DistinctSubsequences {
	public static void main(String[] args) {
		DistinctSubsequences solution = new DistinctSubsequences();
		System.out.println(solution.numDistinctDQ("rabbbit", "rabbit"));
	}
    public int numDistinct(String S, String T) {
        if(S==null||S.length()==0) return 0;
        else if(T==null||T.length()==0) return 1;
        HashMap<Character, HashMap<Integer, Integer>> map = new HashMap<Character, HashMap<Integer, Integer>>();
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        temp.put(0, 1);
        map.put(T.charAt(0), temp);
        for(int i=0; i<S.length(); i++) {
        	if(map.containsKey(S.charAt(i))) {
        		Iterator<Map.Entry<Integer, Integer>> it = map.get(S.charAt(i)).entrySet().iterator();
        		while(it.hasNext()) {
        			Map.Entry<Integer, Integer> entry = it.next();
        			int next = entry.getKey()+1;
        			//int count = entry.getValue();
        			if(next<T.length()) {
	        			char nextchar = T.charAt(next);
	        			HashMap<Integer, Integer> nextmap;
	        			if(map.containsKey(nextchar)) { 
	        				nextmap = map.get(nextchar);
	        				nextmap.put(next, 1+(nextmap.containsKey(next)?nextmap.get(next):0));
	        			} else {
	        				nextmap = new HashMap<Integer, Integer>();
	        				nextmap.put(next, 1);
	        			}
	        			map.put(nextchar, nextmap);
        			}
        		}
        	}
        }
        return map.get(T.charAt(T.length()-1)).get(T.length()-1);
    }
    public int numDistinctDQ(String S, String T) {
        if(S.length()==0) return 0;
        else if(T.length()==0) return 1;
        char target = T.charAt(0);
        int result = 0;
        for(int i=0; i<S.length(); i++) {
            if(S.charAt(i)==target) result += numDistinctDQ(S.substring(i+1), T.substring(1));
        }
        return result;
    }
}
