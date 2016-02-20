package com.antonylhz.shuati.leetcode.others;

public class SortColors {
	public static void main(String[] args) {
		SortColors solution = new SortColors();
		int[] A = new int[] {0,1};
		solution.sortColors(A);
	}
    public void sortColors(int[] A) {
        int[] start = new int[3];
        start[0] = 0;
        for(int color : A) {
            if(color < 2) {
                for(int j = color+1; j<3; j++)
                    start[j]++;
            }
        }
        int[] i = new int[3];
        for(int color : A) {
            A[start[color]+(i[color]++)] = color;
        }
    }
}
