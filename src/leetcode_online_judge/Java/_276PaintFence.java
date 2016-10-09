package leetcode_online_judge.Java;

/**
 * https://oj.leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * @author bkoteshwarreddy
 */

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _276PaintFence {
    // [-3,3,4,90], 0
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1, sum;
        int[] idx = new int[2];
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum == target) {
                idx[0] = l + 1;
                idx[1] = r + 1;
                break;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return idx;
    }
}
