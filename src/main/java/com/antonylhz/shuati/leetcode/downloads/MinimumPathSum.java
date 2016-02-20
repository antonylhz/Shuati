public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int height = grid.length, width = grid[0].length;
        int[][] sum = new int[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                if (i == 0 && j == 0) sum[i][j] = grid[0][0];
                else if (i == 0) sum[i][j] = grid[i][j] + sum[i][j - 1];
                else if (j == 0) sum[i][j] = grid[i][j] + sum[i - 1][j];
                else sum[i][j] = grid[i][j] + Math.min(sum[i][j - 1], sum[i - 1][j]);
            }
        return sum[height - 1][width - 1];
    }
}