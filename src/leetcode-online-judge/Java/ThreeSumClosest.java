package leetcode_online_judge;

import utils.Utils;

import java.util.Arrays;

public class ThreeSumClosest {
    /*
    Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
    Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    */
    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);

        int minDiff = Integer.MAX_VALUE, closestSum = 0, sum, diff;
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1, k = num.length - 1; j < k; ) {
                sum = num[i] + num[j] + num[k];
                diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    closestSum = sum;
                    minDiff = diff;
                }
                if (sum == target) {
                    return sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return closestSum;
    }

    private static void test() {
        Utils.printTestln(threeSumClosest(new int[]{-1, 2, 1, -4}, 1), 2);
        Utils.printTestln(threeSumClosest(new int[]{0, 1, 2}, 3), 3);
    }

    public static void main(String[] args) {
        test();
    }
}
