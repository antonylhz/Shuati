public class Solution {
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += nums[j] * nums[i - j - 1];
            }
            nums[i] = sum;
        }
        return nums[n];
    }
}