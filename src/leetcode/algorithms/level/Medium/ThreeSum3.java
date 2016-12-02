package leetcode.algorithms.level.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Utils;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets
 * in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a � b � c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 *
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 *
 * https://leetcode.com/problems/3sum/
 * http://n00tc0d3r.blogspot.com/2013/01/2sum-3sum-4sum-and-variances.html
 */
public class ThreeSum3 {
    public static void main(String[] args) {
        Solution_3Sum sol = new Solution_3Sum();

        Utils.printListListln(sol.threeSum(new int[] { -1, 0, 1, 2, -1, -4}));
        System.out.println(">>> Another array");
        Utils.printListListln(sol.threeSum(new int[] { -2, 0, 0, 2, 2}));
    }
}

class Solution_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // //avoid duplicate solutions
            if (i == 0 || nums[i] > nums[i - 1]) {
                int start = i + 1;
                int end = nums.length - 1;

                while (start < end) {
                    if (nums[start] + nums[end] + nums[i] == 0) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);

                        result.add(temp);
                        start++;
                        end--;
                        //avoid duplicate solutions
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }

                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                    } else if (nums[start] + nums[end] + nums[i] < 0) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        return result;
    }

    /*

      1. Naive Approach: This problem is pretty straightforward. We can simply examine every possible pair of numbers in this integer array.
      Time complexity in worst case: O(n^3).

      2. Use two pointers if array is sorted.

      Time complexity of this solution: O(n^2).

    */
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // //avoid duplicate solutions
            if (i == 0 || nums[i] > nums[i - 1]) {
                int start = i + 1;
                int end = nums.length - 1;

                while (start < end) {
                    //case 1
                    if (nums[start] + nums[end] + nums[i] == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);

                        result.add(temp);
                        start++;
                        end--;
                        //avoid duplicate solutions
                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }

                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                    } else if (nums[start] + nums[end] + nums[i] < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        return result;
    }
}
