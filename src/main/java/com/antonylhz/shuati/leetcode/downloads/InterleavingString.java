public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.length() == 0) return s2.equals(s3);
        else if (s2 == null || s2.length() == 0) return s1.equals(s3);
        else if (s3 == null || s3.length() == 0 || s3.length() != s1.length() + s2.length()) return false;
        boolean[][] table = new boolean[s1.length() + 1][s2.length() + 1];
        table[0][0] = true;
        for (int i = 0; i <= s1.length(); i++)
            for (int j = 0; j <= s2.length(); j++) {
                if (i > 0 || j > 0) {
                    boolean use1 = false, use2 = false;
                    if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) use1 = table[i - 1][j];
                    if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) use2 = table[i][j - 1];
                    table[i][j] = use1 || use2;
                }
            }
        return table[s1.length()][s2.length()];
    }
}