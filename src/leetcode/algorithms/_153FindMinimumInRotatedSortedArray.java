package leetcode.algorithms;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _153FindMinimumInRotatedSortedArray {
    /*
    Find Minimum in Rotated Sorted Array
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    Find the minimum element.

    You may assume no duplicate exists in the array.
     */
    public int findMin(int[] num) {
        int[] A = num;
        for (int l = 0, r = num.length - 1; l <= r;)
            if (A[l] <= A[r]) {
                return A[l];
            } else {
                int m = l + (r - l) / 2;
                if (A[m] < A[l]) {
                    if (A[m - 1] < A[m]) {
                        r = m - 1;
                    } else {
                        return A[m];
                    }
                } else {
                    l = m + 1;
                }
            }
        return A[0];
    }
}
