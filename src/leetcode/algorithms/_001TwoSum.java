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
     * UPDATE (2016/2/13):
     *      The return format had been changed to zero-based indices. Please read the above updated
     *      description carefully.
     */

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target - numbers[i]) + 1, i + 1};
            }
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], i);
            }
        }

        return null;
    }

    private static void test() {
        Utils.printTestArrayln(twoSum(new int[] {2, 7, 11, 15}, 9), new int[] {1, 2});
    }

    public static void main(String[] args) {
        test();
    }
}

