public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        else if (s.length() == 1) return 1;
        int[] cnts = new int[s.length()];
        cnts[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            cnts[i] += isValid(s.charAt(i)) ? cnts[i - 1] : 0;
            cnts[i] += isValid(s.charAt(i - 1), s.charAt(i)) ?
                    (i > 1 ? cnts[i - 2] : 1) : 0;
            if (cnts[i] == 0) break;
        }
        return cnts[cnts.length - 1];
    }

    private boolean isValid(char c1, char c2) {
        if (c1 < '1' || c1 > '2') return false;
        else if (c1 == '1') return true;
        else return c2 < '7';   //c1=='2' now
    }

    private boolean isValid(char c) {
        return c != '0';
    }
}