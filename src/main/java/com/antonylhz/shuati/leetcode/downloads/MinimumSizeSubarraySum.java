public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (true) {
            if (sum <= s) {
                if (j == nums.length) break;
                sum += nums[j++];
            } else sum -= nums[i++];
            if (sum >= s) min = Math.min(min, j - i);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}