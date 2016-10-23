package leetcode.algorithms;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _048RotateImage {
    /*
    You are given an n x n 2D matrix representing an image.

    Rotate the image by 90 degrees (clockwise).

    Follow up:
    Could you do this in-place?
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n >> 1); i++) {
            for (int j = i; j < n - i - 1; j++) {
                swap(matrix, i, j, j, n - 1 - i);
                swap(matrix, i, j, n - 1 - i, n - 1 - j);
                swap(matrix, i, j, n - 1 - j, i);
            }
        }
    }

    private static void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int tmp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = tmp;
    }

    private static void test() {
        int[][] matrix = new int[][] {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        rotate(matrix);
        Utils.print2DArrayln(matrix);
    }

    public static void main(String[] args) {
        test();
    }
}
