public class Solution {
    public void sortColors(int[] nums) {
        int second = nums.length - 1, zero = 0;
        for (int i = 0; i <= second; i++) {
            while (nums[i] == 2 && i < second) swap(nums, i, second--);
            while (nums[i] == 0 && i > zero) swap(nums, i, zero++);
        }
    }

    private void swap(int[] nums, int s1, int s2) {
        int temp = nums[s1];
        nums[s1] = nums[s2];
        nums[s2] = temp;
    }
}