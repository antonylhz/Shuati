public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int height = matrix.length, width = matrix[0].length;
        int[][] vcount = new int[height][width], area = new int[height][width];
        for(int j=0; j<width; j++) {
            int count = 0;
            for(int i=0; i<height; i++) {
                if(matrix[i][j]=='1') count++;
                else count = 0;
                vcount[i][j] = count;
            }
        }
        int result = 0;
        for(int i=0; i<height; i++) {
        	int count = 0;
            for(int j=0; j<width; j++) {
            	if(matrix[i][j]=='0') {
            		count = 0;
            		continue;
            	}
            	else count++;
            	if(i==0||j==0) area[i][j] = 1;
            	else if(area[i-1][j]==0) area[i][j] = 1;
            	else if(area[i-1][j]>=count) area[i][j] = count;
            	else if(vcount[i][j-area[i-1][j]]>=area[i-1][j]+1) area[i][j] = area[i-1][j]+1;
            	else area[i][j] = area[i-1][j];
                if(area[i][j]>result) result = area[i][j];
            }
        }
        return result*result;
    }
}
