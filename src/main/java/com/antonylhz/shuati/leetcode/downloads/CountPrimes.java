public class Solution {
    public int countPrimes(int n) {
        boolean[] table = new boolean[n+1];
        Arrays.fill(table, false);
        int np = 0, i= 2;
        while(i<n) {
            if(table[i]) i++;
            else {
                np++;
                int j = 2;
                while(i*j<=n) table[i*(j++)] = true;
                table[i++] = true;
            }
        }
        return np;
    }
}