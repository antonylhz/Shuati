public class Solution {
    public int reverse(int x) {
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
            x = -x;
        }
        int result = 0, temp, i = 1;
        while (x > 0) {
            temp = x % 10; // the least significant digit
            if (i == 10) {
                int last = Integer.MAX_VALUE % 10;
                int leftover = (Integer.MAX_VALUE - last) / 10;
                if (result > leftover || result == leftover && temp > last) return 0;
            }
            result *= 10;
            result += temp;
            x /= 10;
            i++;
        }
        return isNeg ? -result : result;
    }
}