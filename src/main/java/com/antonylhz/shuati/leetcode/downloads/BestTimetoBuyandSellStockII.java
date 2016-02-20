public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int gap = prices[i] - prices[i - 1];
            if (gap > 0) profit += gap;
        }
        return profit;
    }
}