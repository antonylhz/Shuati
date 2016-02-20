package com.antonylhz.shuati.leetcode;

public class SearchMatrix {
	public static void main(String[] args) {
		SearchMatrix solution = new SearchMatrix();
		int[][] matrix = new int[][] {
			{-10,-10},{-9,-9},{-8,-6},{-4,-2},{0,1},{3,3},{5,5},{6,8}
		};
		System.out.println(solution.searchMatrix(matrix, 0));
	}
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int height = matrix.length, width = matrix[0].length;
        int rStart = 0, rEnd = height-1, rTarget = 0;
        while(rStart<=rEnd) {
            if(matrix[rStart][0]==target||matrix[rStart][width-1]==target||matrix[rEnd][0]==target||matrix[rEnd][width-1]==target) {
                return true;
            } else if(target<matrix[rStart][0]||target>matrix[rEnd][width-1]) {
                return false;
            } else if(target>matrix[rStart][0]&&target<matrix[rStart][width-1]) {
                rTarget = rStart;
                break;
            } else if(target>matrix[rEnd][0]&&target<matrix[rEnd][width-1]) {
                rTarget = rEnd;
                break;
            } 
            if(rEnd-rStart<2) return false;
            rTarget = (rStart+rEnd)/2;
            if(target==matrix[rTarget][0]||target==matrix[rTarget][width-1]) {
                return true;
            } else if(target>matrix[rTarget][0]&&target<matrix[rTarget][width-1]) {
                break;
            } else {
                if(target<matrix[rTarget][0]) {
                    rStart++;
                    rEnd = rTarget-1;
                } else {
                    rStart = rTarget+1;
                    rEnd--;
                }
            }
        }
        if(rStart>rEnd) return false;
        int cStart = 0, cEnd = width-1, cTarget;
        while(cStart <= cEnd) {
            if(target==matrix[rTarget][cStart]||target==matrix[rTarget][cEnd]) return true;
            cTarget = (cStart+cEnd)/2;
            if(target==matrix[rTarget][cTarget]) return true;
            else if(target<matrix[rTarget][cTarget]) {
                cStart++;
                cEnd = cTarget-1;
            } else {
                cEnd--;
                cStart = cTarget+1;
            }
        }
        return false;
    }
}
