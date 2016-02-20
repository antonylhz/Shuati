public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0) return 0;

        int height = obstacleGrid.length, width = obstacleGrid[0].length;
        int[][] path = new int[height][width];

        for(int i=0; i<height; i++) for(int j=0; j<width; j++) {
            if(obstacleGrid[i][j]==1) path[i][j] = 0;
            else if(i==0&&j==0) path[i][j] = 1;
            else if(i==0) path[i][j] = path[i][j-1];
            else if(j==0) path[i][j] = path[i-1][j];
            else path[i][j] = path[i-1][j] + path[i][j-1];
        }

        return path[height-1][width-1];
    }
}