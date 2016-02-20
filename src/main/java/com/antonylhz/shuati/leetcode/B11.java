package com.antonylhz.shuati.leetcode;

/*
 * [Leetcode book] 11. Longest Substring with At Most Two Distinct Characters
 * 
 * Idea 1
 * [DP] Define dp[i, j] as the longest substring from i to j with at most two distinct characters.
 * then dp[i , i] = 1
 * either take j or not
 * dp[i, j] = dp[i, j-1]+1 if chars[j] don't occur within i and j-1;
 * 			= dp[i, j-1] otherwise.
 * O(n3) time....
 * 
 * Idea 2
 * For each position, maintain a hashtable of available characters.
 * O(n) time, O(n) space
 * 
 * Idea 3
 * sliding window
 * 
 * antonylhz mar26, 2015
 */

import java.util.*;
import java.util.Map.Entry;

public class B11 {
	public static void main(String[] args) {
		String str = "abaac"; //"deececececeba";
		System.out.println((new B11()).lengthOfLongestSubstringKDistinct(str, 2));
	}
	
	public int lengthOfLongestSubstringKDistinct(String str, int k) {
		// Maps from existing character in the current sliding window to its last index
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		if(str==null||str.length()<k) return str.length();
		char[] chars = str.toCharArray();
		int maxlen = 0, len = 0;
		for(int i=0; i<chars.length; i++) {
			if(map.isEmpty() || map.containsKey(chars[i]) || map.size()<k) {
				map.put(chars[i], i);
				len++;
			} else { // when new character comes and the map is full, we must move the start of current sliding window
				if(len>maxlen) maxlen = len;
				int start = Integer.MAX_VALUE;
				char c = ' ';
				Iterator<Entry<Character, Integer>> it = map.entrySet().iterator();
				while(it.hasNext()) {
					Entry<Character, Integer> entry = it.next();
					if(entry.getValue()<start) {
						start = entry.getValue();
						c = entry.getKey();
					}
				}
				if(c!=' ')map.remove(c);
				map.put(chars[i], i);
				len = i - start;
			}
		}
		return maxlen;
	}
}










