public class Solution {
    public int missingNumber(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long n = nums.length;
        long allsum = n * (n + 1) / 2;
        return (int) (allsum - sum);
    }
}