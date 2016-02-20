package com.antonylhz.shuati.cc150.chp1;

/*
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures?
 * 
 * 1. Ask Questions: what kind of string? ASCII? Or just letters?
 * 2. Design algorithms: 1. hashset. space O(#uniq chars). 2. bit vectors
 * 5. Test: null, empty, long, all uniq, some dups
 * 
 */

import java.util.*;

public class P1 {
	public static void main(String[] args) {
		String str = "abcdfghf";
		System.out.println(hasDups1(str)?"No":"Yes");
		System.out.println(hasDups2(str)?"No":"Yes");
	}
	
	private static boolean hasDups1(String s) {
		Set<Character> cs = new HashSet<>();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(cs.contains(c)) return true;
			cs.add(c);
		}
		return false;
	}
	
	private static boolean hasDups2(String s) {
		int bv = 0;
		for(int i=0; i<s.length(); i++) {
			int t = 1<<(int)(s.charAt(i)-'a');
			if((t & bv) != 0) return true;
			bv += t;
		}
		return false;
	}
}	
