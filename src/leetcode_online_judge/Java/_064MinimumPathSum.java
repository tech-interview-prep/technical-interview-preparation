package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _064MinimumPathSum {
    /*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
    sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
     */
    public static int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        return minPathSum(grid, 0, 0);
    }

    private static int minPathSum(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        return grid[i][j] + Math.min(minPathSum(grid, i + 1, j), minPathSum(grid, i, j + 1));
    }

    public static int minPathSumDP(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int[][] cost = new int[m][n];

        cost[m - 1][n - 1] = grid[m - 1][n - 1];
        for(int i = m - 2; i >= 0; i--) {
            cost[i][n - 1] = cost[i + 1][n - 1] + grid[i][n - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            cost[m - 1][i] = cost[m - 1][i + 1] + grid[m - 1][i];
        }

        for (int i = m -2 ; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                cost[i][j] = Math.min(cost[i + 1][j], cost[i][j + 1]) + grid[i][j];
            }
        }

        return cost[0][0];
    }

    public static int minPathSumDP2(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int[] level = new int[n];

        level[n - 1] = grid[m - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            level[i] = level[i + 1] + grid[m - 1][i];
        }

        for (int i = m - 2; i >= 0; i--) {
            level[n - 1] = level[n - 1] + grid[i][n - 1];
            for (int j = n - 2; j >= 0; j--) {
                level[j] = grid[i][j] + Math.min(level[j], level[j + 1]);
            }
        }

        return level[0];
    }

    private static void test() {
        Utils.printTestln(minPathSum(new int[][]{{1, 2}, {1, 1}}), 3);
        Utils.printTestln(minPathSum(new int[][]{
                {7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5},
                {9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6},
                {8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8},
                {6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4},
                {7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4},
                {9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9},
                {1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4},
                {3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2},
                {1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3},
                {5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7},
                {2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7},
                {0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9}
        }), 85);

        Utils.printTestln(minPathSumDP(new int[][]{{1, 2}, {1, 1}}), 3);
        Utils.printTestln(minPathSumDP(new int[][]{
                {7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5},
                {9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6},
                {8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8},
                {6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4},
                {7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4},
                {9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9},
                {1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4},
                {3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2},
                {1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3},
                {5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7},
                {2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7},
                {0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9}
        }), 85);

        Utils.printTestln(minPathSumDP2(new int[][]{{1, 2}, {1, 1}}), 3);
        Utils.printTestln(minPathSumDP2(new int[][]{
                {7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5},
                {9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6},
                {8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8},
                {6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4},
                {7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4},
                {9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9},
                {1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4},
                {3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2},
                {1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3},
                {5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7},
                {2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7},
                {0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9}
        }), 85);
    }

    public static void main(String[] args) {
        test();
    }
}
