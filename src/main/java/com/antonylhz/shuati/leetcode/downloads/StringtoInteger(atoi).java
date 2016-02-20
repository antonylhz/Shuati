public class Solution {
    public int myAtoi(String str) {
        String s = str.trim();
        if(s.length()==0) return 0;
        boolean neg = false;
        int idx = 0;
        if(s.charAt(0)=='-') {
            neg = true;
            idx++;
        } else if(s.charAt(0)=='+') {
            idx++;
        }
        int res = 0;
        for(; idx<s.length(); idx++) {
            char c = s.charAt(idx);
            if(c>'9' || c<'0') break;
            int cur = c - '0';
            if(res > (Integer.MAX_VALUE - cur) / 10) {
                if(neg && res>=Integer.MAX_VALUE/10) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            res = res * 10 + cur;
        }
        return neg ? -res : res;
    }
}