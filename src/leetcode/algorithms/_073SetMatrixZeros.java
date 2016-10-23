package leetcode.algorithms;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _073SetMatrixZeros {
    /*
    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

    Follow up:
    Did you use extra space?
    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?
    */
    public static void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }

        int i = 0, j = 0, row, column, m = matrix.length, n = matrix[0].length;

        for (i = 0; i < m; i++) {
            for (j = 0; j < n && matrix[i][j] != 0; j++);
            if (j < n) {
                break;
            }
        }

        if (i == m) {
            return;
        }

        row = i;
        column = j;

        for (; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[row][j] = 0;
                    matrix[i][column] = 0;
                }
            }
        }

        for (i = 0; i < m; i++) {
            if (i != row && matrix[i][column] == 0) {
                for (j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (j = 0; j < n; j++) {
            if (matrix[row][j] == 0) {
                for (i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (j = 0;  j < n; j++) {
            matrix[row][j] = 0;
        }
    }

    private static void test(int[][] matrix) {
        setZeroes(matrix);
        Utils.print2DArrayln(matrix);
    }


    private static void test() {
        test(new int[][] {{1, 0}});
        test(new int[][] {{1}, {0}});
        test(new int[][] {{1, 2, 3, 4}, {5, 0, 5, 2}, {8, 9, 2, 0}, {5, 7, 2, 1}});
    }

    public static void main(String[] args) {
        test();
    }
}
