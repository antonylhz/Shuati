public class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length, target);
    }

    private boolean search(int[] nums, int start, int end, int target) {
        if(start>=end) return false;
        while(start<end-1&&nums[start]==nums[start+1]) start++;
        if(end-start==1) return nums[start]==target;
        while(end>1&&nums[end-1]==nums[end-2]) end--;
        if(nums[start]==target||nums[end-1]==target) return true;
        if(nums[start]==nums[end-1]) {
            start++;
            end--;
        }
        if(nums[start]==target||nums[end-1]==target) return true;
        if(end-start<3) return false;
        int mid = (start+end-1)/2;
        if(nums[mid]==target) return true;
        if(nums[start]>nums[end-1]) {
            if(nums[mid]<nums[start]&&nums[mid]<nums[end-1])
                return target>nums[mid]?search(nums, start, mid, target):search(nums, mid+1, end, target);
            else if(nums[mid]>nums[start])
                return (target>nums[mid]||target<nums[end-1])?search(nums, mid+1, end, target):search(nums, start, mid, target);
            else
                return (target>nums[mid]&&target<nums[end-1])?search(nums, mid+1, end, target):search(nums, start, mid, target);
        } else {
            if(nums[mid]>nums[start]&&nums[mid]<nums[end-1])
                return target>nums[mid]?search(nums, mid+1, end, target):search(nums, start, mid, target);
            else if(nums[mid]<nums[start])
                return (target<nums[start]&&target>nums[mid])?search(nums, start, mid, target):search(nums, mid+1, end, target);
            else
                return (target<nums[mid]&&target>nums[end-1])?search(nums, mid+1, end, target):search(nums, start, mid, target);
        }
    }
}
