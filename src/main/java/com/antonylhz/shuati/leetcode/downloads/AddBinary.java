public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() == 0) return b;
        else if (b.length() == 0) return a;
        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();
        int carry = 0, sum = 0, i = achar.length - 1, j = bchar.length - 1, ai, bj;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            ai = 0;
            bj = 0;
            if (i >= 0) ai = (achar[i--] > '0' ? 1 : 0);
            if (j >= 0) bj = (bchar[j--] > '0' ? 1 : 0);
            sum = ai + bj + carry;
            if (sum < 2) carry = 0;
            else if (sum == 2) {
                sum = 0;
                carry = 1;
            } else sum = 1;
            builder.append(sum == 0 ? "0" : "1");
        }
        if (carry > 0) builder.append("1");
        return builder.reverse().toString();
    }
}