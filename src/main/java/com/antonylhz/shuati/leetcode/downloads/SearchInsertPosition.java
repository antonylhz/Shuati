public class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) return 0;
        int i = 0;
        while (i < A.length && A[i] < target) i++;
        return i;
    }
}