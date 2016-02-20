public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] money = new int[nums.length + 1];
        money[0] = 0;
        money[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            money[i + 1] = Math.max(money[i], money[i - 1] + nums[i]);
        }
        return money[nums.length];
    }
}