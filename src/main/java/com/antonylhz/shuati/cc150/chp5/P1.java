package com.antonylhz.shuati.cc150.chp5;

/* You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a
	method to set all bits between i and j in N equal to M (e.g., M becomes a substring of
	N located at i and starting at j).
	EXAMPLE:
	Input: N = 10000000000, M = 10101, i = 2, j = 6
	Output: N = 10001010100
*/

public class P1 {
	public static void main(String[] args) {
		int n = Integer.parseInt("10000000000", 2),
			m = Integer.parseInt("10101", 2);
		System.out.println(Integer.toBinaryString(merge(n, m, 2, 6)));
	}
	
	private static int merge(int n, int m, int i, int j) {
		int mask = ~0;
		/*
		 * 
		 */
		// for(int b=i; b<=j; b++) mask -= 1<<b;
		
		mask -= 1<<j-1;
		mask += 1<<i-1;
		
		return (n&mask)|(m<<i);
	}
}
