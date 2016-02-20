public class Solution {
    public int trailingZeroes(int n) {
        int base = 5, count = 0;
        while(base<=n) {
            count += n/base;
            if(base>Integer.MAX_VALUE/5) break;
            base *= 5;
        }
        return count;
    }
}