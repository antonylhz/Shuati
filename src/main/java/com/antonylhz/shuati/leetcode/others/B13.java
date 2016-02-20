package com.antonylhz.shuati.leetcode.others;

public class B13 {
	public static void main(String[] args) {
		B13 solution = new B13();
		System.out.println(solution.longestPalindrome("ababababababababa"));
	}
	public String longestPalindrome(String s) {
		if(s==null||s.length()<2) return s;
		int[] plen = new int[s.length()];
		plen[0] = 1; // the longest palindrome length when the ending index is i
		int max = 1;
		String result=s.substring(0,1);
		for(int i=1; i<s.length(); i++) {
			if(i>plen[i-1] && s.charAt(i)==s.charAt(i-plen[i-1]-1)) plen[i] = plen[i-1] + 2;
			else if(s.charAt(i)==s.charAt(i-1)) {
				plen[i] = 2;
				for(int j=i-2; j>=0; j--) {
					if(s.charAt(i)==s.charAt(j)) plen[i]++;
					else break;
				}
			} else if(i>=2&&s.charAt(i)==s.charAt(i-2)) plen[i] = 3;
			else plen[i] = 1;
			if(plen[i]>max) {
				max = plen[i];
				result = s.substring(i-plen[i]+1, i+1);
			}
		}
		return result;
	}
}
