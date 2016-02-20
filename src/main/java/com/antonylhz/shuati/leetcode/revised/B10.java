package com.antonylhz.shuati.leetcode.revised;

import java.util.HashMap;
public class B10 {
	public static void main(String[] args) {
		B10 solution = new B10();
		System.out.println(solution.lengthOfLongestSubstring("abcabde"));
	}
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for(int i=0, j=0; j<=s.length(); j++) {
			if(j==s.length()||map.containsKey(s.charAt(j))) {
				max = Math.max(max, j-i);
				if(j<s.length()) i = map.get(s.charAt(j))+1;
			} else map.put(s.charAt(j), j);
		}
		return max;
	}
}
