/*
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
 */

package facebook;

import utils.Utils;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 * @author bkoteshwarreddy
 */
public class _001TwoSum {
  public static void main(String[] args) {
    Solution_TwoSum sol = new Solution_TwoSum();  
    
    Utils.printTestArrayln(sol.twoSum_HashMap(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
    Utils.printTestArrayln(sol.twoSum_HashMap(new int[]{7, 11, 2, 15}, 9), new int[]{0, 2});
  }
}

class Solution_TwoSum {
  /*
    1. Naive Approach: This problem is pretty straightforward. We can simply examine every possible
      pair of numbers in this integer array.
    Time complexity in worst case: O(n^2).

    2. Use HashMap to store the target value.
      Time complexity depends on the put and get operations of HashMap which is normally O(1).
      Time complexity of this solution: O(n).

    3. Use two pointers if array is sorted. If not sorting takes O(nlogn)
  */
  public int[] twoSum_HashMap(int[] numbers, int target) {
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

  public void twoSum_anyPair_afterSorting(int[] arr, int target) {
    Arrays.sort(arr);
    int start = 0;
    int end = arr.length - 1;
    boolean found = false;
    while (!found && start < end) {
      if (arr[start] + arr[end] == target) {
        found = true;
      } else if (arr[start] + arr[end] > target) {
        end--;
      } else if (arr[start] + arr[end] < target) {
        start++;
      }
    }
    if (found) {
      System.out.println("Sum " + target
          + " is found, values the making sum are " + arr[start] + " , "
          + arr[end]);
    } else {
      System.out.println("No pair exists whose sum is " + target);
    }
  }

  public void twoSum_allPairs_afterSorting(int[] arr, int target) {
    Arrays.sort(arr);

    for (int i = 0; i < arr.length - 1; i++) {
      int tofind = target - arr[i];
      int returned = Arrays.binarySearch(arr, i + 1, arr.length, tofind);
      if (returned > 0) {
        System.out.println("Sum " + target
            + " is found, values the making sum are " + arr[i]
            + " , " + arr[returned]);
      }
    }
  }
}
