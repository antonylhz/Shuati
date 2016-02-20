package com.antonylhz.shuati.leetcode;

//Maximal Square
//Given a 2D binary matrix filled with 0's and 1's, 
//find the largest square containing all 1's and return its area.

public class L221 {
	public static void main(String[] args) {
		char[][] matrix = new char[9][10];
		String[] strings = new String[]{"0110010101","0010101010","1000010110","0111111010","0011111110","1101011110","0001100010","1101100111","0101101011"};
		for(int i=0; i<strings.length; i++) {
			matrix[i] = strings[i].toCharArray();
		}
		System.out.println((new L221()).maximalSquare(matrix));
	}
	
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int height = matrix.length, width = matrix[0].length;
        int[][] vcount = new int[height][width], area = new int[height][width];
        for(int j=0; j<width; j++) {
            int count = 0;
            for(int i=0; i<height; i++) {
                if(matrix[i][j]=='1') count++;
                else count = 0;
                vcount[i][j] = count;
            }
        }
        int result = 0;
        for(int i=0; i<height; i++) {
        	int count = 0;
            for(int j=0; j<width; j++) {
            	if(matrix[i][j]=='0') count = 0;
            	else {
	            	count++;
	            	if(i==0||j==0) area[i][j] = 1;
	            	else if(area[i-1][j]==0) area[i][j] = 1;
	            	else if(area[i-1][j]>=count) area[i][j] = count;
	            	else if(vcount[i][j-area[i-1][j]]>=area[i-1][j]+1) area[i][j] = area[i-1][j]+1;
	            	else area[i][j] = area[i-1][j];
	                if(area[i][j]>result) result = area[i][j];
            	}
            }
        }
        for(int i=0; i<height; i++) {
        	for(int j=0; j<width; j++) {
        		System.out.print(String.valueOf(area[i][j]));
        	}
        	System.out.println();
        }
        return result*result;
    }
}
