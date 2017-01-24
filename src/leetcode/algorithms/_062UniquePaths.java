package leetcode.algorithms;

/**
 * A robot is located at the top-left corner of a m x n grid (marked ‘Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the
 * bottom-right corner of the grid (marked ‘Finish' in the diagram below). How many possible unique paths are there?
 *
 * https://leetcode.com/problems/unique-paths
 * http://leetcode.com/2010/11/unique-paths.html
 * https://gist.github.com/zac-xin/4018342
 * https://gist.github.com/zac-xin/4018234
 * http://n00tc0d3r.blogspot.com/2013/07/unique-paths.html
 */
public class _062UniquePaths {
    public static void main(String[] args) {

    }
}

class Solution_UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        if(m==1 || n==1) return 1;
        // Create a 2D table to store results of subproblems
        int[][] count = new int[m][n];

        // Count of paths to reach any cell in first column is 1
        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }

        // Count of paths to reach any cell in first column is 1
        for (int j = 0; j < n; j++) {
            count[0][j] = 1;
        }

        // Calculate count of paths for other cells in bottom-up manner using
        // the recursive solution
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // By uncommenting the last part the code calculatest he total
                // possible paths if the diagonal Movements are allowed
                count[i][j] = count[i-1][j] + count[i][j-1]; //+ count[i-1][j-1];
            }

        }
        return count[m-1][n-1];
    }
}
