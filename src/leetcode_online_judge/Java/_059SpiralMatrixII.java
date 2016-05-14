package leetcode_online_judge.Java;

import utils.Utils;

public class _059SpiralMatrixII {
    /*
    Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

    For example,
    Given n = 3,

    You should return the following matrix:
    [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
    ]
    */
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        generateMatrix(matrix, n, 1, 1);

        return matrix;
    }

    private static void generateMatrix(int[][] matrix, int n, int level, int start) {
        if (n == 0) {
            return;
        }

        if (level == ((n + 1) >> 1)) {
            if ((n & 1) == 1) {
                matrix[level - 1][level - 1] = start;
            } else {
                matrix[level - 1][level - 1] = start;
                matrix[level - 1][level] = start + 1;
                matrix[level][level] = start + 2;
                matrix[level][level - 1] = start + 3;
            }
            return;
        }

        for (int i = level - 1; i < n - level; i++, start++) {
            matrix[level - 1][i] = start;
            matrix[i][n - level] =  start + n - (level << 1) + 1;
            matrix[n - level][n - i - 1] =  start + ((n - (level << 1) + 1) << 1);
            matrix[n - i - 1][level - 1] =  start + (n - (level << 1) + 1) * 3;
        }

//        for (int i = level - 1; i < n - level; i++, start++) {
//            matrix[level - 1][i] = start;
//        }
//
//        for (int i = level - 1; i < n - level; i++, start++) {
//            matrix[i][n - level] =  start;
//        }
//
//        for (int i = n - level; i > level - 1; i--, start++) {
//            matrix[n - level][i] =  start;
//        }
//
//        for (int i = n - level; i > level - 1; i--, start++) {
//            matrix[i][level - 1] =  start;
//        }

        generateMatrix(matrix, n, level + 1, start + (n - (level << 1) + 1) * 3);
    }

    private static void test() {
        for (int[] row : generateMatrix(5)) {
            Utils.printArrayln(row);
        }
    }

    public static void main(String[] args) {
        test();
    }
}
