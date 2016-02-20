public class Solution {
    public int compareVersion(String version1, String version2) {
        char[] chars1 = version1.toCharArray(), chars2 = version2.toCharArray();
        if (chars1.length < 1) return -1;
        else if (chars2.length < 1) return 1;
        int i = 0, j = 0;
        int t1, t2;
        while (i < chars1.length || j < chars2.length) {
            t1 = 0;
            t2 = 0;
            while (i < chars1.length && chars1[i] != '.') {
                t1 += chars1[i] - '0';
                t1 *= 10;
                i++;
            }
            while (j < chars2.length && chars2[j] != '.') {
                t2 += chars2[j] - '0';
                t2 *= 10;
                j++;
            }
            if (t1 > t2) return 1;
            else if (t1 < t2) return -1;
            i++;
            j++;
        }
        return 0;
    }
}