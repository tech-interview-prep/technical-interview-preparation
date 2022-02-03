package leetcode.algorithms;

/**
 * https://leetcode.com/problems/house-robber-ii/
 *
 * @author bkoteshwarreddy
 */
public class _213HouseRobberII {
    /**
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of
     * money stashed. All houses at this place are arranged in a circle. That means the first house is the
     * neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will
     * automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of
     * money you can rob tonight without alerting the police.
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        int res = Math.max(dp[1], dp[n - 1]);

        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        return Math.max(res, dp[n]);
    }
}
