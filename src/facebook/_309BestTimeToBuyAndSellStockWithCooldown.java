package facebook;

import utils.Utils;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one
 * and sell one share of the stock multiple times) with the following restrictions:
 *      You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *      After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 *
 * Example:
 *      prices = [1, 2, 3, 0, 2]
 *      maxProfit = 3
 *      transactions = [buy, sell, cooldown, buy, sell]
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class _309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution_BestTimeToBuyAndSellStockWithCooldown sol = new Solution_BestTimeToBuyAndSellStockWithCooldown();
        Utils.printTestln(sol.maxProfit(new int[] {1, 2}), 1);
        Utils.printTestln(sol.maxProfit(new int[] {1, 2, 4}), 3);
        Utils.printTestln(sol.maxProfit(new int[] {4, 2, 1, 6, 8}), 7);
        Utils.printTestln(sol.maxProfit(new int[] {2, 1, 2, 0, 1}), 2);
    }
}

class Solution_BestTimeToBuyAndSellStockWithCooldown {
    // dynamic programming: O(n) space
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        } else if (prices.length == 2) {
            return Math.max(prices[1] - prices[0], 0);
        }
        // buy[i]: max profit gained by buying on ith day
        int[] buy = new int[prices.length];
        // sell[i]: max profit gained by selling on ith day
        int[] sell = new int[prices.length];
        buy[0] = - prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(prices[1] - prices[0], 0);
        for (int i = 2; i < prices.length; ++i) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }

    // dynamic programming: O(1) space
    public int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            return 0;
        } else if (prices.length == 2) {
            return Math.max(prices[1] - prices[0], 0);
        }
        //
        int b1 = Math.max(-prices[1], -prices[0]), b2 = 0;
        int s0 = 0, s1 = Math.max(prices[1] - prices[0], 0), s2 = 0;
        for (int i = 2; i < prices.length; ++i) {
            b2 = Math.max(b1, s0 - prices[i]);
            s2 = Math.max(s1, b1 + prices[i]);
            b1 = b2; s0 = s1; s1 = s2;
        }
        return s2;
    }
}
