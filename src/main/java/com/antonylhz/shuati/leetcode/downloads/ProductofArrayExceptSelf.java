public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length, product = 1;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = product;
            product *= nums[i];
        }
        product = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }
        return result;
    }
}