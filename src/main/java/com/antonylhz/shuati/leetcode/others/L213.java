package com.antonylhz.shuati.leetcode.others;

public class L213 {
	public static void main(String[] args) {
		int[] money = new int[] {1, 1, 1};
		L213 solution = new L213();
		System.out.println(solution.rob(money));
	}
    public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        return Math.max(nums[0]+rob(nums, 2, nums.length-1), rob(nums, 1, nums.length));
    }
    private int rob(int[] nums, int start, int end) {
        if(start>=end) return 0;
        int skip = 0, rob = 0;
        for(int i=start; i<end; i++) {
            int temp = rob;
            rob = skip + nums[i];
            skip = Math.max(skip, temp);
        }
        return Math.max(skip, rob);
    }
}
