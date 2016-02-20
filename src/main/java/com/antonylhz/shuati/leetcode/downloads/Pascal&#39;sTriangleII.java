public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] row = new int[]{1};
        for (int i = 0; i < rowIndex; i++) row = getNextRow(row);
        List<Integer> ints = new ArrayList<Integer>();
        for (int number : row) ints.add(number);
        return ints;
    }

    private int[] getNextRow(int[] row) {
        int len = row.length + 1;
        int[] newrow = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0 || i == len - 1) newrow[i] = 1;
            else newrow[i] = row[i - 1] + row[i];
        }
        return newrow;
    }
}