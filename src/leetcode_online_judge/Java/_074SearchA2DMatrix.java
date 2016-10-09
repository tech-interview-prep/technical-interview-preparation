package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _074SearchA2DMatrix {
    /*
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
    For example,

    Consider the following matrix:

    [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    Given target = 3, return true.
    */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1, iMid = mid / n, jMid = mid % n;
            if (matrix[iMid][jMid] == target) {
                return true;
            }

            if (matrix[iMid][jMid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    private static void test() {
        Utils.printTestln(searchMatrix(new int[][] {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50},
        }, 3), true);
    }

    public static void main(String[] args) {
        test();
    }
}
