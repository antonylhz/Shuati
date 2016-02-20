public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dist = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<=word1.length(); i++) for(int j=0; j<=word2.length(); j++) {
            if(i==0||j==0) dist[i][j] = Math.max(i, j);
            else {
                int insert = dist[i][j-1] + 1;
                int delete = dist[i-1][j] + 1;
                int replace = dist[i-1][j-1] + (word1.charAt(i-1)==word2.charAt(j-1)?0:1);
                dist[i][j] = Math.min(Math.min(insert, delete), replace);
            }
        }
        return dist[word1.length()][word2.length()];
    }
}