package facebook;

import utils.Utils;

/**
 * Follow up for "Unique Paths":
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *     [
 *         [0,0,0],
 *         [0,1,0],
 *         [0,0,0]
 *     ]
 *
 * The total number of unique paths is 2.
 *
 * Note: m and n will be at most 100.
 *
 * https://leetcode.com/problems/unique-paths-ii
 * http://n00tc0d3r.blogspot.com/2013/07/unique-paths.html
 */
public class _063UniquePathsII {
    public static void main(String[] args) {
        Solution_UniquePathsII sol = new Solution_UniquePathsII();
        int[][] grid = new int[][] {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        Utils.printTestln(sol.uniquePathsWithObstacles(grid), 2);

        System.out.println("\n>>>Below is the DP version:");

        Utils.printTestln(sol.uniquePathsWithObstaclesDP(grid), 2);
    }
}

class Solution_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePathsWithObstacles(obstacleGrid, 0, 0);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int i, int j) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        if (i == m || j == n || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        return uniquePathsWithObstacles(obstacleGrid, i + 1, j) + uniquePathsWithObstacles(obstacleGrid, i, j + 1);
    }

    public int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] num = new int[n + 1];
        num[n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    num[j] = 0;
                } else {
                    num[j] += num[j + 1];
                }
            }
        }
        return num[0];
    }

    public int uniquePathsWithObstaclesDP2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int matrix[][] = new int[m][n];

        for (int i = n - 1; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 1) {
                break;
            }
            matrix[m - 1][i] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 1) {
                break;
            }
            matrix[i][n - 1] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = matrix[i + 1][j] + matrix[i][j + 1];
                }
            }
        }

        return matrix[0][0];
    }
}
