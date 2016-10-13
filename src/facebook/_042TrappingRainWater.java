package facebook;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
 * water it is able to trap after raining.
 *
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * Trapping Rain Water Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining. For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6
 *
 * https://leetcode.com/problems/trapping-rain-water
 * https://gist.github.com/bittib/5627203
 */
public class _042TrappingRainWater {
    public static void main(String[] args) {
        Solution_TrappingRainWater sol = new Solution_TrappingRainWater();

        sol.trap(null);
    }
}

class Solution_TrappingRainWater {
    public int trap(int[] A) {
        int n = A.length, sum = 0;
        if (n < 3) return 0;
        int[] leftBar = new int[n], rightBar = new int[n];
        for (int i = 1; i < n; i++)
            leftBar[i] = Math.max(leftBar[i - 1], A[i - 1]);
        for (int i = n - 2; i >= 0; i--)
            rightBar[i] = Math.max(rightBar[i + 1], A[i + 1]);
        for (int i = 0; i < n; i++)
            sum += Math.max(0, Math.min(leftBar[i], rightBar[i]) - A[i]);
        return sum;
    }
}
