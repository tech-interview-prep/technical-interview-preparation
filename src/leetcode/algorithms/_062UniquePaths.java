package leetcode.algorithms;

import utils.Utils;

/**
 * https://leetcode.com/problems/unique-paths/
 *
 * @author bkoteshwarreddy
 */
public class _062UniquePaths {
    /**
     * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
     * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either
     * down or right at any point in time.
     *
     * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach
     * the bottom-right corner.
     *
     * The test cases are generated so that the answer will be less than or equal to 2 * 109.
     *
     * Constraints:
     * 1 <= m, n <= 100
     */
    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    public static int uniquePathsDP(int m, int n) {
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = n - 2; j >= 0; j--) {
                num[j] += num[j + 1];
            }
        }
        return num[0];
    }

    private static void test() {
        Utils.printTestln(uniquePaths(2, 2), 2);
        Utils.printTestln(uniquePaths(23, 12), 193536720);

        System.out.println("\n>>>Below is the DP solution:\n");

        Utils.printTestln(uniquePathsDP(2, 2), 2);
        Utils.printTestln(uniquePathsDP(23, 12), 193536720);
    }

    public static void main(String[] args) {
        test();
    }
}
