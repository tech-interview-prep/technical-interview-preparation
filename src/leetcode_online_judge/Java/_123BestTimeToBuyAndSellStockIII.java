package leetcode_online_judge.Java;

import utils.Utils;

public class _123BestTimeToBuyAndSellStockIII {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete at most two transactions.

    Note:
    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     */

    //2 buys and 2 sells
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int[] profitForward = new int[prices.length], profitBackward = new int[prices.length];

        int minF = prices[0], maxB = prices[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            minF = Math.min(minF, prices[i]);
            maxB = Math.max(maxB, prices[prices.length - i - 1]);
            profitForward[i] = Math.max(profitForward[i - 1], prices[i] - minF);
            profitBackward[prices.length - i - 1] = Math.max(profitBackward[prices.length - i], maxB - prices[prices.length - i - 1]);
        }

        int profit = profitBackward[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profitForward[i - 1] + profitBackward[i], profit);
        }

        return profit;
    }

    private static void test() {
        Utils.printTestln(maxProfit(new int[]{1, 2}), 1);
        Utils.printTestln(maxProfit(new int[]{1, 2, 4}), 3);
        Utils.printTestln(maxProfit(new int[]{4, 2, 1, 6, 8}), 7);
        Utils.printTestln(maxProfit(new int[]{2, 1, 2, 0, 1}), 2);
    }

    public static void main(String[] args) {
        test();
    }
}
