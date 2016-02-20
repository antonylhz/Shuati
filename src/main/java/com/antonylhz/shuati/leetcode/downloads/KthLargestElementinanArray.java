public class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for(int num : nums) list.add(num);
        return findKthLargest(list, 0, nums.length, k);
    }
    private int findKthLargest(List<Integer> nums, int start, int end, int k) {
        if(end-start==1) return nums.get(start);
        int pivot = (int)((nums.get(start)+nums.get(end-1))/2);
        int lcount = 0, mcount = 0, rcount = 0;
        for(int i = start; i<end; i++) {
            if(lcount+mcount+rcount>=end-start) break;
            if(nums.get(i)>pivot) {
            	int temp = nums.remove(i);
            	nums.add(start, temp);
                lcount++;
            } else if(nums.get(i)<pivot) {
                int temp = nums.remove(i);
                nums.add(end-1, temp);
                rcount++;
                i--;
            } else mcount++;
        }
        if(lcount>=k) return findKthLargest(nums, start, start+lcount, k);
        else if(lcount+mcount>=k) return pivot;
        else return findKthLargest(nums, end-rcount, end, k-lcount-mcount);
    }
}
