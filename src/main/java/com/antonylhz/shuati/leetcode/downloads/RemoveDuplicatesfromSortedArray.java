public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) return 0;
        int len = 1, last = A[0];
        for (int i = 1, j = 1; j < A.length; j++) {
            if (A[j] != last) {
                last = (A[i++] = A[j]);
                len++;
            }
        }
        return len;
    }
}