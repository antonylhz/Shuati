public class Solution {
    char[] chars;

    public boolean isNumber(String s) {
        chars = s.trim().toCharArray();
        if (chars == null || chars.length < 1) return false;
        int start = 0;
        if (chars[0] == '-' || chars[0] == '+') {
            if (chars.length == 1) return false;
            start = 1;
        }
        boolean e = false, dot = false;
        int e1 = 0, dot1 = 0, esign = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] == 'e') {
                if (e) return false;
                e1 = i;
                e = true;
                if (i + 1 < chars.length && (chars[i + 1] == '+' || chars[i + 1] == '-')) {
                    i++;
                    esign = 1;
                }
            } else if (chars[i] == '.') {
                if (dot) return false;
                dot1 = i;
                dot = true;
            } else if (chars[i] > '9' || chars[i] < '0') return false;
        }
        if (e) {
            if (dot)
                return dot1 < e1 && isFloat(start, e1 - start, dot1) && (e1 + esign != chars.length - 1 && isInteger(e1 + esign + 1, chars.length - e1 - esign - 1));
            else
                return (e1 != start && isInteger(start, e1 - start)) && (e1 + esign != chars.length - 1 && isInteger(e1 + esign + 1, chars.length - e1 - esign - 1));
        } else if (dot) return isFloat(start, chars.length - start, dot1);
        else return isInteger(start, chars.length);
    }

    private boolean isFloat(int start, int length, int dot) {
        if (length < 2) return false;
        return !(dot != start && !isInteger(start, dot - start));
    }

    private boolean isInteger(int start, int length) {
        return true;// length==1||chars[start]!='0';
    }
}
