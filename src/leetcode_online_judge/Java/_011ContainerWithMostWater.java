package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _011ContainerWithMostWater {
    /*
    Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical
    lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with
    x-axis forms a container, such that the container contains the most water.

    Note: You may not slant the container.
    */
    public static int maxArea(int[] height) {
        int start = 0, end = height.length - 1, maxArea = 0;

        while (start < end) {
            maxArea = Math.max(maxArea, (end - start) * Math.min(height[start], height[end]));

            if (height[start] == height[end]) {
                start++;
                end--;
            } else if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }

    public static int maxArea2(int[] height) { // best performance - time
        int start, end, maxArea = 0;

        for (start = 0, end = height.length - 1; start < end;) {
            maxArea = Math.max(maxArea,  (end - start) * Math.min(height[start], height[end]));
            int originIdx = start;
            if (height[start] <= height[end]) {
                for (start++; start < end && height[start] <= height[originIdx]; start++);
            }
            if (height[originIdx] >= height[end]) {
                for (originIdx = end--; start < end && height[end] <= height[originIdx]; end--);
            }
        }

        return maxArea;
    }

    public int maxArea3(int[] height) { //best
        int maxRes = Integer.MIN_VALUE;
        int maxHeight;
        int tmpRes;
        int leftPointer = 0, rightPointer = height.length - 1;
        while (leftPointer < rightPointer) {
            tmpRes = rightPointer - leftPointer;
            // judge if the left pointer's height bigger?
            if (height[leftPointer] < height[rightPointer]) {
                maxHeight =  height[leftPointer++];
            } else {
                maxHeight = height[rightPointer--];
            }
            // to get the result of result now
            tmpRes = maxHeight * tmpRes;
            // get the max result
            if (tmpRes > maxRes) {
                maxRes = tmpRes;
            }
        }
        return maxRes;
    }

    private static void test() {
        Utils.printTestln(maxArea(new int[] {3, 5, 3, 4, 6, 8}), 20);
        Utils.printTestln(maxArea2(new int[] {3, 5, 3, 4, 6, 8}), 20);
    }

    public static void main(String[] args) {
        test();
    }
}
