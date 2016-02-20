public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int len = s1.length();
        boolean[][][] scramble = new boolean[len][len][len + 1];
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++) {
                scramble[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        for (int l = 2; l <= len; l++) {
            for (int i = len - l; i >= 0; i--)
                for (int j = len - l; j >= 0; j--) {
                    for (int s = 1; s < l; s++) {
                        scramble[i][j][l] = scramble[i][j][l] || (scramble[i][j][s] && scramble[i + s][j + s][l - s]);
                        scramble[i][j][l] = scramble[i][j][l] || (scramble[i][j + l - s][s] && scramble[i + s][j][l - s]);
                        if (scramble[i][j][l]) break;
                    }
                }
        }
        return scramble[0][0][len];
    }
}