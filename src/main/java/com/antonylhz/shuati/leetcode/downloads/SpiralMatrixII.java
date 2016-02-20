public class Solution {
    public int[][] generateMatrix(int n) {
        int val = 1;
        int[][] result = new int[n][n];
        for (int i = 0; i <= (n - 1) / 2; i++) {
            if (i * 2 + 1 == n) {
                result[i][i] = (val++);
                break;
            } else {
                int j, k;
                for (j = i; j <= n - i - 1; j++) result[i][j] = (val++);
                for (k = i + 1; k <= n - i - 2; k++) result[k][n - i - 1] = (val++);
                for (j = n - i - 1; j >= i; j--) result[n - i - 1][j] = (val++);
                for (k = n - i - 2; k >= i + 1; k--) result[k][i] = (val++);
            }
        }
        return result;
    }
}