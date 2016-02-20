public class Solution {
    public int nthUglyNumber(int n) {
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int[] arr = new int[n];
        arr[0] = 1;
        Set<Integer> set = new HashSet<Integer>(n);
        for (int i = 1; i < n; i++) {
            int num2 = arr[idx2] * 2, num3 = arr[idx3] * 3, num5 = arr[idx5] * 5;
            if (num2 <= num3 && num2 <= num5) {
                arr[i] = num2;
                set.add(num2);
                idx2++;
            } else if (num3 <= num2 && num3 <= num5) {
                arr[i] = num3;
                set.add(num3);
                idx3++;
            } else {
                arr[i] = num5;
                set.add(num5);
                idx5++;
            }
            //find next applicable idxes
            while (set.contains(arr[idx2] * 2)) idx2++;
            while (set.contains(arr[idx3] * 3)) idx3++;
            while (set.contains(arr[idx5] * 5)) idx5++;
        }
        return arr[n - 1];
    }
}