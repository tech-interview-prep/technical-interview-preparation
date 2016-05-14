package leetcode_online_judge.Java;

import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class _054SpiralMatrix {
    /*
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

    For example,
    Given the following matrix:

    [
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
    ]
    You should return [1,2,3,6,9,8,7,4,5].
     */
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return ret;
        }

        int rStart = 0, rEnd = matrix[0].length - 1, cStart = 0, cEnd = matrix.length - 1;
        for (; rStart < rEnd && cStart < cEnd; rStart++, rEnd--, cStart++, cEnd--) {
            for (int i = rStart; i < rEnd; i++) {
                ret.add(matrix[cStart][i]);
            }
            for (int i = cStart; i < cEnd; i++) {
                ret.add(matrix[i][rEnd]);
            }

            for (int i = rEnd; i > rStart; i--) {
                ret.add(matrix[cEnd][i]);
            }
            for (int i = cEnd; i > cStart; i--) {
                ret.add(matrix[i][rStart]);
            }
        }

        if (rStart == rEnd) {
            for (int i = cStart; i <= cEnd; i++) {
                ret.add(matrix[i][rStart]);
            }
        } else if (cStart == cEnd) {
            for (int i = rStart; i <= rEnd; i++) {
                ret.add(matrix[cStart][i]);
            }
        }

        return ret;
    }

    private static void test() {
        Utils.printTestListln(spiralOrder(new int[][]{}), new ArrayList<Integer>());

        Utils.printTestListln(spiralOrder(new int[][]{
            {1}
        }), Arrays.asList(1));

        Utils.printTestListln(spiralOrder(new int[][]{
            {1, 2, 3}
        }), Arrays.asList(1, 2, 3));

        Utils.printTestListln(spiralOrder(new int[][]{
            {1},
            {2},
            {3}
        }), Arrays.asList(1, 2, 3));

        Utils.printTestListln(spiralOrder(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        }), Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));
    }

    public static void main(String[] args) {
        test();
    }
}
