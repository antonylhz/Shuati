public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        return Math.max(rob(nums, 1, nums.length), nums[0] + rob(nums, 2, nums.length - 1));
    }

    int rob(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int[] money = new int[end - start + 1];
        money[0] = 0;
        money[1] = nums[start];
        for (int i = 2; i < money.length; i++) {
            money[i] = Math.max(money[i - 1], money[i - 2] + nums[start + i - 1]);
        }
        return money[end - start];
    }
}