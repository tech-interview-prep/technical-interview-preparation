package leetcode_online_judge.Java;

import utils.Utils;

public class _062UniquePaths {
    /*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
    corner of the grid (marked 'Finish' in the diagram below).

    How many possible unique paths are there?


    Above is a 3 x 7 grid. How many possible unique paths are there?

    Note: m and n will be at most 100.
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
