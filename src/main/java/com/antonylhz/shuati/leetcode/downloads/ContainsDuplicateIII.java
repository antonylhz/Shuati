public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k < 0 || nums == null) return false;
        HashMap<Long, Integer> map = new HashMap<>();
        long[] newnums = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newnums[i] = (long) nums[i] - (long) Integer.MIN_VALUE;
        }
        for (int i = 0; i < newnums.length; i++) {
            if (i > k) {
                long bucket = newnums[i - k - 1] / ((long) t + 1);
                if (map.containsKey(bucket) && map.get(bucket) == i - k - 1) map.remove(bucket);
            }
            long bucket = newnums[i] / ((long) t + 1);
            if (map.containsKey(bucket) ||
                    (map.containsKey(bucket - 1) && newnums[i] - newnums[map.get(bucket - 1)] <= t) ||
                    (map.containsKey(bucket + 1) && newnums[map.get(bucket + 1)] - newnums[i] <= t)) {
                return true;
            }
            map.put(bucket, i);
        }
        return false;
    }
}