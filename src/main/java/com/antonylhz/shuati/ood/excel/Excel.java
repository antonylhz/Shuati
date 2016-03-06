package com.antonylhz.shuati.ood.excel;

/**
 * Design Excel and its related functions
 *
 * Note: 1 based index
 *
 * 1. Basic data storage;
 * 2. Reference to other cells
 * 3. Calculations with multiple cells.
 * 4. Row/Column calculations.
 *
 * Cell Id
 * eg: D3, Row
 *
 * options:
 * 1. 2D array. best for access. waste of memory.
 * 2. List of List. similar to 2D array, slightly better for storage
 * 3. Graph, with links to same row / column
 */

public interface Excel {
    int MAX_LENGTH = 1<<16;
    int RADIX = 26;
    int CELL_LENGTH = 12;
    int VISIBLE_CELL_CNT = 1<<4;

    static boolean isInRange(int index) {
        return index >= 1&& index <= MAX_LENGTH;
    }

    static int[] getNumericalId(String str) throws ExcelIndexException {
        int[] res = new int[2];
        int dStart = 0;
        while (dStart < str.length() &&
                Character.isDigit(str.charAt(dStart))) {
            dStart++;
        }
        try {
            res[1] = Integer.parseInt(str.substring(dStart));
        } catch (NumberFormatException nfe) {
            throw new ExcelIndexException();
        }
        res[0] = getNumericalColumn(str.substring(0, dStart));
        if (!isInRange(res[0]) || !isInRange(res[1])) {
            throw new ExcelIndexException();
        }
        return res;
    }

    static int getNumericalColumn(String str) throws ExcelIndexException {
        char[] cs = str.toUpperCase().toCharArray();
        int res = 0;
        for (char c : cs) {
            int val = (int) (c - 'A' + 1);
            if (val >= 1 && val <= RADIX &&
                    val <= MAX_LENGTH - res * RADIX ) {
                res *= RADIX;
                res += val;
            } else {
                throw new ExcelIndexException();
            }
        }
        return res;
    }

    static String getAlphabeticalId(int row, int column) throws ExcelIndexException {
        if(!isInRange(row)) {
            throw new ExcelIndexException();
        }
        return getAlphabeticalColumn(column) + String.valueOf(row);
    }

    static String getAlphabeticalColumn(int id) throws ExcelIndexException {
        if(!isInRange(id)) {
            throw new ExcelIndexException();
        }
        int base = 1;
        while (base * RADIX < id) {
            base *= RADIX;
        }
        StringBuilder res = new StringBuilder();
        while (id > 0) {
            int val = id / base;
            if(id % base == 0 && id > RADIX) {
                val--;
            }
            res.append((char)(val - 1 + 'A'));
            id -= val * RADIX;
            base /= RADIX;
        }
        return res.toString();
    }

    /**
     * Enter content at location (row, column)
     *
     * It can be either number or equation which needs to be further calculated
     *
     * @param id
     * @param content
     */
    void enter(String id, String content) throws ExcelIndexException;

    /**
     *
     * @param row
     * @param column
     * @return plain input from user, either a number or an equation
     */
    String getContent(int row, int column) throws ExcelIndexException;

    int getValue(int row, int column) throws ExcelIndexException, ExcelContentException;
    int getRowAverage(int row);
    int getColumnAverage(int column);

    /**
     * Show the VISIBLE_CELL_CNT * VISIBLE_CELL_CNT block of data
     * starting from cell (row, column)
     * @param row
     * @param column
     * @return
     */
    String toString(int row, int column);

}
