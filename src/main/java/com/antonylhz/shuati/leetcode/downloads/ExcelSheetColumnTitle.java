public class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            int cur = n % 26;
            if (cur == 0) {
                res.append("Z");
                n = n / 26 - 1;
            } else {
                res.append((char) ('A' + cur - 1));
                n = (n - cur) / 26;
            }
        }
        return res.reverse().toString();
    }
}