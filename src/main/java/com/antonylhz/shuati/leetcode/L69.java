package com.antonylhz.shuati.leetcode;

//Majority Element
//
//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//You may assume that the array is non-empty and the majority element always exist in the array.

public class L69 {
	//Moore voting algorithm
    public int majorityElement(int[] nums) {
        int count = 0, result = 0;
        for(int num : nums) {
        	if(count==0) {
        		count++;
        		result = num;
        	} else {
        		if(num==result) count++;
        		else count--;
        	}
        }
        return result;
    }
}
