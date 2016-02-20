public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int mask = ~0;
        while (mask != 0)
        {
            if ((m & mask) == (n & mask))
            {
                break;
            }
            mask <<= 1;
        }
        return m & mask;
    }
}