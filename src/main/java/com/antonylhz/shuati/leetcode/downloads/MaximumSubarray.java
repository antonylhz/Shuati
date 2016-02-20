public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = nums[0], max = sum;
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) sum = 0;
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}