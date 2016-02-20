public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k == 0) return 0;
        if (k >= prices.length - 1) return maxProfit_no_constrains(prices);
        int[] buy = new int[k + 1], sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++)
            for (int j = 1; j <= k; j++) {
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
            }
        return sell[k];
    }

    private int maxProfit_no_constrains(int[] prices) {
        int profit = 0, diff = 0;
        for (int i = 1; i < prices.length; i++) {
            diff = prices[i] - prices[i - 1];
            if (diff > 0) profit += diff;
        }
        return profit;
    }
}