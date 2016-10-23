package leetcode.algorithms;

import java.util.Stack;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _084LargestRectangelInHistogram {
    /*
    Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

    // See file histogram.png
    Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

    // see file histogram_area.png
    The largest rectangle is shown in the shaded area, which has area = 10 unit.

    For example,
    Given height = [2,1,5,6,2,3],
    return 10.

    Discuss
     */
    public static int largestRectangleArea(int[] height) {
        return largestRectangleAreaHelper(height, 0, height.length);
    }

    private static int largestRectangleAreaHelper(int[] height, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int minIdx = start, min = height[start], leftEnd, rightStart;
        for (int i = start; i < end; i++) {
            if (height[i] < min) {
                minIdx = i;
                min = height[i];
            }
        }

        for (leftEnd = minIdx; leftEnd >= start && height[leftEnd] == min; leftEnd--);
        for (rightStart = minIdx; rightStart < end && height[rightStart] == min; rightStart++);

        return Math.max(min * (end - start), Math.max(largestRectangleAreaHelper(height, start, leftEnd + 1),
                        largestRectangleAreaHelper(height, rightStart, end)));
    }

    public static int largestRectangleArea2(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0, index, preIdx;

        for (int i = 0; i < height.length; i++) {
//            while (!stack.isEmpty() && height[index = stack.peek()] >= height[i]) {  // >= or > does not matter
            while (!stack.isEmpty() && height[index = stack.peek()] > height[i]) {
                stack.pop();
                preIdx = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (i - preIdx - 1) * height[index]);
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            index = stack.pop();
            preIdx = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (height.length - preIdx - 1) * height[index]);
        }

        return maxArea;
    }

    private static void test() {
        Utils.printTestln(largestRectangleArea(new int[] {}), 0);
        Utils.printTestln(largestRectangleArea(new int[] {2, 1}), 2);
        Utils.printTestln(largestRectangleArea(new int[] {2, 1, 2}), 3);
        Utils.printTestln(largestRectangleArea(new int[] {1, 1}), 2);
        Utils.printTestln(largestRectangleArea(new int[] {4, 2, 0, 3, 2, 5}), 6);
        Utils.printTestln(largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}), 10);

        System.out.println("\n>>>Below is the linear algorithm:\n");

        Utils.printTestln(largestRectangleArea2(new int[] {}), 0);
        Utils.printTestln(largestRectangleArea2(new int[] {2, 1}), 2);
        Utils.printTestln(largestRectangleArea2(new int[] {2, 1, 2}), 3);
        Utils.printTestln(largestRectangleArea2(new int[] {1, 1}), 2);
        Utils.printTestln(largestRectangleArea2(new int[] {4, 2, 0, 3, 2, 5}), 6);
        Utils.printTestln(largestRectangleArea2(new int[] {2, 1, 5, 6, 2, 3}), 10);
    }

    public static void main(String[] args) {
        test();
    }
}
