package com.antonylhz.shuati.leetcode;

import java.util.HashMap;

public class PalindromeMinCut {
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaa";
		System.out.println((new PalindromeMinCut()).minCut(s));
	}
	
    public int minCut(String s) {
        if(s==null||s.length()<2) return 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        boolean[][] isP = new boolean[len][len];
        for(int i=0; i<len;i++) 
            for (int j=0; j<len; j++) 
                isP[i][j] = (i==j)?true:false;
        for(int d=1; d<len; d++) 
            for(int i=0; i<len-d; i++)
                isP[i][i+d] = (chars[i]==chars[i+d])&&(d==1||isP[i+1][i+d-1]);
        
        //Mapping from last index to mincut
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        map.put(-1, -1);
        int cut, mincut = Integer.MAX_VALUE;
        for(int i=0; i<len; i++){
            if(!map.containsKey(i-1)) continue;
            cut = map.get(i-1) + 1;
            for(int j=0; j<len; j++) {
                if(isP[i][j]&&(!map.containsKey(j)||map.get(j)>cut)) {
                    map.put(j, cut);
                    if(j==len-1) mincut = mincut>cut?cut:mincut;
                }
            }
        }
        return mincut;
    }
}
