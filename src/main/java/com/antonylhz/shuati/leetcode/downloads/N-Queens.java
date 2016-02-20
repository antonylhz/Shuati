public class Solution {
    public List<String[]> solveNQueens(int n) {
        //Initial permutation
        int[] cols = new int[n];
        for(int i = 0; i < n; i++) {
            cols[i] = i;
        }

        //Iterate all permutations
        List<String[]> out = new ArrayList<String[]>();
        do{//n!
            if(!isDiagonalThreat(cols)) {//O(n^2)
                out.add(buildDisposition(cols));//O(n^2)
            }
        } while ((cols = perm(cols)) != null);

        return out;
    }

    private String[] buildDisposition(int[] cols) {
        String[] disposition = new String[cols.length];
        for(int i = 0; i < disposition.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < disposition.length; j++) {
                sb.append(cols[i] == j ? 'Q' : '.');
            }
            disposition[i] = sb.toString();
        }
        return disposition;
    }

    //http://en.wikipedia.org/wiki/Permutation#Algorithms_to_generate_permutations
    private int[] perm(int[] cols) {
        int i = cols.length-2;
        while(i >=0 && cols[i] >= cols[i+1]) {
            i--;
        }
        if(i == -1) {
            return null;
        }
        int j = cols.length-1;
        while(j>=0 && cols[i] >= cols[j]) {
            j--;
        }

        //Swap
        int tmp = cols[i];
        cols[i] = cols[j];
        cols[j] = tmp;

        //Reverse
        for(int k = 0;k < (cols.length-i-1)/2; k++) {
            //Swap
            tmp = cols[i+1+k];
            cols[i+1+k] = cols[cols.length-1-k];
            cols[cols.length-1-k] = tmp;
        }
        return cols;
    }

    //Check for diagonals attacks
    private boolean isDiagonalThreat(int[] cols) {
        for(int j = 0; j < cols.length; j++) {
            for(int k = j+1; k < cols.length; k++) {
                int delta = k-j;
                if(cols[j]-delta == cols[k]
                        || cols[j]+delta == cols[k]) {
                    return true;
                }
            }
        }
        return false;
    }
}