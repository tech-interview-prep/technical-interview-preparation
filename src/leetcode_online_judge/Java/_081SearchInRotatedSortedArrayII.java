package leetcode_online_judge.Java;

import utils.Utils;

public class _081SearchInRotatedSortedArrayII {
    /*
    Follow up for "Search in Rotated Sorted Array":
    What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?

    Write a function to determine if a given target is in the array.
    */
    public static boolean search(int[] A, int target) {
        int start = 0, end = A.length - 1, mid;

        while (start <= end) {
            while (start < end && A[start] == A[end]) {
                start++;
            }
            mid = (start + end) >>> 1;

            if (A[mid] == target || A[start] == target || A[end] == target) {
                return true;
            }

            if (A[mid] < target) {
                if (A[start] < A[end] || target < A[end] || A[mid] > A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (A[start] < A[end] || target > A[end] || A[mid] <= A[end]) {
                    end = mid - 1;
                } else {
                    start  = mid + 1;
                }
            }
        }
        return false;
    }

    private static void test() {
//        Utils.printTestln(search(new int[]{1,1,3,1}, 2), false);
//        Utils.printTestln(search(new int[]{1,1,3,1}, 2), false);
//        Utils.printTestln(search(new int[]{0,0,1,1,2,0}, 2), true);
        Utils.printTestln(search(new int[]{1,2,0,1,1,1}, 0), true);
//        Utils.printTestln(search(new int[]{4,5,6,7,0,1,2}, 0), true);
//        Utils.printTestln(search(new int[]{3,4,5,1, 2}, 3), true);
//        Utils.printTestln(search(new int[]{3,4,5,1, 2}, 2), true);
//        Utils.printTestln(search(new int[]{3,4,5,1, 2}, 11), false);
    }

    public static void main(String[] args) {
        test();
    }
}
