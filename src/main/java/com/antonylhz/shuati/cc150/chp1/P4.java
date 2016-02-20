package com.antonylhz.shuati.cc150.chp1;

/* Write a method to decide if two strings are anagrams or not.
 * 
 * 1. HashMap. space O(n). time O(n)
 * 2. Sort
 * 3. Prime multipliers
 */

import java.util.*;

public class P4 {
	public static void main(String[] args) {
		String s1 = "aba", s2 = "baa";
		System.out.println(isAnagram(s1, s2));
	}
	
	private static boolean isAnagram(String s1, String s2){
		if(s1.length()!=s2.length()) return false;
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<s1.length(); i++) {
			char c = s1.charAt(i);
			map.put(c, map.containsKey(c)?map.get(c)+1:1);
		}
		for(int i=0; i<s2.length(); i++) {
			char c = s2.charAt(i);
			if(!map.containsKey(c)||map.get(c)<1) return false;
			map.put(c, map.get(c)-1);
		}
		return true;
	}
}
