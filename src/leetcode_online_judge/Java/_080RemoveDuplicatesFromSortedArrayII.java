package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _080RemoveDuplicatesFromSortedArrayII {
    /*
    Follow up for "Remove Duplicates":
    What if duplicates are allowed at most twice?

    For example,
    Given sorted array A = [1,1,1,2,2,3],

    Your function should return length = 5, and A is now [1,1,2,2,3].
     */
    public static int removeDuplicates(int[] A) {
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

    private static void test() {
        int[] A = new int[] {1, 1, 1, 2, 2, 3};
        Utils.printTestln(removeDuplicates(A), 5);

        Utils.printTestln(removeDuplicates(new int[] {1}), 1);
        Utils.printTestln(removeDuplicates(new int[0]), 0);
    }

    public static void main(String[] args) {
        test();
    }
}
