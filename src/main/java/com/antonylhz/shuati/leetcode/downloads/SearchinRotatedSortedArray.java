public class Solution {
    public int search(int[] A, int target) {
        return searchInSubArray(A, 0, A.length - 1, target);
    }

    private int searchInSubArray(int[] A, int start, int end, int target) {
        if (A == null || start > end) return -1;
        if (start == end) return A[start] == target ? start : -1;
        if (end - start == 1) {
            if (A[start] == target) return start;
            else if (A[end] == target) return end;
            else return -1;
        }
        int mid = (start + end) / 2;
        if (A[mid] == target) return mid;
        if (A[start] < A[end]) {
            if (A[mid] > A[start] && A[mid] < A[end])
                return target > A[mid] ? searchInSubArray(A, mid + 1, end, target) : searchInSubArray(A, start, mid - 1, target);
            else if (A[mid] < A[start])
                return target <= A[start] && target > A[mid] ? searchInSubArray(A, start, mid - 1, target) : searchInSubArray(A, mid + 1, end, target);
            else
                return target >= A[end] && target < A[mid] ? searchInSubArray(A, mid + 1, end, target) : searchInSubArray(A, 0, mid - 1, target);
        } else {
            if (A[mid] < A[start] && A[mid] > A[end])
                return target < A[mid] ? searchInSubArray(A, mid + 1, end, target) : searchInSubArray(A, start, mid - 1, target);
            else if (A[mid] > A[start])
                return target >= A[start] && target < A[mid] ? searchInSubArray(A, start, mid - 1, target) : searchInSubArray(A, mid + 1, end, target);
            else
                return target <= A[end] && target > A[mid] ? searchInSubArray(A, mid + 1, end, target) : searchInSubArray(A, start, mid - 1, target);
        }
    }
}