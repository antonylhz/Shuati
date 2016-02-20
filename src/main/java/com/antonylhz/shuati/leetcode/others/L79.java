package com.antonylhz.shuati.leetcode.others;

//Word Search
//
//Given a 2D board and a word, find if the word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

public class L79 {
    int height = 0, width = 0;

    public static void main(String[] args) {
        char[][] board = new char[][]{
				{'C', 'A', 'A'},
				{'A', 'A', 'A'},
				{'B', 'C', 'D'}
		};
		System.out.println((new L79()).exist(board, "AAB"));
	}
    
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0) return false;
        height = board.length;
        width = board[0].length;
        boolean[][] visited = new boolean[height][width];
        for(int i=0; i<height; i++)
            for(int j=0; j<width; j++) {
                if(dfs(board, i, j, word, 0, visited)) return true;
            }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int start, boolean[][] visited) {
        if(i<0||i>=height||j<0||j>=width) return false;
        if(visited[i][j]) return false;
        if(board[i][j]!=word.charAt(start)) return false;
        if(start>=word.length()-1) return true;
        visited[i][j] = true;
        boolean exist = dfs(board, i-1, j, word, start+1, visited) ||
               dfs(board, i+1, j, word, start+1, visited) ||
               dfs(board, i, j-1, word, start+1, visited) ||
               dfs(board, i, j+1, word, start+1, visited);
        visited[i][j] = false;
        return exist;
    }
}
