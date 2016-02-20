public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2) return 0;
        int len = prices.length;
        int[] buy = new int[3], sell = new int[3];
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);
        for(int i=0; i<len; i++)
            for(int j=1; j<3; j++) {
                sell[j] = Math.max(sell[j], buy[j]+prices[i]);
                buy[j] = Math.max(buy[j], (j>0?sell[j-1]:0)-prices[i]);
            }
        return sell[2];
    }
}