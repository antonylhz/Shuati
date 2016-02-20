package com.antonylhz.shuati.leetcode;

//Bitwise AND of Numbers Range
//
//Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
//
//For example, given the range [5, 7], you should return 4.

public class L201 {
    public int rangeBitwiseAnd(int m, int n) {
        int ans=0;
        for (int i=0; i<31; i++) {
            if ((m&(1<<i))>0 && (n&(1<<i))>0 && (n-m+1)<=(1<<i)) {
                ans = ans|(1<<i);
            }
        }
        return ans;
    }
}
