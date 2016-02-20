/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {

    /**
     * binary search first true
     */
    public int firstBadVersion(int n) {
        int from = 1, to = n;
        while(from <= to) {
            int mid = from + (to - from) / 2;
            if(isBadVersion(mid)) {
                if(mid==1 || !isBadVersion(mid-1)) {
                    return mid;
                } else {
                    to = mid - 1;
                }
            } else {
                from = mid + 1;
            }
        }
        return from;
    }

}
