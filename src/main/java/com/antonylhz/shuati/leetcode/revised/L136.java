package com.antonylhz.shuati.leetcode.revised;

//Single Number
//
//Given an array of integers, every element appears twice except for one. Find that single one.
//
//Note:
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class L136 {
	public static void main(String[] args) {
		System.out.println((new L136()).singleNumber(new int[]{1, 2, 1}));
	}
	
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums) result ^= num;
        return result;
    }
}
