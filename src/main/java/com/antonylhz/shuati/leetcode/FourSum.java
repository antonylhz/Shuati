package com.antonylhz.shuati.leetcode;
import java.util.*;
public class FourSum {
	public static void main(String[] args) {
		FourSum solution = new FourSum();
		int[] num = new int[] {8,-5,1,-2,-8,0,10,10,3,-1};
		System.out.println(solution.fourSum(num, -19));
	}
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> sum = new ArrayList<List<Integer>>();
        for(int i=0; i<num.length-1; i++)
            for(int j=i+1; j<num.length; j++) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(num[i]); temp.add(num[j]);
                sum.add(temp);
            }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        for(int i=0; i<sum.size()-1; i++) 
            for(int j=i+1; j<sum.size(); j++) {
                List<Integer> smallpair = sum.get(i);
                List<Integer> bigpair = sum.get(j);
                if(smallpair.get(0)+smallpair.get(1)+bigpair.get(0)+bigpair.get(1)==target) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.addAll(smallpair); temp.addAll(bigpair);
                    Collections.sort(temp);
                    if(map.isEmpty()||!map.containsKey(getHash(i,j))) {
                        map.put(getHash(i,j), true);
                        result.add(temp);
                    }
                }
            }
        return result;
    }
    private String getHash(int num1, int num2) {
        return String.valueOf(num1)+":"+String.valueOf(num2);
    }
}
