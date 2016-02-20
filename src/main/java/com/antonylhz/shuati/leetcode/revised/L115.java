package com.antonylhz.shuati.leetcode.revised;

//Distinct Subsequences 
//
//Given a string S and a string T, count the number of distinct subsequences of T in S.
//
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//Here is an example:
//S = "rabbbit", T = "rabbit"
//
//Return 3.

public class L115 {
	public static void main(String[] args) {
		System.out.println((new L115()).numDistinct("rabbbit", "rabbit"));
	}
	
    public int numDistinct(String s, String t) {
        if(s==null||t==null||t.length()==0) return 0;
        int[] cnt = new int[t.length()];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            for(int j=t.length()-1; j>=0; j--) {
                if(c==t.charAt(j)) {
                    if(j==0) cnt[j]++;
                    else cnt[j] += cnt[j-1];
                }
            }
        }
        return cnt[t.length()-1];
    }
}
