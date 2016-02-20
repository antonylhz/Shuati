public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) return Integer.MIN_VALUE;
        return findMinR(num, 0, num.length);
    }

    private int findMinR(int[] num, int start, int len) {
        //len needs to be positive
        if (len == 1) return num[start];
        else if (len == 2) return Math.min(num[start], num[start + 1]);

        //From now we can supposed len is bigger than 3; so that start, end, mid are all different
        int end = start + len - 1;
        int mid = (start + end) / 2;

        if (num[start] < num[mid] && num[mid] < num[end]) return num[start];
        else if (num[start] > num[mid] && num[mid] > num[end]) return num[end];
        else if ((num[start] > num[end] && num[start] > num[mid]) || (num[start] < num[end] && num[start] < num[mid]))
            return findMinR(num, start, mid - start + 1);
        else return findMinR(num, mid, end - mid + 1);
    }
}