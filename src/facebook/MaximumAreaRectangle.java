package facebook;

import java.util.Stack;

/*
	Given a matrix with 1's and 0's, a rectangle can be made with 1's. What is the maximum area of the rectangle.

    00010
    11100
    11110
    11000
    11010 In this test case the result needs to be 8.

    How:
    00010 00010
    11100 11 100
    11110 11 110
    11000 11 000
    11010 11 010

    If you see above the 11's are used from the first two columns and last four
    rows making the area or count of 1's to be 8.

	Link: http://www.careercup.com/question?id=6299074475065344
	      http://n00tc0d3r.blogspot.com/2013/04/maximum-rectangle.html

*/	
public class MaximumAreaRectangle {
    public int maximalRectangle(char[][] matrix) {
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
