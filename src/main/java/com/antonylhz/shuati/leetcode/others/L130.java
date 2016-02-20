package com.antonylhz.shuati.leetcode.others;

//Surrounded Regions 
//
//Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
//
//A region is captured by flipping all 'O's into 'X's in that surrounded region.

import java.util.LinkedList;
import java.util.Queue;

public class L130 {
	public static void main(String[] args) {
		L130 solution = new L130();
		char[][] board = new char[][] {
				{'X', 'O', 'X'},
				{'X', 'O', 'X'},
				{'X', 'O', 'X'}
		};
		solution.solve(board);
	}
	
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0) return;
        int height = board.length, width = board[0].length;
        boolean[][] visited = new boolean[height][width], flip = new boolean[height][width];
        Queue<int[]> freefolks = new LinkedList<int[]>();
        for(int i=0; i<height; i++)
            for(int j=0; j<width; j++) {
                if(board[i][j]=='X') continue;
                visited[i][j] = false;
                flip[i][j] = true;
                if(i==0||i==height-1||j==0||j==width-1) {
                    freefolks.add(new int[]{i, j});
                }
            }
        while(freefolks.size()>0) {
            int[] node = freefolks.poll();
            if(visited[node[0]][node[1]]) continue;
            flip[node[0]][node[1]] = false;
            
            if(node[0]>1&&board[node[0]-1][node[1]]=='O') freefolks.add(new int[]{node[0]-1, node[1]});
            if(node[0]<height-2&&board[node[0]+1][node[1]]=='O') freefolks.add(new int[]{node[0]+1, node[1]});
            if(node[1]>1&&board[node[0]][node[1]-1]=='O') freefolks.add(new int[]{node[0], node[1]-1});
            if(node[1]<width-2&&board[node[0]][node[1]+1]=='O') freefolks.add(new int[]{node[0], node[1]+1});
            
            visited[node[0]][node[1]] = true;
        }
        for(int i=0; i<height; i++)
            for(int j=0; j<width; j++) {
                if(board[i][j]=='O'&&flip[i][j]) board[i][j] = 'X';
            }
    }
}
