package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Utils;

/**
 * @author bkoteshwarreddy
 */
public class ThreeSum2 {
    /*
    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    Note:
    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a � b � c)
    The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
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

    public static List<List<Integer>> threeSum2(int[] nums) {

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

    private static void test() {
        Utils.printListListln(threeSum(new int[] { -1, 0, 1, 2, -1, -4}));
        System.out.println(">>> Another array");
        Utils.printListListln(threeSum(new int[] { -2, 0, 0, 2, 2}));
    }

    public static void main(String[] args) {
        test();
    }
}
