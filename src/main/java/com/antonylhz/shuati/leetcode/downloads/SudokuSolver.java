public class Solution {
    boolean done = false;

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return;
        dfs(board, 0, 0);
    }

    private void dfs(char[][] board, int x, int y) {
        // position correction
        if (y == 9) {
            y = 0;
            x = x + 1;
        }

        // base case
        if (x == 9) {
            done = true;
            return;
        }

        // recursion
        if (board[x][y] != '.') {
            dfs(board, x, y + 1);
        } else {
            List<Integer> list = validNum(board, x, y);
            for (int i = 0; i < list.size(); i++) {
                board[x][y] = (char) ('0' + list.get(i));
                dfs(board, x, y + 1);
                if (done) return;
                board[x][y] = '.';
            }
        }
    }

    private List<Integer> validNum(char[][] board, int x, int y) {
        List<Integer> list = new ArrayList<Integer>();
        int center_x = x / 3 * 3 + 1;
        int center_y = y / 3 * 3 + 1;
        boolean[] engaged = new boolean[9];
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                if (board[center_x + i][center_y + j] != '.')
                    engaged[board[center_x + i][center_y + j] - '1'] = true;
        for (int i = 0; i < 9; i++)
            if (board[i][y] != '.') engaged[board[i][y] - '1'] = true;
        for (int j = 0; j < 9; j++)
            if (board[x][j] != '.') engaged[board[x][j] - '1'] = true;
        for (int i = 0; i < engaged.length; i++)
            if (!engaged[i]) list.add(i + 1);
        return list;
    }

}
