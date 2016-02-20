package com.antonylhz.shuati.leetcode.others;

public class RemoveDuplicates {
	public static void main(String[] args) {
		RemoveDuplicates solution = new RemoveDuplicates();
		int[] A = new int[] {1,1,1};
		System.out.println(solution.removeDuplicates(A));
	}
    public int removeDuplicates(int[] A) {
        if(A.length<3) return A.length;
        int i = 0, j = 1; //i is the index of the tail of condensed array, and j is the index of the current observing element
        int count = 1;
        while(j<A.length) {
            if(A[j]==A[i]) {
                if(count<2) {
                    A[++i] = A[j++];
                    count++;
                }
                else j++;
            } else {
                A[++i] = A[j++];
                count = 1;
            }
        }
        return i+1;
    }
}
