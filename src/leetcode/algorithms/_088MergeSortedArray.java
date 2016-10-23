package leetcode.algorithms;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _088MergeSortedArray {
    /*
    Given two sorted integer arrays A and B, merge B into A as one sorted array.

    Note:
    You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A
    and B are m and n respectively.
    */
    public static void merge(int A[], int m, int B[], int n) {
        int i, j;
        for (i = m - 1, j = n - 1; i >= 0 && j >= 0;) {
            if (A[i] < B[j]) {
                A[i + j + 1] = B[j];
                j--;
            } else {
                A[i + j + 1] = A[i];
                i--;
            }
        }

        for (; i >= 0; i--) {
            A[i + j + 1] = A[i];
        }

        for (; j >= 0; j--) {
            A[i + j + 1] = B[j];
        }
    }
}
