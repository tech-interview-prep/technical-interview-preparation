package facebook;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of
 * the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Algorithm:
 *     1) Calculate the medians m1 and m2 of the input arrays ar1[] and ar2[] respectively.
 *     2) If m1 and m2 both are equal then we are done.
 *         return m1 (or m2)
 *     3) If m1 is greater than m2, then median is present in one of the below two subarrays.
 *         a) From first element of ar1 to m1 (ar1[0...|_n/2_|])
 *         b) From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
 *     4) If m2 is greater than m1, then median is present in one of the below two subarrays.
 *         a) From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
 *         b) From first element of ar2 to m2 (ar2[0...|_n/2_|])
 *     5) Repeat the above process until size of both the subarrays becomes size of 2.
 *     6) If size of the two arrays is 2 then use below formula to get the median.
 *
 * Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays
 * http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
 * http://n00tc0d3r.blogspot.com/2013/04/median-of-two-sorted-arrays.html
 */
public class _004MedianOfTwoSortedArrays {
    public static void main(String[] args) {

    }
}

class Solution_MedianOfSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        int lengthA = A.length;
        int lengthB = B.length;

        if ((lengthA + lengthB) % 2 == 0) {
            double r1 = (double) findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB) / 2);
            double r2 = (double) findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB) / 2 + 1);
            return (r1 + r2) / 2;
        } else {
            return findMedianSortedArrays(A, 0, lengthA, B, 0, lengthB, (lengthA + lengthB + 1) / 2);
        }
    }

    public int findMedianSortedArrays(int A[], int startA, int endA, int B[], int startB, int endB, int k) {
        int n = endA - startA;
        int m = endB - startB;

        if (n <= 0) {
            return B[startB + k - 1];
        }
        if (m <= 0) {
            return A[startA + k - 1];
        }
        if (k == 1) {
            return A[startA] < B[startB] ? A[startA] : B[startB];
        }

        int midA = (startA + endA) / 2;
        int midB = (startB + endB) / 2;

        if (A[midA] <= B[midB]) {
            if (n / 2 + m / 2 + 1 >= k) {
                return findMedianSortedArrays(A, startA, endA, B, startB, midB, k);
            } else {
                return findMedianSortedArrays(A, midA + 1, endA, B, startB, endB, k - n / 2 - 1);
            }
        } else {
            if (n / 2 + m / 2 + 1 >= k) {
                return findMedianSortedArrays(A, startA, midA, B, startB, endB, k);
            } else {
                return findMedianSortedArrays(A, startA, endA, B, midB + 1, endB, k - m / 2 - 1);
            }
        }
    }
}
