package com.antonylhz.shuati.cc150.chp1;

/*
 * Design an algorithm and write code to remove the duplicate characters in a string
	without using any additional buffer. NOTE: One or two additional variables are fine.
	An extra copy of the array is not.
	FOLLOW UP
	Write the test cases for this method.
 */

public class P3 {
	public static void main(String[] args) {
		char[] s = "aaaaa".toCharArray();
		clean(s);
		System.out.println(s);
	}
	
	private static void clean(char[] s) {
		if(s==null||s.length<2) return;
		int c = 1;
		for(int i=1; i<s.length; i++) {
			int j=0;
			while(s[j]!=s[i]&&j<c) j++;
			if(j==c) {
				s[c] = s[j];
				c++;
			}
		}
		s[c] = 0;
	}
}
