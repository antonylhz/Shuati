package com.antonylhz.shuati.leetcode.others;

//Contains Duplicate
//
//Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

import java.util.HashMap;

public class L217 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num)) return true;
            else map.put(num, true);
        }
        return false;
    }
}
