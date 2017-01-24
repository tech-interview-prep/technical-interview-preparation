package leetcode.algorithms;

/**
 * Given two sparse matrices A and B, return the result of AB.
 *
 * You may assume that A's column number is equal to B's row number.
 *
 * Example:
 *
 * A = [
 *     [ 1, 0, 0],
 *     [-1, 0, 3]
 * ]
 *
 * B = [
 *     [ 7, 0, 0 ],
 *     [ 0, 0, 0 ],
 *     [ 0, 0, 1 ]
 * ]
 *
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *                 | 0 0 1 |
 *
 * https://leetcode.com/problems/sparse-matrix-multiplication/
 */
public class SparseMatrixMultiplication {
}

class Solution_SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;
        int[][] res = new int[m][l];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < l; ++k) {
                        if (B[j][k] != 0) {
                            res[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }

        return res;
    }
}
