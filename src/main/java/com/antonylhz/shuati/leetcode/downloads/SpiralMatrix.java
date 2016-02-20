public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix==null||matrix.length==0||matrix[0].length==0) return result;
        int rlen = matrix.length, clen = matrix[0].length;
        for(int r=0; r<(rlen+1)/2&&r<(clen+1)/2; r++) {
            for(int i=r; i<clen-r; i++) result.add(matrix[r][i]);
            for(int i=r+1; i<rlen-r-1; i++) result.add(matrix[i][clen-r-1]);
            if(rlen-r-1>r) {
                for(int i=clen-r-1; i>=r; i--) result.add(matrix[rlen-r-1][i]);
                if(clen-r-1>r) for(int i=rlen-r-2; i>r;i--) result.add(matrix[i][r]);
            }
        }
        return result;
    }
}