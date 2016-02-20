public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) return 0;
        int len = (A[0] == elem ? 0 : 1);
        for (int i = len, j = 1; j < A.length; j++) {
            if (A[j] != elem) {
                A[i++] = A[j];
                len++;
            }
        }
        return len;
    }
}