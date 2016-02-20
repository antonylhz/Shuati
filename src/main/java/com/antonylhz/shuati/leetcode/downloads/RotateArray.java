public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (nums.length < 2 || k < 1) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int st, int en) {
        if (st >= en) return;
        int temp;
        while (st < en) {
            temp = nums[en];
            nums[en] = nums[st];
            nums[st] = temp;
            st++;
            en--;
        }
    }
}