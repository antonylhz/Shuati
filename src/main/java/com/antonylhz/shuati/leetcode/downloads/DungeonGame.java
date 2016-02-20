public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) return 1;
        int height = dungeon.length, width = dungeon[0].length;
        int[][] hp = new int[height][width];
        for (int i = height - 1; i >= 0; i--)
            for (int j = width - 1; j >= 0; j--) {
                if (i == height - 1 && j == width - 1) hp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                else if (i == height - 1) hp[i][j] = Math.max(1, hp[i][j + 1] - dungeon[i][j]);
                else if (j == width - 1) hp[i][j] = Math.max(1, hp[i + 1][j] - dungeon[i][j]);
                else hp[i][j] = Math.max(1, Math.min(hp[i + 1][j], hp[i][j + 1]) - dungeon[i][j]);
            }
        return hp[0][0];
    }
}