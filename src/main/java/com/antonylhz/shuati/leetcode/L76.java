package com.antonylhz.shuati.leetcode;

//Minimum Window Substring
//
//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//For example,
//S = "ADOBECODEBANC"
//T = "ABC"
//Minimum window is "BANC".
//
//Note:
//If there is no such window in S that covers all characters in T, return the emtpy string "".
//
//If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
//

import java.util.*;

class StringLengthComparator implements Comparator<String>
{
    @Override
    public int compare(String x, String y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
        if (x.length() < y.length())
        {
            return -1;
        }
        if (x.length() > y.length())
        {
            return 1;
        }
        return 0;
    }
}

public class L76 {
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC", t = "ABC";
		L76 solution = new L76();
		System.out.println(solution.minWindow(s, t));
	}
	
	/**
	 * @param s, the source string which will be scanned
	 * @param t, the target string whose characters should all be matched
	 * @return the minimum window in s that all characters in t are present
	 * 
	 * Solution: use a hashmap to record how many times certain characters shall be included in the window
	 * and then move the window accordingly
	 */
    public String minWindow(String s, String t) {
    	if(s==null||s.length()==0) return "";
    	HashMap<Character, Integer> target = new HashMap<Character, Integer>(), state = new HashMap<Character, Integer>();
    	for(int i=0; i<t.length(); i++) {
    		char c = t.charAt(i);
    		if(target.containsKey(c)) target.put(c, target.get(c)+1);
    		else target.put(c, 1);
    	}
    	int i = -1, j = 0;
    	PriorityQueue<String> options = new PriorityQueue<String>(10, new StringLengthComparator());
    	List<Integer> list = new ArrayList<Integer>();
    	while(j<s.length()) {
    		char c = s.charAt(j);
    		if(target.containsKey(c)) {
    			if(state.containsKey(c)) state.put(c, state.get(c)+1);
    			else state.put(c, 1);
    			if(i<0) i = j;
    			list.add(j);
    		}
    		j++;
    	}
    	return options.peek();
    }
}
