package com.antonylhz.shuati.leetcode.others;

//Subsets
//
//Given a set of distinct integers, nums, return all possible subsets.
//
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L78 {
	
	public static void main(String[] args) {
		int[] nums1 = new int[]{1,2,3};
		List<List<Integer>> result = (new L78()).subsets(nums1);
		for(List<Integer> item : result) {
			for(int number : item) System.out.print(number + " ");
			System.out.println();
		}
	}
	
    public List<List<Integer>> subsets(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	for(int mask=0; mask<Math.pow(2, nums.length); mask++) {
    		List<Integer> subset = new ArrayList<Integer>();
    		int temp = mask, i = 0;
    		while(temp>0) {
    			if(temp%2>0) subset.add(nums[i]);
    			temp >>=1;
    			i++;
    		}
    		result.add(subset);
    	}
    	return result;
    }

}
