package leetcode_online_judge;

import utils.Utils;

public class MedianOfTwoSortedArrays {
    /*
    There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
    The overall run time complexity should be O(log (m+n)).
     */
    public static double findMedianSortedArrays(int A[], int B[]) {
        int mid = (A.length + B.length) >>> 1;

        if (((A.length + B.length) & 1) == 1) {
            return findKthSortedArrays( mid + 1, A, 0, A.length, B, 0, B.length);
        }

        return (findKthSortedArrays( mid, A, 0, A.length, B, 0, B.length)
                + findKthSortedArrays( mid + 1, A, 0, A.length, B, 0, B.length)) / 2.0;
    }

    private static int findKthSortedArrays(int k, int[] A, int s1, int e1, int[] B, int s2, int e2) {
        if (e1 == s1) {
            return B[s2 + k - 1];
        }

        if (e2 == s2) {
            return A[s1 + k - 1];
        }

        if (k == 1) {
            return Math.min(A[s1], B[s2]);
        }

        int k1 = (k - 1) >> 1, k2 = k - 1 - k1 - 1;
        if (k1 > e1 - s1 - 1) {
            k1 = e1 - s1 - 1;
            k2 = k - 1 - k1 - 1;
        } else if (k2 > e2 - s2 - 1) {
            k2  = e2 - s2 - 1;
            k1 = k - 1 - k2 - 1;
        }

        int m1 = s1 + k1, m2 = s2 + k2;

        if (A[m1] == B[m2]) {
            return A[k1];
        }

        if (A[m1] < B[m2]){
            return findKthSortedArrays(k - k1 - 1, A, s1 + k1 + 1, e1, B, s2, s2 + k2 + 1);
        }

        return findKthSortedArrays(k - k2 - 1, A, s1, s1 + k1 + 1, B, s2 + k2 + 1, e2);
    }

    private static void test() {
        Utils.printTestln(findMedianSortedArrays(new int[]{1, 3, 5, 8, 22}, new int[]{4, 7, 9, 11, 25}), 7.5);
        Utils.printTestln(findMedianSortedArrays(new int[]{}, new int[]{4}), 4.0);
        Utils.printTestln(findMedianSortedArrays(new int[]{}, new int[]{4, 5}), 4.5);
        Utils.printTestln(findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4}), 2.5);
        Utils.printTestln(findMedianSortedArrays(new int[]{2, 3, 4}, new int[]{1}), 2.5);
        Utils.printTestln(findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3, 4, 5}), 3.0);
    }

    public static void main(String[] args) {
        test();
    }
}


