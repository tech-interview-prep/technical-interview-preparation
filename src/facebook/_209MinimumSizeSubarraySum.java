/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
package facebook;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * @author bkoteshwarreddy
 */
public class _209MinimumSizeSubarraySum {
}

class Solution_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // sliding window
        int sum = 0;
        int min_len = Integer.MAX_VALUE;
        // two sides of window
        int l = 0, r = 0;
        while (r < nums.length) {
            while (sum < s && r < nums.length) {
                sum += nums[r++];
            }
            while (sum >= s) {
                min_len = Math.min(min_len, r - l);
                sum -= nums[l++];
            }
        }
        return (min_len == Integer.MAX_VALUE) ? 0 : min_len;
    }
}
