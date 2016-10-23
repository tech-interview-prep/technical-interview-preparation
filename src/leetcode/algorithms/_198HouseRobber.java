/*
  You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
  stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
  connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

  Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
  of money you can rob tonight without alerting the police.

  http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
*/
package leetcode.algorithms;

/**
 * https://leetcode.com/problems/house-robber/
 * @author bkoteshwarreddy
 */
public class _198HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;

        if (n == 1) return nums[0];

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2 ; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[n];
    }

    public int rob2(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int max = 0;
        int pre = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int preMax = max;
            max = Math.max(max, pre + nums[i]);
            pre = preMax;
        }

        return max;
    }
}
