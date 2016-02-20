public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n], cur = new int[primes.length];
        res[0] = 1;
        for(int i=1; i<n; i++) {
            res[i] = Integer.MAX_VALUE;
            int pj = 0;
            for(int j=0; j<primes.length; j++) {
                int tmp = primes[j] * res[cur[j]];
                if(tmp == res[i-1]) {
                    tmp = primes[j] * res[++cur[j]];
                }
                if(tmp < res[i]) {
                    pj = j;
                    res[i] = tmp;
                }
            }
            cur[pj]++;
        }
        return res[n-1];
    }
}