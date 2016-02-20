package com.antonylhz.shuati.leetcode;

//Question:
//There are n coins in a line. (Assume n is even). Two players take turns to take a coin
//from one of the ends of the line until there are no more coins left. The player with the
//larger amount of money wins.
//1. Would you rather go first or second? Does it matter?
//2. Assume that you go first, describe an algorithm to compute the maximum amount
//of money you can win.

/*
 * Answer:
 * 1. go first. It ensures that you get all odd or all even coins.
 * 2. the maximum amount is different. use dp.
 */

public class B47 {
	private static int[] coins = new int[] {
		
		// 25, 5, 5, 50, 100, 25
		25, 5, 25, 100, 50, 5
		
	};
	
	private static int[][] tmax = new int[coins.length][coins.length];
	
	public static void main(String[] args) {
		System.out.println(getMax());
	}
	
	private static int getMax() {
		for(int i=0; i<coins.length; i++) {
			tmax[i][i] = coins[i];
		}
		return getMaxInRange(0, coins.length-1);
	}
	
	private static int getMaxInRange(int s, int e) {
		if(tmax[s][e]==0) {
			// if take s, opponent can get either s+1 or e, to minimize your total amount
			int max1 = coins[s];
			if(e-s>=2) max1 += Math.min(getMaxInRange(s+2, e), getMaxInRange(s+1, e-1));
			// if take e, opponent can get either s or e-1, to minimize your total amount
			int max2 = coins[e];
			if(e-s>=2) max2 += Math.min(getMaxInRange(s+1, e-1), getMaxInRange(s, e-2));
			tmax[s][e] = Math.max(max1, max2);
		}
		return tmax[s][e];
	}

}
