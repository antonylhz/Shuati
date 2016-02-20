public class Solution {
    public int lengthOfLastWord(String s) {
        int last = 0, cur = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                if (cur > 0) {
                    last = cur;
                    cur = 0;
                }
            } else cur++;
        }
        return cur == 0 ? last : cur;
    }
}