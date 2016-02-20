package com.antonylhz.shuati.leetcode;

//Contains Duplicate II 
//
//Given an array of integers and an integer k, find out whether there there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

import java.util.*;

public class L219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])&&i-map.get(nums[i])<=k) return true;
            else map.put(nums[i], i);
        }
        return false;
    }
}
