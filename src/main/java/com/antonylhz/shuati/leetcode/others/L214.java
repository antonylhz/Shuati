package com.antonylhz.shuati.leetcode.others;

public class L214 {
	public static void main(String[] args) {
		System.out.println((new L214()).shortestPalindrome("ab"));
	}
    public String shortestPalindrome(String s) {
        if(s==null||s.length()<2) return s;
        for(int i=(s.length()-1)/2; i>=-1; i--) {
            if(i+2<s.length()) {
                String s1 = shortestPalindrome(s, i, i+2);
                if(s1.length()>0) return s1;
            }
            String s2 = shortestPalindrome(s, i, i+1);
            if(s2.length()>0) return s2;
        }
        return "";
    }
    
    private String shortestPalindrome(String s, int i, int j) {
        while(i>=0) 
        	if(s.charAt(i--)!=s.charAt(j++))
        		return "";
        StringBuilder sb = new StringBuilder();
        for(int n=s.length()-1; n>=j; n--) sb.append(s.charAt(n));
        sb.append(s);
        return sb.toString();
    }
}
