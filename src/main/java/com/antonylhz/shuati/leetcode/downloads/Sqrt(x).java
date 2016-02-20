public class Solution {
    public int sqrt(int x) {
        if (x == 0) return 0;
        if (x < 0) return -1;
        int lo = 1, hi = x;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }
}