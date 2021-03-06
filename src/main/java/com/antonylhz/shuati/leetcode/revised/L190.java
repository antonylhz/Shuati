package com.antonylhz.shuati.leetcode.revised;

//Reverse Bits 
//
//Reverse bits of a given 32 bits unsigned integer.
//
//For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
//
//Follow up:
//If this function is called many times, how would you optimize it?
//
//Related problem: Reverse Integer

public class L190 {
	public static void main(String[] args) {
		System.out.println((new L190()).reverseBits(1));
	}
	
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int lmask = Integer.MAX_VALUE+1, rmask = 1, result = 0;
        for(int i=0; i<16; i++) {
            int travel = 31 - 2 * i;
            int left = n & lmask, right = n & rmask;
            result |= left>>>travel;
            result |= right<<travel;
            lmask >>>= 1;
            rmask <<= 1;
        }
        return result;
    }
}
