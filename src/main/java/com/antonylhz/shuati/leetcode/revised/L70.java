package com.antonylhz.shuati.leetcode.revised;

//Climbing Stairs
//
//You are climbing a stair case. It takes n steps to reach to the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class L70 {
    public int climbStairs(int n) {
        if(n<=1) return 1;
        int[] steps = new int[n+1];
        steps[0] = 1;
        steps[1] = 1;
        for(int i=2; i<=n; i++) 
            steps[i] = steps[i-1] + steps[i-2];
        return steps[n];
    }
}
