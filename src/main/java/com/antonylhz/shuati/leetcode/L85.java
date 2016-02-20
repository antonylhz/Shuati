package com.antonylhz.shuati.leetcode;

import java.util.Arrays;

public class L85 {
	public static void main(String[] args) {
		char[][] table = new char[][] {
				{'0', '0', '0', '1'},
				{'1', '0', '1', '0'},
				{'1', '1', '1', '0'},
		};
		System.out.println((new L85()).maximalRectangle(table));
	}
	
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return 0;
         final int m = matrix.length;
         final int n = matrix[0].length;
         int[] left = new int[n], right = new int[n], height = new int[n];
         Arrays.fill(right, n);
         int maxA = 0;
         for(int i=0; i<m; i++) {
             int cur_left=0, cur_right=n; 
             for(int j=0; j<n; j++) { // compute left (from left to right)
            	 if(matrix[i][j]=='1') height[j]++;  // compute height (can do this from either side)
                 else height[j]=0;
            	 
                 if(matrix[i][j]=='1') left[j]=Math.max(left[j],cur_left);
                 else {left[j]=0; cur_left=j+1;}
             }
             for(int j=n-1; j>=0; j--) {
                 if(matrix[i][j]=='1') right[j]=Math.min(right[j],cur_right);  // compute right (from right to left)
                 else {right[j]=n; cur_right=j;}
                 
                 maxA = Math.max(maxA,(right[j]-left[j])*height[j]);  // compute the area of rectangle (can do this from either side)
             }
         }
         return maxA;
     }
}
