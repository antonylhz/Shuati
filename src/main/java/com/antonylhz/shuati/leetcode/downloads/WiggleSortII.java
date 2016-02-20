public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] copy = nums.clone();
        int[] ends = {(nums.length+1)/2-1, nums.length-1};
        for (int i=0;i<nums.length;i++)
            nums[i] = copy[ends[i%2]-i/2];
        System.out.println(Arrays.toString(nums));
    }
}