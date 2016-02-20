public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int len = nums.length - k + 1;
        int[] result = new int[len];
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        });
        int i = 0, j = 0;
        while (j < k) heap.add(nums[j++]);
        result[0] = heap.peek();
        while (j < nums.length) {
            heap.remove(nums[i++]);
            heap.add(nums[j++]);
            result[i] = heap.peek();
        }
        return result;
    }
}