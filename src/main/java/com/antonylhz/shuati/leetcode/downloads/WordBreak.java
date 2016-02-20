public class Solution {
    public boolean wordBreak(String s, Set dict) {
        boolean[] d = new boolean[s.length() + 1];
        d[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                d[i] |= d[j] && dict.contains(s.substring(j, i));
                if (d[i]) break;
            }
        }
        return d[s.length()];
    }
}