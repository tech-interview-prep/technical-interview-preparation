package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _075SortColors {
    /*
    Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
    with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

    Note:
    You are not suppose to use the library's sort function for this problem.

    Follow up:
    A rather straight forward solution is a two-pass algorithm using counting sort.
    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then
    1's and followed by 2's.

    Could you come up with an one-pass algorithm using only constant space?
    */
    public static void sortColors(int[] A) {
        for (int index = 0, start = 0, end = A.length - 1; index <= end;) {
            if (A[index] == 0) {
                A[start++] = 0;
                if (index >= start) {
                    A[index] = 1;
                }
                index++;
            } else if (A[index] == 2) {
                A[index] = A[end];
                A[end--] = 2;
            } else {
                index++;
            }
        }
    }

    private static void test() {
        int[] A = new int[] {1, 1, 0, 1, 2, 0, 1, 2, 0, 0, 1};
        sortColors(A);
        Utils.printArrayln(A);
    }

    public static void main(String[] args) {
        test();
    }
}
