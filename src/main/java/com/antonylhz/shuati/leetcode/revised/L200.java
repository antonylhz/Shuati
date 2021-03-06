package com.antonylhz.shuati.leetcode.revised;

//Number of Islands 
//
//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

public class L200 {
	public int numIslands(char[][] grid) {
	    int count=0;
	    for(int i=0;i<grid.length;i++)
	        for(int j=0;j<grid[0].length;j++){
	            if(grid[i][j]=='1'){
	                dfsFill(grid,i,j);
	                count++;
	            }
	        }
	    return count;
	}
	private void dfsFill(char[][] grid,int i, int j){
	    if(i>=0 && j>=0 && i<grid.length && j<grid[0].length&&grid[i][j]=='1'){
	        grid[i][j]='0';
	        dfsFill(grid, i + 1, j);
	        dfsFill(grid, i - 1, j);
	        dfsFill(grid, i, j + 1);
	        dfsFill(grid, i, j - 1);
	    }
	}
}
