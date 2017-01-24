package leetcode.algorithms;

import utils.Utils;

/**
 * @author bkoteshwarreddy
 */
public class FirstMissingPositive {
    /*
    Given an unsorted integer array, find the first missing positive integer.

    For example,
    Given [1,2,0] return 3,
    and [3,4,-1,1] return 2.

    Your algorithm should run in O(n) time and uses constant space.
    */
    public static int firstMissingPositive(int[] A) {
        for (int i = 1; i <= A.length; i++) {
            int index = i, pre = -1;

            while (index > 0 && index <= A.length && A[index - 1] != index ) {
                int tmp = A[index - 1];
                A[index - 1] = pre;
                pre = index = tmp;
            }
        }

        int fMP;
        for (fMP = 1; fMP <= A.length && A[fMP - 1] == fMP; fMP++);

        return fMP;
    }

    private static void test() {
        Utils.printTestln(firstMissingPositive(new int[] {1, 1}), 2);
        Utils.printTestln(firstMissingPositive(new int[] {1, 2, 0}), 3);
        Utils.printTestln(firstMissingPositive(new int[] {3, 4, -1, 1}), 2);
    }

    public static void main(String[] args) {
        test();
    }
}
