/*
  Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of
  all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose
of space complexity analysis.)
   */
package facebook;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * @author bkoteshwarreddy
 */

public class _238ProductofArrayExceptSelf {

}

class Solution_ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // result array
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 0; i < nums.length - 1; ++i) {
            // cumulative multiplication from left to right
            res[i + 1] = res[i] * nums[i];
        }
        int right = 1;
        // cumulative mulitplication from right to left
        for(int i = nums.length - 1; i >= 0; --i) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
