package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _045JumpGameII {
    /*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Your goal is to reach the last index in the minimum number of jumps.

    For example:
    Given array A = [2,3,1,1,4]

    The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
     */
    public static int jump(int[] A) {
        return jump(A, 0);
    }

    public static int jump(int[] A, int start) {
        if (start >= A.length - 1) {
            return 0;
        }

        int minJump = Integer.MAX_VALUE;
        for (int i = start + 1; i <= start + A[start]; i++) {
            minJump = Math.min(minJump, 1 + jump(A, i));
        }

        return minJump;

    }

    public static int jumpDP(int[] A) {
        int[] minNJump = new int[A.length];
        minNJump[minNJump.length - 1] =  0;

        for (int i = minNJump.length - 2; i >= 0; i--) {
            minNJump[i] = A[i] == 0 ? -1 : Integer.MAX_VALUE;

            for (int j = i + 1; j <= i + A[i] && j < A.length; j++) {
                if (minNJump[j] >= 0 && 1 + minNJump[j] < minNJump[i]) {
                    minNJump[i] = 1 + minNJump[j];
                }
            }

            if (minNJump[i] == Integer.MAX_VALUE) {
                minNJump[i] = -1;
            }
        }

        return minNJump[0] < 0 ? 0 : minNJump[0];
    }

    public static int jumpDP2(int[] A) {
        int[] minNJump = new int[A.length];
        int[] minJumpRange = new int[A.length]; // assume you are updating minJumpRange at step j, minJumpRange[i] is
        // the minimal jump to the end from A[j] to A[i] where i > j
        minNJump[minNJump.length - 1] =  0;
        minJumpRange[minJumpRange.length - 1] = 0;

        for (int i = minNJump.length - 2; i >= 0; i--) {
            minJumpRange[i] = Integer.MAX_VALUE; // in the case A[i] == 0
            int index = i + A[i] < minNJump.length ? i + A[i] : minNJump.length - 1;
            minNJump[i] = 1 + minJumpRange[index] < 0 ? Integer.MAX_VALUE : 1 + minJumpRange[index];

            minJumpRange[i] = minNJump[i];

            for (int j = i + 1; j < A.length && minJumpRange[j - 1] < minJumpRange[j]; j++) {
                minJumpRange[j] = minJumpRange[j - 1];
            }
        }

        return minNJump[0] == Integer.MAX_VALUE ? 0 : minNJump[0];
    }

    private static void test() {
        Utils.printTestln(jump(new int[]{2, 3, 1, 1, 4}), 2);

        System.out.println("\n>>>Below is the DP solution:\n");

        int[] largeArray = _055JumpGame.getLargeSampleIntArray();
        Utils.printTestln(jumpDP(new int[] {2, 3, 1, 1, 4}), 2);
        Utils.printTestln(jumpDP(new int[] {5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}), 5);
        Utils.printTestln(jumpDP(largeArray), 0);

        System.out.println("\n>>>Below is the further optimized DP solution:\n");

        Utils.printTestln(jumpDP2(new int[] {2, 1, 1, 0, 0}), 0);
        Utils.printTestln(jumpDP2(new int[] {2, 3, 1, 1, 4}), 2);
        Utils.printTestln(jumpDP2(new int[] {5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}), 5);
        Utils.printTestln(jumpDP2(largeArray), 0);
    }

    public static void main(String[] args) {
        test();
    }
}
