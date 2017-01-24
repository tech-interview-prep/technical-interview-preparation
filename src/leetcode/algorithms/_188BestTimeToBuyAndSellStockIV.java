package leetcode.algorithms;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * @author bkoteshwarreddy
 */
public class _188BestTimeToBuyAndSellStockIV {
}

class Solution_BestTimeToBuyAndSellStockIV {
    public int greedy(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; ++i) {
            sum += (prices[i] > prices[i - 1]) ? (prices[i] - prices[i - 1]) : 0;
        }
        return sum;
    }

    // dynamic programming: state transition
    public int maxProfit(int k, int[] prices) {
        // cannot complete even one transaction
        if (prices.length < 2) {
            return 0;
        }
        // changed to greedy algorithm
        if (k >= prices.length) {
            return greedy (prices);
        }
        // local[i][k]: max profit by jth transaction on ith day
        int[][] local = new int[prices.length][k + 1];
        // global[i][j]: max profit by j transactions in i days
        int[][] global = new int[prices.length][k + 1];
        for (int i = 1; i < prices.length; ++i) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; ++j) {
                // max(buy in on ith day, sell on ith day -> jth sale)
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[prices.length - 1][k];
    }
}
