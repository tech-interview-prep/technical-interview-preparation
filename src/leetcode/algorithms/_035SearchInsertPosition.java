package leetcode.algorithms;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _035SearchInsertPosition {
    /*
    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    Here are few examples.
    [1,3,5,6], 5 ? 2
    [1,3,5,6], 2 ? 1
    [1,3,5,6], 7 ? 4
    [1,3,5,6], 0 ? 0
     */
    public static int searchInsert(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (A[mid] == target) {
                return mid;
            }

            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    private static void test() {
        int[] A = new int[] {1, 3, 5, 6};
        Utils.printTestln(searchInsert(A, 5), 2);
        Utils.printTestln(searchInsert(A, 2), 1);
        Utils.printTestln(searchInsert(A, 7), 4);
        Utils.printTestln(searchInsert(A, 0), 0);
    }

    public static void main(String[] args) {
        test();
    }
}
