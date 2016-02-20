public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int lmask = Integer.MAX_VALUE + 1, rmask = 1, result = 0;
        for (int i = 0; i < 16; i++) {
            int travel = 31 - 2 * i;
            int left = n & lmask, right = n & rmask;
            result |= left >>> travel;
            result |= right << travel;
            lmask >>>= 1;
            rmask <<= 1;
        }
        return result;
    }
}