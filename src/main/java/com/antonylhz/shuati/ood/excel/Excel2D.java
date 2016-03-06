package com.antonylhz.shuati.ood.excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Excel implementation using 2d array
 *
 * index 0 is never used.
 *
 */

public class Excel2D implements Excel{

    private class Equation {
        private int row;
        private int column;
        private String content;
        private int height;
        private List<Equation> dependents;

        public Equation(String id, String content)
                throws ExcelIndexException, ExcelContentException {
            int[] numericalId = Excel.getNumericalId(id);
            row = numericalId[0];
            column = numericalId[1];
            this.content = content;
            height = 0;
            dependents = new ArrayList<>();
            evaluate();
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        public String getContent() {
            return content;
        }

        public int getHeight() {
            return height;
        }

        // Assume no brackets and only + and -
        private void evaluate() throws ExcelContentException {
            int res = 0;
            int cur = 0;
            boolean neg = false;
            while (cur < content.length()) {
                int next = findNextOperator(cur);
                if(next == cur) {
                    neg = content.charAt(cur) == '-';
                    cur = next + 1;
                    continue;
                }
                String expression = content.substring(cur, next);
                int val = 0;
                try {
                    val = Integer.parseInt(expression);
                } catch (NumberFormatException nfe) { // Reference to another cell
                    try {
                        int[] NumericalId = Excel.getNumericalId(expression);
                        if (!equationMap.containsKey(expression)) {
                            equationMap.put(expression,
                                    new Equation(expression, "0"));
                        }
                        Equation equation = equationMap.get(expression);
                        if (null == equation) {
                            throw new ExcelContentException();
                        }
                        val = matrix[equation.getRow()][equation.getColumn()];
                        height = Math.max(height, equation.getHeight() + 1);
                    } catch (ExcelIndexException eie) {
                        throw new ExcelContentException();
                    }
                }
                res += (neg ? -1 : 1) * val;
                neg = content.charAt(next) == '-';
                cur = next + 1;
            }
            matrix[row][column] = res;
            for(Equation equation : dependents) {
                try {
                    equation.evaluate();
                } catch (ExcelContentException ece) {
                    // Nothing needs to be done here.
                }
            }
        }

        private int findNextOperator(int start) {
            do {
                char c = content.charAt(start);
                if(c == '+' || c == '-') break;
            } while ((++start) < MAX_LENGTH);
            return start;
        }

    }

    private int[][] matrix;
    private Map<String, Equation> equationMap = new HashMap<>();

    public Excel2D() {
        matrix = new int[MAX_LENGTH + 1][MAX_LENGTH + 1];
        for(int[] row : matrix) {
            row = new int[MAX_LENGTH + 1];
        }
    }

    @Override
    public void enter(String id, String content)
            throws ExcelIndexException {
        int[] numericalId = Excel.getNumericalId(id);
        try {
            matrix[numericalId[0]][numericalId[1]] = Integer.parseInt(content);
        } catch (NumberFormatException e) { // Equation
            try {
                Equation equation = new Equation(id, content);
                equationMap.put(id, equation);
            } catch (ExcelContentException ece) {
                equationMap.put(id, null);
            }
        }
    }

    @Override
    public String getContent(int row, int column)
            throws ExcelIndexException {
        String id = Excel.getAlphabeticalId(row, column);
        if (equationMap.containsKey(id)) {
            String res = equationMap.get(id).content;
            return null == res ? "ERROR" : res;
        } else {
            return String.valueOf(matrix[row][column]);
        }
    }

    @Override
    public int getValue(int row, int column)
            throws ExcelIndexException, ExcelContentException {
        String id = Excel.getAlphabeticalId(row, column);
        if (equationMap.containsKey(id) &&
               null == equationMap.get(id)) {
            throw new ExcelContentException();
        }
        return matrix[row][column];
    }

    @Override
    public int getRowAverage(int row) {
        int cnt = 0;
        long sum = 0L;
        for(int i=1; i<=MAX_LENGTH; i++) {
            if(matrix[row][i] != 0) {
                cnt++;
                sum += matrix[row][i];
            }
        }
        return (int) (sum / cnt);
    }

    @Override
    public int getColumnAverage(int column) {
        int cnt = 0;
        long sum = 0L;
        for(int i=1; i<=MAX_LENGTH; i++) {
            if(matrix[i][column] != 0) {
                cnt++;
                sum += matrix[i][column];
            }
        }
        return (int) (sum / cnt);
    }

    @Override
    public String toString(int row, int column) {
        StringBuilder res = new StringBuilder();
        for(int i = row; i<= row + VISIBLE_CELL_CNT && i< MAX_LENGTH; i++) {
            for(int j=column; j<column + VISIBLE_CELL_CNT && j < MAX_LENGTH; j++) {
                try {
                    String entry = getContent(i, j);
                    int space = CELL_LENGTH - entry.length();
                    res.append(entry);
                    for (int k = 0; k < space; k++) res.append(" ");
                } catch (ExcelIndexException eie) {
                    // This won't happen. No handling
                }
            }
            res.append("\n");
        }
        return res.toString();
    }

}
