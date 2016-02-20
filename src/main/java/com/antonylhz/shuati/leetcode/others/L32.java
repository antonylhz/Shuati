package com.antonylhz.shuati.leetcode.others;

public class L32 {
	public static void main(String[] args) {
		System.out.println((new L32()).longestValidParentheses("(())"));
	}
	
    public int longestValidParentheses(String s) {
    	if(s==null||s.length()<2) return 0;
    	int maxlen = 0;
    	int[] len = new int[s.length()];
    	len[0] = 0;
    	for(int i=1; i<s.length(); i++) {
    		if(s.charAt(i)==')') {
    			if(s.charAt(i-1)=='(') {
    				len[i] = 2 + (i==1?0:len[i-2]);
    			} else {
    				if(len[i-1]==0) len[i] = 0;
    				else {
    					if(i-len[i-1]>0&&s.charAt(i-len[i-1]-1)=='(') {
	    				    len[i] = len[i-1] + 2;
	    					if(i-len[i-1]-2>=0) {
	    						len[i] += len[i-len[i-1]-2];
	    					}
    					}
    				}
    			}
    		}
    		maxlen = Math.max(maxlen, len[i]);
    	}
    	return maxlen;
    }
}
