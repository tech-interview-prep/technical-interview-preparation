package leetcode_online_judge.Java;

import utils.Utils;

public class _122BestTimeToBuyAndSellStockII {
    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
    sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time
    (ie, you must sell the stock before you buy again).
     */
    public static int maxProfit(int[] prices) {
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

    private static void test() {
        Utils.printTestln(maxProfit(new int[]{3,2,6,5,0,3}), 7);
        Utils.printTestln(maxProfit(new int[]{1,2,4}), 3);
    }

    public static void main(String[] args) {
        test();
    }
}
