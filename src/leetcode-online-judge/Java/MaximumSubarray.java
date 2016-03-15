package leetcode_online_judge;

import utils.Utils;

public class MaximumSubarray {
    /*
    Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

    For example, given the array [?2,1,?3,4,?1,2,1,?5,4],
    the contiguous subarray [4,?1,2,1] has the largest sum = 6.
     */
    public static int maxSubArray(int[] A) {
        int sum = A[0], maxSum = A[0];
        for (int i = 1; i < A.length; i++) {
            sum = sum < 0 ? A[i] : sum + A[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    private static void test() {
        Utils.printTestln(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), 6);
    }

    public static void main(String[] args) {
        test();
    }
}
