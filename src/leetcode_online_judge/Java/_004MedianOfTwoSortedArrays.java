package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * @author bkoteshwarreddy
 */
/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _004MedianOfTwoSortedArrays {
    /*
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.Find the median
     * of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     *
     * Example 1:
     *      nums1 = [1, 3]
     *      nums2 = [2]
     *
     *      The median is 2.0
     *
     * Example 2:
     *      nums1 = [1, 2]
     *      nums2 = [3, 4]
     *
     *      The median is (2 + 3)/2 = 2.5
     *
     * http://ocw.alfaisal.edu/NR/rdonlyres/Electrical-Engineering-and-Computer-Science/6-046JFall-2005/30C68118-E436-4FE3-8C79-6BAFBB07D935/0/ps9sol.pdf
     *
     */
    public static double findMedianSortedArrays(int A[], int B[]) {
        int n = A.length;
        int m = B.length;
        // the following call is to make sure len(A) <= len(B).
        // yes, it calls itself, but at most once, shouldn't be
        // consider a recursive solution
        if (n > m)
            return findMedianSortedArrays(B, A);

        // now, do binary search
        int k = (n + m - 1) / 2;
        int l = 0, r = Math.min(k, n); // r is n, NOT n-1, this is important!!
        while (l < r) {
            int midA = (l + r) / 2;
            int midB = k - midA;
            if (A[midA] < B[midB])
                l = midA + 1;
            else
                r = midA;
        }

        // after binary search, we almost get the median because it must be between
        // these 4 numbers: A[l-1], A[l], B[k-l], and B[k-l+1]

        // if (n+m) is odd, the median is the larger one between A[l-1] and B[k-l].
        // and there are some corner cases we need to take care of.
        int a = Math.max(l > 0 ? A[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? B[k - l] : Integer.MIN_VALUE);
        if (((n + m) & 1) == 1)
            return (double) a;

        // if (n+m) is even, the median can be calculated by
        //      median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
        // also, there are some corner cases to take care of.
        int b = Math.min(l < n ? A[l] : Integer.MAX_VALUE, k - l + 1 < m ? B[k - l + 1] : Integer.MAX_VALUE);
        return (a + b) / 2.0;
    }

    private static void test() {
        Utils.printTestln(findMedianSortedArrays(new int[] {1, 3, 5, 8, 22}, new int[] {4, 7, 9, 11, 25}), 7.5);
        Utils.printTestln(findMedianSortedArrays(new int[] {}, new int[] {4}), 4.0);
        Utils.printTestln(findMedianSortedArrays(new int[] {}, new int[] {4, 5}), 4.5);
        Utils.printTestln(findMedianSortedArrays(new int[] {1}, new int[] {2, 3, 4}), 2.5);
        Utils.printTestln(findMedianSortedArrays(new int[] {2, 3, 4}, new int[] {1}), 2.5);
        Utils.printTestln(findMedianSortedArrays(new int[] {}, new int[] {1, 2, 3, 4, 5}), 3.0);
    }

    public static void main(String[] args) {
        test();
    }
}


