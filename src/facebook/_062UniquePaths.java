package facebook;

/**
 * A robot is located at the top-left corner of a m x n grid (marked ‘Start’ in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the
 * bottom-right corner of the grid (marked ‘Finish’ in the diagram below). How many possible unique paths are there?
 *
 * https://leetcode.com/problems/unique-paths
 * http://leetcode.com/2010/11/unique-paths.html
 * https://gist.github.com/zac-xin/4018342
 * https://gist.github.com/zac-xin/4018234
 */
public class _062UniquePaths {
    public static void main(String[] args) {

    }
}

class Solution_UniquePaths {
    public int uniquePaths(int m, int n) {
        int matrix[][] = new int[m + 1][n + 1];

        return backtrack(matrix, 0 , 0, m, n);
    }

    public int backtrack(int[][] matrix, int c, int r, int m, int n) {
        if (c == m - 1 && r == n - 1) {
            return 1;
        }
        if (c >= m || r >= n) {
            return 0;
        }

        if (matrix[c + 1][r] == 0) {
            matrix[c + 1][r] = backtrack(matrix, c + 1, r, m, n);
        }
        if (matrix[c][r + 1] == 0) {
            matrix[c][r + 1] = backtrack(matrix, c, r + 1, m, n);
        }

        return matrix[c + 1][r] + matrix[c][r + 1];

    }
}
