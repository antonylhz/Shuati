package com.antonylhz.shuati.leetcode.revised;
public class RotateMatrix {
    int len;

	public static void main(String[] args) {
		/*
		int[][] matrix = new int[][] {
			{2,29,20,26,16,28},
			{12,27,9,25,13,21},
			{32,33,32,2,28,14},
			{13,14,32,27,22,26},
			{33,1,20,7,21,7},
			{4,24,1,6,32,34}
		};
		*/

        int[][] matrix = new int[][]{
                {1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}};
		(new RotateMatrix()).rotate(matrix);
	}

    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length<2||matrix.length!=matrix[0].length) return;
        len = matrix.length;
        rotateSquare(matrix, 0);
    }
    private void rotateSquare(int[][] matrix, int n) {
        if(n>=len/2) return;
        rotateBorder(matrix, n);
        rotateSquare(matrix, ++n);
    }
    private void rotateBorder(int[][] matrix, int n) {
        int temp_from, temp_to;
        for(int i=0; i<len-1-2*n; i++) {
            temp_from = matrix[n+i][len-n-1];
            temp_to = matrix[len-n-1][len-n-i-1];
            matrix[n+i][len-n-1] = matrix[n][n+i];
            matrix[len-n-1][len-n-i-1] = temp_from;
            temp_from = temp_to;
            temp_to = matrix[len-n-i-1][n];
            matrix[len-n-i-1][n] = temp_from;
            matrix[n][n+i] = temp_to;
        }
    }
}
