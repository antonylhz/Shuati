package com.antonylhz.shuati.leetcode.revised;

import java.util.ArrayList;
import java.util.List;

public class Islands {
	private int width, height;
    private boolean[][] visited;
    private char[][] grid;
    
    public static void main(String[] args) {
    	Islands solution = new Islands();
    	char[][] grid = new char[][] {
    			new char[]{'1', '1'}
    	};
    	System.out.println(solution.numIslands(grid));
    }
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        height = grid.length;
        width = grid[0].length;
        visited = new boolean[height][width];
        int result = 0;
        for(int i=0; i<height; i++)
        for(int j=0; j<width; j++) {
            if(grid[i][j]=='1'&&!visited[i][j]) result += BFS(i, j);
        }
        return result;
    }
    private int BFS(int x, int y) {
        List<Integer> ilist = new ArrayList<Integer>(), jlist = new ArrayList<Integer>();
        boolean[][] processed = new boolean[height][width];
        ilist.add(x); jlist.add(y);
        while(!ilist.isEmpty()) {
            int i = ilist.remove(0), j = jlist.remove(0);
            processed[i][j] = true;
            if(i>0) {
                if(visited[i-1][j]) return 0;
                else if(!processed[i-1][j]&&grid[i-1][j]=='1') {
                    ilist.add(i-1);
                    jlist.add(j);
                }
            }
            if(i<height-1) {
                if(visited[i+1][j]) return 0;
                else if(!processed[i+1][j]&&grid[i+1][j]=='1') {
                    ilist.add(i+1);
                    jlist.add(j);
                }
            }
            if(j>0) {
                if(visited[i][j-1]) return 0;
                else if(!processed[i][j-1]&&grid[i][j-1]=='1') {
                    ilist.add(i);
                    jlist.add(j-1);
                }
            }
            if(j<width-1) {
                if(visited[i][j+1]) return 0;
                else if(!processed[i][j+1]&&grid[i][j+1]=='1') {
                    ilist.add(i);
                    jlist.add(j+1);
                }
            }
        }
        for(int i=0; i<height; i++) for(int j=0; j<width; j++) if(processed[i][j]) visited[i][j]=true;
        return 1;
    }
}
