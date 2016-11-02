package facebook;

import utils.Utils;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * http://n00tc0d3r.blogspot.com/2013/05/remove-element-from-arraylist.html
 */
public class _080RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        Solution_RemoveDuplicatesFromSortedArrayII sol = new Solution_RemoveDuplicatesFromSortedArrayII();
        int[] A = new int[] {1, 1, 1, 2, 2, 3};
        Utils.printTestln(sol.removeDuplicates(A), 5);

        Utils.printTestln(sol.removeDuplicates(new int[] {1}), 1);
        Utils.printTestln(sol.removeDuplicates(new int[0]), 0);
    }
}

class Solution_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        int start = 0, index = A.length == 0 ? 0 : 1, count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[start]) {
                count++;
            } else {
                start = i;
                count = 1;
            }

            if (count <= 2) {
                A[index] = A[i];
                index++;
            }
        }

        return index;
    }
}
