package facebook;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * https://leetcode.com/problems/3sum-closest/
 * http://www.programcreek.com/2013/02/leetcode-3sum-closest-java/
 * http://www.lifeincode.net/programming/leetcode-two-sum-3-sum-3-sum-closest-and-4-sum-java/
 * https://gist.github.com/zac-xin/4369860
 */
public class _016ThreeSumClosest {
    public static void main(String[] args) {

    }
}

class Solution_ThreeSumClosest {
    /**
     * 1. Naive Approach: This problem is pretty straightforward. We can simply examine every possible pair of numbers
     * in this integer array.
     *
     * Time complexity in worst case: O(n^3).
     *
     * 2. Use two pointers if array is sorted.
     * Time complexity of this solution: O(n^2).
    */
    public int threeSumClosest(int[] num, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                int diff = Math.abs(sum - target);
                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
