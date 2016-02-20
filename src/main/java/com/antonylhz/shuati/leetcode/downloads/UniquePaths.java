public class Solution {
    public int uniquePaths(int m, int n) {
        if(m<n) {
            int temp = m;
            m = n;
            n = temp;
        }
        double result = 1;
        int i=m+n-2, j=n-1;
        for(; i>=m||j>=2; i--, j--) {
            result *= i;
            if(j>=2) result /= j;
        }
        return (int)(result+0.5);
    }
}