public class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNeg = (dividend<0)^(divisor<0);
        long dividendl = dividend;
        long divisorl = divisor;
        dividendl = Math.abs(dividendl);
        divisorl = Math.abs(divisorl);
        long result = 0;
        if(divisorl==0) return Integer.MAX_VALUE;
        else if(divisorl>dividendl) return 0;
        else if(divisorl==dividendl) return isNeg?-1:1;
        else if(divisorl==1) result = dividendl;
        else {
            int step = 0;
            long dvs = divisorl;
            while(dvs<dividendl) {
                dvs <<= 1;
                step++;
            }
            while(divisorl<=dividendl) {
                if(dividendl>=dvs) {
                    result += 1<<step;
                    dividendl -= dvs;
                }
                dvs >>= 1;
                step--;
            }
        }
        if(result>Integer.MAX_VALUE) return isNeg?dividend:Integer.MAX_VALUE;
        return (int)(isNeg?-result:result);
    }
}
