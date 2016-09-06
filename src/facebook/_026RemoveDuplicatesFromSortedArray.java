/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * For example,
 *   Given input array A = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't
 * matter what you leave beyond the new length.
 */

package facebook;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @author bkoteshwarreddy
 */
public class _026RemoveDuplicatesFromSortedArray {
  public static void main(String[] args) {
    Solution_RemoveDuplicatesFromSortedArray sol = new Solution_RemoveDuplicatesFromSortedArray();
    
    int[] A = new int[]{1, 1, 2};
    int length = sol.removeDuplicates(A);
    for (int i = 0; i < length; i++) {
      System.out.print(A[i] + "\t");
    }

    System.out.println();
  }
}

class Solution_RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] A) {
    if (A.length == 0) {
      return 0;
    }

    int start, index, pre;

    for (start = 1, index = 1, pre = A[0]; index < A.length; index++) {
      if (A[index] != pre) {
        A[start] = A[index];
        pre = A[start];
        start++;
      }
    }

    return start;
  }
}
