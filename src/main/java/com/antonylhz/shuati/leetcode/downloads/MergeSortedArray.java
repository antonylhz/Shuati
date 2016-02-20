public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, cur = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && A[i] > B[j]) A[cur--] = A[i--];
            else A[cur--] = B[j--];
        }
    }
}