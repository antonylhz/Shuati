package com.antonylhz.shuati.leetcode.others;

public class SudokuSolver {
	private static final int N = 3;
    private static int[] 
        rmask = new int[N*N],
        cmask = new int[N*N],
        bmask = new int[N*N];

    private static void print(char[][] board) {
        for (char[] line : board) {
            System.out.println(new String(line));
        }
    }

    public static void main(String[] args) {

        char[][] board = new char[][]{
                "53..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray()
        };
        (new SudokuSolver()).solveSudoku(board);
        print(board);
    }
    
    public void solveSudoku(char[][] board) {
    	for(int i=0; i<N*N; i++) {
    		for(int j=0; j<N*N; j++) {
    			int bId = N * (i / N) + j / N;
    			if(board[i][j] != '.') {
    				addEntry(i, j, bId, board[i][j]-'1');
    			}
    		}
    	}
        solvable(board, 0);
    }
    
    private void addEntry(int rId, int cId, int bId, int num) {
        rmask[rId] += 1 << num;
        cmask[cId] += 1 << num;
        bmask[bId] += 1 << num;
    }
    
    private void rmvEntry(int rId, int cId, int bId, int num) {
        rmask[rId] -= 1 << num;
        cmask[cId] -= 1 << num;
        bmask[bId] -= 1 << num;
    }

    private boolean solvable(char[][] board, int seqId) {
        if(seqId >= Math.pow(N, 4)) {
            return true;
        }
        int rId = seqId / (N*N),
            cId = seqId - rId * N * N,
            bId = N * (rId / N) + cId / N;

        if(board[rId][cId] == '.') {
            boolean res = false;
            int mask = 0x1FF - (rmask[rId] | cmask[cId] | bmask[bId]);
            int num = 0;
            while(mask > 0) {
                if((mask & 1) > 0) { // current num is valid
                    board[rId][cId] = (char) ('1' + num);
                    addEntry(rId, cId, bId, num);
                    if(solvable(board, seqId+1)) {
                        res = true;
                        break;
                    } else {
                        board[rId][cId] = '.';
                        rmvEntry(rId, cId, bId, num);
                    }
                }
                mask >>= 1;
                num++;
            }
            return res;
        } else return solvable(board, ++seqId);
    }
    
}
