public class Solution {
    int len;

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 2 || matrix.length != matrix[0].length) return;
        len = matrix.length;
        rotateSquare(matrix, 0);
    }

    private void rotateSquare(int[][] matrix, int n) {
        if (n >= len / 2) return;
        rotateBorder(matrix, n);
        rotateSquare(matrix, ++n);
    }

    private void rotateBorder(int[][] matrix, int n) {
        int temp_from, temp_to;
        for (int i = 0; i < len - 1 - 2 * n; i++) {
            temp_from = matrix[n + i][len - n - 1];
            temp_to = matrix[len - n - 1][len - n - i - 1];
            matrix[n + i][len - n - 1] = matrix[n][n + i];
            matrix[len - n - 1][len - n - i - 1] = temp_from;
            temp_from = temp_to;
            temp_to = matrix[len - n - i - 1][n];
            matrix[len - n - i - 1][n] = temp_from;
            matrix[n][n + i] = temp_to;
        }
    }
}
