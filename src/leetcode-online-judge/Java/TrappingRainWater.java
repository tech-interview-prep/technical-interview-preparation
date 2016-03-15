package leetcode_online_judge;

import utils.Utils;

public class TrappingRainWater {
    /*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
    water it is able to trap after raining.

    For example,
    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

    see graph 

    The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
    (blue section) are being trapped. Thanks Marcos for contributing this image!
     */
    public static int trap(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        
        int[] rightMax = new int[A.length - 2];
        rightMax[rightMax.length - 1] = A[A.length - 1];
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], A[i + 2]);
        }

        int water = 0, leftMax = A[0];
        for (int i = 1; i < A.length - 1; i++) {
            water += Math.max(0, Math.min(leftMax, rightMax[i - 1]) - A[i]);
            leftMax = Math.max(A[i], leftMax);
        }

        return water;
    }

    private static void test() {
        Utils.printTestln(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6);
        Utils.printTestln(trap(new int[0]), 0);
    }

    public static void main(String[] args) {
        test();
    }
}
