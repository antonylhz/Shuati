public class Solution {
    public void solve(char[][] board) {
        if (board.length < 3 || board[0].length < 3) {
            return;
        }
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        LinkedList<Integer> hlist = new LinkedList<>(), wlist = new LinkedList<>();
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++) {
                if ((i == 0 || i == h - 1 || j == 0 || j == w - 1) && !visited[i][j] && board[i][j] == 'O') {
                    hlist.add(i);
                    wlist.add(j);
                    visited[i][j] = true;
                    while (!hlist.isEmpty()) {
                        int a = hlist.removeFirst(), b = wlist.removeFirst();
                        if (b > 0 && !visited[a][b - 1] && board[a][b - 1] == 'O') {
                            hlist.add(a);
                            wlist.add(b - 1);
                            visited[a][b - 1] = true;
                        }
                        if (b < w - 1 && !visited[a][b + 1] && board[a][b + 1] == 'O') {
                            hlist.add(a);
                            wlist.add(b + 1);
                            visited[a][b + 1] = true;
                        }
                        if (a < h - 1 && !visited[a + 1][b] && board[a + 1][b] == 'O') {
                            hlist.add(a + 1);
                            wlist.add(b);
                            visited[a + 1][b] = true;
                        }
                        if (a > 0 && !visited[a - 1][b] && board[a - 1][b] == 'O') {
                            hlist.add(a - 1);
                            wlist.add(b);
                            visited[a - 1][b] = true;
                        }
                    }
                }
            }

        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }

    }
}