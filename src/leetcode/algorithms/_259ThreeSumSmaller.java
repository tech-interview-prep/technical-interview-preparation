package leetcode.algorithms;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * Return 2. Because there are two triplets which sums are less than 2:
 *   [-2, 0, 1]
 *   [-2, 0, 3]
 *
 * Follow up:
 * Could you solve it in O(n2) runtime?
 *
 * https://leetcode.com/problems/3sum-smaller/
 */
public class _259ThreeSumSmaller {

}

class Solution_ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int answer = 0;
        // the first number is num[i], the other two are to the right of i
        for (int i = 0; i < nums.length - 2; ++i) {
            int left = i + 1, right = nums.length - 1;
            // If current sum is larger, move the right pointer left, else count the combinations and move left pointer
            // right
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    answer += right - left;
                    ++left;
                } else {
                    --right;
                }
            }
        }

        return answer;
    }
}
