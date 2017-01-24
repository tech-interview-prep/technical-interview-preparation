package leetcode.algorithms;

import java.util.Arrays;
import java.util.HashMap;

import utils.Utils;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to
 * a specific target.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Example:
 *    Given nums = [2, 7, 11, 15], target = 9,
 *
 *    Because nums[0] + nums[1] = 2 + 7 = 9,
 *    return [0, 1].
 *
 * UPDATE (2016/2/13):
 *    The return format had been changed to zero-based indices. Please read the above updated
 *    description carefully.
 *
 * https://leetcode.com/problems/two-sum/
 * http://n00tc0d3r.blogspot.com/2013/01/2sum-3sum-4sum-and-variances.html
 * @author bkoteshwarreddy
 */
public class _001TwoSum {
    public static void main(String[] args) {
        Solution_TwoSum sol = new Solution_TwoSum();

        Utils.printTestArrayln(sol.twoSumHashMap(new int[] {2, 7, 11, 15}, 9), new int[] {0, 1});
        Utils.printTestArrayln(sol.twoSumHashMap(new int[] {7, 11, 2, 15}, 9), new int[] {0, 2});
    }
}

class Solution_TwoSum {
    /**
     * 1. Naive Approach: This problem is pretty straightforward. We can simply examine every possible
     * pair of numbers in this integer array.
     * Time complexity in worst case: O(n^2).
     *
     * 2. Use HashMap to store the target value.
     * Time complexity depends on the put and get operations of HashMap which is normally O(1).
     * Time complexity of this solution: O(n).
     *
     * 3. Use two pointers if array is sorted. If not sorting takes O(nlogn)
     */
    public int[] twoSumHashMap(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return numbers;
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int index = map.get(numbers[i]);
                result[0] = index ;
                result[1] = i;
                break;
            } else {
                map.put(target - numbers[i], i);
            }
        }

        return result;
    }

    public int[] twoSumAnyPairAfterSorting(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int[] result = new int[2];
        Arrays.sort(numbers);
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                result[0] = numbers[start];
                result[1] = numbers[end];
                return result;
            } else if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            }
        }

        return result;
    }

    public List<List<Integer>> twoSumAllPairsAfterSorting(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numbers.length - 1; i++) {
            int tofind = target - numbers[i];
            int returned = Arrays.binarySearch(numbers, i + 1, numbers.length, tofind);
            if (returned > 0) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(numbers[i]);
                temp.add(numbers[returned]);
                result.add(temp);
            }
        }

        return result;
    }
}
