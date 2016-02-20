package com.antonylhz.shuati.leetcode.revised;

/*
 * 46. Maximum Product Subarray
 * 
 * [DP] maintain two arrays, pos[i] and neg[i]
 * pos[i] is the largest product of the subarray ending at i
 * neg[i] is the largest abs of the product of the subarray ending at i
 * 
 * Mar 26, 2015
 * 
 */

public class B46 {
	public static void main(String[] args) {
		int[] ints = new int[] {
				-2,-2,2,2,-2
		};
		System.out.println((new B46()).maxProduct(ints));
	}
	public int maxProduct(int[] ints) {
		assert ints.length>0;
		int min = ints[0]; int max = ints[0], result = ints[0];
		for(int i=1; i<ints.length; i++) {
			max = Math.max(ints[i], Math.max(ints[i]*min, ints[i]*max));
			min = Math.min(ints[i], Math.min(ints[i]*min, ints[i]*max));
			result = Math.max(result, max);
		}
		return result;
	}

	
	public int maxProduct2(int[] ints) {
		int len = ints.length, max = 0;
		int[] pos = new int[len], neg = new int[len];
		pos[0] = ints[0]>0?ints[0]:0;
		neg[0] = ints[0]<0?ints[0]:0;
		max = pos[0];
		for(int i=1; i<len; i++) {
			if(ints[i]==0) {
				pos[i] = 0;
				neg[i] = 0;
			} else if(ints[i]<0) {
				if(ints[i-1]==0) {
					neg[i] = ints[i];
				} else {
					pos[i] = ints[i]*neg[i-1];
					neg[i] = ints[i]*pos[i-1];
				}
			} else {
				if(ints[i-1]==0) {
					pos[i] = ints[i];
				} else {
					pos[i] = ints[i]*pos[i-1];
					neg[i] = ints[i]*neg[i-1];
				}
			}
			max = Math.max(max, pos[i]);
		}
		return Math.max(max, pos[len-1]);
	}
}




