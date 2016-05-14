package leetcode_online_judge.Java;

import utils.Utils;

public class _033SearchInRotatedSortedArray {
    /*
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    You are given a target value to search. If found in the array return its index, otherwise return -1.

    You may assume no duplicate exists in the array.
     */
    public static int search(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] < target) {
                if (A[mid] > A[start]) {
                    start = mid + 1;
                } else {
                    if (target == A[end]) {
                        return end;
                    }
                    if (target < A[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            } else {
                if (A[mid] < A[start]) {
                    end = mid - 1;
                } else {
                    if (A[start] == target) {
                        return start;
                    }
                    if (A[start] > target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }

        return -1;
    }

    private static void test() {
        Utils.printTestln(search(new int[]{3, 1}, 3), 0);
        Utils.printTestln(search(new int[]{3, 1}, 1), 1);
        Utils.printTestln(search(new int[]{1}, 2), -1);
        Utils.printTestln(search(new int[]{1, 3}, 0), -1);
        Utils.printTestln(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7), 3);
        Utils.printTestln(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2), 6);
        Utils.printTestln(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4), 0);
    }

    public static void main(String[] args) {
        test();
    }
}
