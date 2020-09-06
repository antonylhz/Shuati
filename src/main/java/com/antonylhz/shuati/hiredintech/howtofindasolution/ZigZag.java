package com.antonylhz.shuati.hiredintech.howtofindasolution;

/**
 * @author hongzhal
 */

public class ZigZag {

    /**
     * State[last index, up(0) or down(1)] = {length, last number}
     * @param array of numbers
     * @return longest zigzag sub sequence
     */
    public static int findLongest(int[] array) {
        if (array.length <= 2) {
            return array.length;
        }
        int[][] length = new int[array.length][2];
        length[0][0] = 1;
        length[0][1] = 1;
        for (int i = 1; i < array.length; i++) {
            int lastSmaller = findLast(array, i, true);
            if (lastSmaller < 0) {
                length[i][0] = 1;
            } else {
                length[i][0] = length[lastSmaller][1] + 1;
            }
            int lastGreater = findLast(array, i, false);
            if (lastGreater < 0) {
                length[i][1] = 1;
            } else {
                length[i][1] = length[lastGreater][0] + 1;
            }
        }
        return Math.max(length[array.length - 1][0], length[array.length - 1][1]);
    }

    private static int findLast(int[] array, int cur, boolean smaller) {
        for (int i = cur - 1; i >= 0; i--) {
            if (smaller && array[i] < array[cur]) {
                return i;
            } else if (!smaller && array[i] > array[cur]) {
                return i;
            }
        }
        return -1;
    }

}
