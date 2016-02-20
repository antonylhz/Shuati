public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null || t.length() == 0) return 0;
        int[] cnt = new int[t.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = t.length() - 1; j >= 0; j--) {
                if (c == t.charAt(j)) {
                    if (j == 0) cnt[j]++;
                    else cnt[j] += cnt[j - 1];
                }
            }
        }
        return cnt[t.length() - 1];
    }
}