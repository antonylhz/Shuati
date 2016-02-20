package com.antonylhz.shuati.leetcode;

//Decode Ways
//
//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given an encoded message containing digits, determine the total number of ways to decode it.
//
//For example,
//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//The number of ways decoding "12" is 2.

public class L91 {
    public int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0') return 0;
        char[] chars = s.toCharArray();
        int[] decode = new int[s.length()+1];
        decode[0] = 1;
        decode[1] = 1;
        for(int i=2; i<=s.length(); i++) {
            if(chars[i-1]!='0') decode[i] += decode[i-1];
            if(chars[i-2]=='1'||(chars[i-2]=='2'&&chars[i-1]<='6')) decode[i] += decode[i-2];
        }
        return decode[s.length()];
    }
}
