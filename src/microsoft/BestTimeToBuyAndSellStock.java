package leetcode.algorithms.level.Easy;

import utils.Utils;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design
 * an algorithm to find the maximum profit.
 *
 * Example 1:
 *      Input: [7, 1, 5, 3, 6, 4]
 *      Output: 5
 *
 *      max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 *
 * Example 2:
 *      Input: [7, 6, 4, 3, 1]
 *      Output: 0
 *
 *      In this case, no transaction is done, i.e. max profit = 0.
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * http://n00tc0d3r.blogspot.com/2013/01/best-time-to-buy-and-sell-stock.html
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution_BestTimeToBuyAndSellStock sol = new Solution_BestTimeToBuyAndSellStock();
        Utils.printTestln(sol.maxProfit(new int[] {3, 2, 6, 5, 0, 3}), 4);
    }
}

class Solution_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minBuy = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int size = prices.length;

        if (size <= 1) {
            return 0;
        }

        int min = prices[0];
        int max = prices[1] - min;
        for (int i = 2; i < size; i++) {

            if (min > prices[i - 1]) {
                min = prices[i - 1];
            }

            if (max < (prices[i] - min)) {
                max = prices[i] - min;
            }
        }

        return (max < 0) ? 0 : max;
    }
}
