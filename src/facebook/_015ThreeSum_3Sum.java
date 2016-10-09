package facebook;

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
 */
public class _015ThreeSum_3Sum {
    public static void main(String[] args) {
        Solution_3Sum sol = new Solution_3Sum();

        Utils.printListListln(sol.threeSum(new int[] { -1, 0, 1, 2, -1, -4}));
        System.out.println(">>> Another array");
        Utils.printListListln(sol.threeSum(new int[] { -2, 0, 0, 2, 2}));
    }
}

class Solution_3Sum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);

        for (int i = 0; i < num.length;) {
            for (int start = i + 1, end = num.length - 1; start < end;) {
                if (start > i + 1 && num[start] == num[start - 1] || num[start] + num[end] + num[i] < 0) {
                    start++;
                } else if (end < num.length - 1 && num[end] == num[end + 1] || num[start] + num[end] + num[i] > 0) {
                    end--;
                } else if (num[start] + num[end] + num[i] == 0) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[start]);
                    tmp.add(num[end]);
                    ret.add(tmp);
                    start++;
                    end--;
                }
            }
            for (i++; i < num.length && num[i] == num[i - 1]; i++);
        }

        return ret;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int n = nums.length;
        if (n < 3) return result;

        Arrays.sort(nums);

        int i = 0;

        while (i < n - 2) {
            int start = i + 1, end = n - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    do {
                        end--;
                    } while (end > start && nums[end] == nums[end + 1]);
                    do {
                        start++;
                    } while (start < end && nums[start] == nums[start - 1]);
                } else if (sum > 0) {
                    do {
                        end--;
                    } while (end > start && nums[end] == nums[end + 1]);
                } else {
                    do {
                        start++;
                    } while (start < end && nums[start] == nums[start - 1]);
                }
            }
            do {
                i++;
            } while (i < n - 2 && nums[i] == nums[i - 1]);
        }

        return result;
    }

    /*

      1. Naive Approach: This problem is pretty straightforward. We can simply examine every possible pair of numbers in this integer array.
      Time complexity in worst case: O(n^3).

      2. Use two pointers if array is sorted.

      Time complexity of this solution: O(n^2).

    */
    public List<List<Integer>> threeSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (num.length < 3)
            return result;

        // sort array
        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            // //avoid duplicate solutions
            if (i == 0 || num[i] > num[i - 1]) {

                int diff = target - num[i];

                int start = i + 1;
                int end = num.length - 1;

                while (start < end) {
                    //case 1
                    if (num[start] + num[end] == diff) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[start]);
                        temp.add(num[end]);

                        result.add(temp);
                        start++;
                        end--;
                        //avoid duplicate solutions
                        while (start < end && num[end] == num[end + 1])
                            end--;

                        while (start < end && num[start] == num[start - 1])
                            start++;
                        //case 2
                    } else if (num[start] + num[end] < diff) {
                        start++;
                        //case 3
                    } else {
                        end--;
                    }
                }

            }
        }

        return result;
    }
}
