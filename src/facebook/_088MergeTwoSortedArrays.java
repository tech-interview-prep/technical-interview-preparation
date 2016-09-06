  /*
  Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

  Note:
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional
    elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

  Link: https://leetcode.com/problems/merge-sorted-array/
  Link: http://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/
  Link: https://gist.github.com/zac-xin/3943308

  The key to solve this problem is moving element of A and B backwards.
  If B has some elements left after A is done, also need to handle that case.
  */
package facebook;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * @author bkoteshwarreddy
 */
public class _088MergeTwoSortedArrays {
  public static void main(String[] args) {
    Solution_MergeTwoSortedArrays sol = new Solution_MergeTwoSortedArrays();
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

  public void merge(int A[], int m, int B[], int n) {
        int i, j;
        for(i = m - 1, j = n - 1; i >= 0 && j >= 0;) {
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
