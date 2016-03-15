package leetcode_online_judge;

import utils.Utils;

import java.util.Stack;

public class MaximalRectangle {
    /*
    Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
     */
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length, maxArea = 0;

        int[] histogram = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    histogram[j] = 0;
                } else {
                    histogram[j]++;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleInHistogram(histogram));
        }

        return maxArea;
    }

    private static int largestRectangleInHistogram(int[] histogram) {
        Stack<Integer> stack = new Stack<Integer>();
        int index, preIdx, maxArea = 0;
        for (int i = 0; i < histogram.length; i++) {
            while (!stack.isEmpty() && histogram[index = stack.peek()] > histogram[i]) {
                stack.pop();
                preIdx = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (i - 1 - preIdx) * histogram[index]);
            }
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            index = stack.pop();
            preIdx = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (histogram.length - 1 - preIdx) * histogram[index]);
        }

        return maxArea;
    }

    private static void test() {
        Utils.printTestln(maximalRectangle(new char[][]{"010".toCharArray(),
                "011".toCharArray(),
                "011".toCharArray()}), 4);

    }

    public static void main(String[] args) {
        test();
    }
}
