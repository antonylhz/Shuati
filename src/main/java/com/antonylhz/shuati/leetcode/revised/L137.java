package com.antonylhz.shuati.leetcode.revised;

//Single Number II 
//
//Given an array of integers, every element appears three times except for one. Find that single one.
//
//Note:
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class L137 {
	public static void main(String[] args) {
		System.out.println((new L137()).singleNumber(new int[]{1, 2, 1, 1}));
	}
	
    public int singleNumber(int[] nums) {
    	int x1 = 0;   
        int x2 = 0; 
        int mask = 0;

        for (int i : nums) {
           x2 ^= x1 & i;
           x1 ^= i;
           mask = ~(x1 & x2);
           x2 &= mask;
           x1 &= mask;
        }

        return x1;
    }
}
