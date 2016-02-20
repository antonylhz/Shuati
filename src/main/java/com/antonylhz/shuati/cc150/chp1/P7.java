package com.antonylhz.shuati.cc150.chp1;

/* Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
	column is set to 0
*/

public class P7 {
	public static void main(String[] args) {
		int[][] mat = new int[][] {
				{1,2,3,4,5},
				{5,0,7,8,9},
				{6,9,0,1,0},
				{1,2,3,4,5}
		};
		nullify(mat, 4, 5);
		for(int i=0; i<4; i++) {
			for(int j=0; j<5; j++) System.out.print(mat[i][j]+" ");
			System.out.println();
		}
	}
	
	private static void nullify(int[][] mat, int m, int n) {
		boolean[] rowzeros = new boolean[m], colzeros = new boolean[n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(mat[i][j] == 0) {
					rowzeros[i] = true;
					colzeros[j] = true;
				}
			}
		}
		for(int i=0; i<m; i++) {
			if(rowzeros[i]) {
				for(int j=0; j<n; j++) mat[i][j] = 0;
			}
		}
		for(int j=0; j<n; j++) {
			if(colzeros[j]) {
				for(int i=0; i<m; i++) mat[i][j] = 0;
			}
		}
	}
}
