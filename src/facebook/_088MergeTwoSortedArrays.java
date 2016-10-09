package facebook;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *      You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional
 *      elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 * https://leetcode.com/problems/merge-sorted-array/
 *
 *  http://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/
 *       https://gist.github.com/zac-xin/3943308
 *
 * The key to solve this problem is moving element of A and B backwards.
 * If B has some elements left after A is done, also need to handle that case.
 */
public class _088MergeTwoSortedArrays {
    public static void main(String[] args) {
    }
}

class Solution_MergeTwoSortedArrays {
    public void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexMerged = lastB + lastA - 1; /* Index of last location of merged array */
        int indexA = lastA - 1; /* Index of last element in array b */
        int indexB = lastB - 1; /* Index of last element in array a */

        /* Merge a and b, starting from the last element in each */
        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) { /* end of a is bigger than end of b */
                a[indexMerged] = a[indexA]; // copy element
                indexA--;
            } else {
                a[indexMerged] = b[indexB]; // copy element
                indexB--;
            }
            indexMerged--; // move indices
        }
    }

    public void merge(int a[], int m, int b[], int n) {
        int i, j;
        for (i = m - 1, j = n - 1; i >= 0 && j >= 0;) {
            if (a[i] < b[j]) {
                a[i + j + 1] = b[j];
                j--;
            } else {
                a[i + j + 1] = a[i];
                i--;
            }
        }

        for (; i >= 0; i--) {
            a[i + j + 1] = a[i];
        }

        for (; j >= 0; j--) {
            a[i + j + 1] = b[j];
        }
    }
}
