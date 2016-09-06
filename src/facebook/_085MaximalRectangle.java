/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Return 6.

Link: http://www.careercup.com/question?id=6299074475065344
Link: http://n00tc0d3r.blogspot.com/2013/04/maximum-rectangle.html
 */

package facebook;

import utils.Utils;
import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 * @author bkoteshwarreddy
 */

public class _085MaximalRectangle {
    public static void main(String[] args) {
      Solution_MaximalRectangle sol = new Solution_MaximalRectangle();
      Utils.printTestln(sol.maximalRectangle(new char[][]{"010".toCharArray(),
              "011".toCharArray(),
              "011".toCharArray()}), 4);
    }
}

class Solution_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
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

    private int largestRectangleInHistogram(int[] histogram) {
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

    public int maximalRectangle2(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }

        int[] row = new int[matrix[0].length];
        int maxRect = 0;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<row.length; j++)
            {
                row[j] = (matrix[i][j] != '0') ? row[j]+1 : 0;
            }

            maxRect = Math.max(maxRect, maxRectangle(row));
        }

        return maxRect;
    }

    private int maxRectangle(int[] input) {
        Stack<Integer> ss = new Stack<Integer>();
        int maxArea = 0, i = 0;
        while (i < input.length) {
            if (ss.isEmpty() || input[i] >= input[ss.peek()]) {
                ss.push(i++);
            } else {
                maxArea = Math.max(maxArea,
                        input[ss.pop()]*(ss.isEmpty() ? i : (i - ss.peek() - 1)));
            }
        }
        while (!ss.isEmpty()) {
            maxArea = Math.max(maxArea,
                    input[ss.pop()]*(ss.isEmpty() ? i : (i - ss.peek() - 1)));
        }
        return maxArea;
    }

    /*
        Largest Rectangle in Histogram Given n non-negative integers representing the histogram's bar height
        where the width of each bar is 1, find the area of largest rectangle in the histogram.

        For example, Given height = [2,1,5,6,2,3], return 10.

        Link: https://gist.github.com/bittib/5653293
              http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
     */

    public int largestRectangleArea(int[] height) {
        int maxArea = 0;
        Stack<Bar> stack = new Stack<Bar>();
        stack.push(new Bar(-1, 0));
        for (int i=0; i<=height.length; i++){
            int h = i < height.length ? height[i] : 0;
            int startIdx = i;
            while (!stack.isEmpty() && stack.peek().height >= h){
                Bar bar = stack.pop();
                startIdx = bar.startIdx;
                maxArea = Math.max(maxArea, (i - startIdx) * bar.height);
            }
            stack.push(new Bar(h, startIdx));
        }
        return maxArea;
    }

    class Bar{
        int height, startIdx;
        Bar(int h, int i){ this.height = h; this.startIdx = i; }
    }
}
