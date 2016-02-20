package com.antonylhz.shuati.cc150.chp1;

/* Given an image represented by an NxN matrix, 
 * where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. 
 * Can you do this in place?
*/

public class P6 {
	public static void main(String[] args) {
		int[][] image = new int[][]{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8 ,9}
		};
		for(int[] line : image) {
			for(int num : line) System.out.print(num + " ");
			System.out.println();
		}
		rotate(image);
		for(int[] line : image) {
			for(int num : line) System.out.print(num + " ");
			System.out.println();
		}
	}
	
	private static void rotate(int[][] mat) {
		int n = mat.length;
		for(int i=0; i<n/2; i++) {
			for(int j=0; j<n-2*i-1; j++) {
				int t = mat[i][i+j];
				mat[i][i+j] = mat[n-1-i-j][i]; // left -> top
				mat[n-1-i-j][i] = mat[n-1-i][n-1-i-j]; //bottom -> left
				mat[n-1-i][n-1-i-j] = mat[i+j][n-1-i]; // right-> bottom
				mat[i+j][n-1-i] =t; // top -> right
			}
		}
	}
}
