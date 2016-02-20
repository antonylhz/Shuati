public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length < 2) return;
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i] > num[i - 1]) {
                for (int j = num.length - 1; j > i - 1; j--) {
                    if (num[j] > num[i - 1]) {
                        swap(num, i - 1, j);
                        reverse(num, i, num.length - 1);
                        return;
                    }
                }
            }
        }
        reverse(num, 0, num.length - 1);
    }

    private void swap(int[] num, int i1, int i2) {
        int temp = num[i1];
        num[i1] = num[i2];
        num[i2] = temp;
    }

    private void reverse(int[] num, int start, int end) {
        while (start < end) swap(num, start++, end--);
    }
}
