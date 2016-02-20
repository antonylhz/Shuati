public class Solution {
    int[] result = new int[]{-1, -1};

    public int[] searchRange(int[] A, int target) {
        searchRangeInRange(A, 0, A.length, target);
        return result;
    }

    private void searchRangeInRange(int[] A, int start, int end, int target) {
        if (end - start == 1 && A[start] == target) {
            result[0] = result[1] = start;
        } else if (end - start > 1) {
            int mid = (start + end) / 2;
            if (A[mid] > target) searchRangeInRange(A, start, mid, target);
            else if (A[mid] < target) searchRangeInRange(A, mid + 1, end, target);
            else {
                result[0] = result[1] = mid;
                for (int i = mid - 1; i >= start && A[i] == target; i--) result[0] = i;
                for (int i = mid + 1; i < end && A[i] == target; i++) result[1] = i;
            }
        }
    }
}
