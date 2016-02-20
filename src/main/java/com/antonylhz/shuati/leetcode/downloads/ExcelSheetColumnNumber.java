public class Solution {
    public int titleToNumber(String s) {
        if(s.length()<1) return 0;
        char[] chars = s.toCharArray();
        int res = 0;
        char c;
        for(int i=0; i< chars.length; i++) {
            c = chars[i];
            if(c>='A' && c<='Z') {
                res += c-'A'+1;
            } else return res;
            if(i<chars.length-1) res*=26;
        }
        return res;
    }
}