public class Solution {
    public double pow(double x, int n) {
        if (n == 0) return 1;
        else if (x == 1) return 1;
        else if (x == -1) return n % 2 == 0 ? 1 : -1;
        else if (n == 1) return x;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1;
        while (n > 0) {
            if (n % 2 > 0) result *= x;
            x *= x;
            n >>= 1;
        }
        return result;
    }
}