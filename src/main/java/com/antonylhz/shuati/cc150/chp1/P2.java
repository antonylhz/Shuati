package com.antonylhz.shuati.cc150.chp1;

/* Write code to reverse a C-Style String. 
 * (C-String means that “abcd” is represented as
 * five characters, including the null character.)
 * 
 * Ans: swap head and tail
 * 
 */



public class P2 {
	public static void main(String[] args) {
		char[] str = new char[] {
			'a', 'b', 'c', 'd', '\0'
		};
		reverse(str);
		System.out.println(str);
	}
	
	private static void reverse(char[] s) {
		int i=0, j= s.length-2;
		while(i<j) {
			char t = s[i];
			s[i] = s[j];
			s[j] = t;
			i++;
			j--;
		}
	}
}
