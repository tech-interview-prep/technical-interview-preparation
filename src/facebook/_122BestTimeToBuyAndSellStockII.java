package facebook;

import utils.Utils;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
 * sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * http://n00tc0d3r.blogspot.com/2013/01/best-time-to-buy-and-sell-stock.html
 */
public class _122BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        Solution_BestTimeToBuyAndSellStockII sol = new Solution_BestTimeToBuyAndSellStockII();
        Utils.printTestln(sol.maxProfit(new int[] {3, 2, 6, 5, 0, 3}), 7);
        Utils.printTestln(sol.maxProfit(new int[] {1, 2, 4}), 3);
    }
}

class Solution_BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}