public class Solution {
    final int CMASK = 0xF0, VMASK = 1, CINC = 0x10;
    public void gameOfLife(int[][] board) {
        if(board==null||board.length<1||board[0].length<1) {
            return;
        }
        int H = board.length, W = board[0].length;
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                int cnt = 0;
                if(i>0&&isAlive(board[i-1][j])) {
                    cnt += CINC;
                }
                if(i<H-1&&isAlive(board[i+1][j])) {
                    cnt += CINC;
                }
                if(j>0&&isAlive(board[i][j-1])) {
                    cnt += CINC;
                }
                if(j<W-1&&isAlive(board[i][j+1])) {
                    cnt += CINC;
                }
                if(i>0&&j>0&&isAlive(board[i-1][j-1])) {
                    cnt += CINC;
                }
                if(i>0&&j<W-1&&isAlive(board[i-1][j+1])) {
                    cnt += CINC;
                }
                if(i<H-1&&j>0&&isAlive(board[i+1][j-1])) {
                    cnt += CINC;
                }
                if(i<H-1&&j<W-1&&isAlive(board[i+1][j+1])) {
                    cnt += CINC;
                }
                board[i][j] += cnt;
            }
        }
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                int cnt = getCount(board[i][j]);
                System.out.println("i"+i+"j"+j+"count"+cnt);
                if(isAlive(board[i][j])) {
                    if(cnt<2||cnt>3) {
                        board[i][j] = 0;
                    } else {
                        board[i][j] = 1;
                    }
                } else {
                    if(cnt==3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
    private boolean isAlive(int number) {
        return (number & VMASK) == 1;
    }
    private int getCount(int number) {
        return (number & CMASK)>>4;
    }
}
