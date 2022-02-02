package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

import utils.Utils;

/**
 * https://leetcode.com/problems/two-sum/
 * @author bkoteshwarreddy
 */
public class _001TwoSum {
    /*
     * Given an array of integers, return indices of the two numbers such that they add up to
     * a specific target.
     *
     * You may assume that each input would have exactly one solution.
     *
     * Example:
     *      Given nums = [2, 7, 11, 15], target = 9,
     *
     *      Because nums[0] + nums[1] = 2 + 7 = 9,
     *      return [0, 1].
     *
     */

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }

        return null;
    }

    public static int[] twoSumTwoPass(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }

    private static void test() {
        Utils.printTestArrayln(twoSum(new int[] {2, 7, 11, 15}, 9), new int[] {1, 2});
    }

    public static void main(String[] args) {
        test();
    }
}

