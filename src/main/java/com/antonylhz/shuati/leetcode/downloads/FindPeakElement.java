public class Solution {
    public int findPeakElement(int[] num) {
        if (num == null) return -1;
        return findPeakInRange(num, 0, num.length - 1);
    }

    private int findPeakInRange(int[] num, int min, int max) {
        if (min > max) return -1;
        else if (min == max) return min;
        else if (min == max - 1) return num[min] > num[max] ? min : max;
        int mid = (min + max) / 2;
        if (num[mid] > num[mid + 1]) {
            if (num[mid - 1] < num[mid]) return mid;
            else return findPeakInRange(num, min, mid - 1);
        } else return findPeakInRange(num, mid + 1, max);
    }
}