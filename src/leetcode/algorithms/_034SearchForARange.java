package leetcode.algorithms;

import utils.Utils;

/**
 * @author bkoteshwarreddy
 */
public class _034SearchForARange {
    /*
    Given a sorted array of integers, find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].

    For example,
    Given [5, 7, 7, 8, 8, 10] and target value 8,
    return [3, 4].
     */
    public static int[] searchRange(int[] A, int target) {
        int[] ret = new int[] { -1, - 1};

        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (A[mid] == target && (mid == 0 || A[mid - 1] < target)) {
                ret[0] = mid;
                break;
            }

            if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (ret[0] == -1) {
            return ret;
        }

        start = ret[0];
        end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (A[mid] == target && (mid == A.length - 1 || A[mid + 1] > target)) {
                ret[1] = mid;
                return ret;
            }

            if (A[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ret;
    }

    private static void test() {
        Utils.printArrayln(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8));
    }

    public static void main(String[] args) {
        test();
    }
}
