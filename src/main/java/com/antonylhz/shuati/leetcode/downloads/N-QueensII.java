public class Solution {
    long upperlim = 1;
    int sum = 0;

    public int totalNQueens(int n) {
        upperlim = (upperlim << n) - 1;
        test(0, 0, 0);
        return sum;
    }

    private void test(long row, long ld, long rd) {
        if (row != upperlim) {
            long pos = upperlim & ~(row | ld | rd);
            while (pos != 0) {
                long p = pos & -pos;
                pos -= p;
                test(row + p, (ld + p) << 1, (rd + p) >> 1);
            }
        } else {
            sum++;
        }
    }
}