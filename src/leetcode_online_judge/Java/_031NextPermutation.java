package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _031NextPermutation {
    /*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

    The replacement must be in-place, do not allocate extra memory.

    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
    1,2,3 ? 1,3,2
    3,2,1 ? 1,2,3
    1,1,5 ? 1,5,1
     */
    public static void nextPermutation(int[] num) {
        int rindex, index;
        for (rindex = num.length - 1; rindex > 0 && num[rindex] <= num[rindex - 1]; rindex--);
        if (rindex > 0) {
            for (index = num.length - 1; num[index] <= num[rindex - 1]; index--);
            swap(num, index, rindex - 1);
        }
        for (index = rindex; index < rindex + ((num.length - rindex) >> 1); index++) {
            swap(num, index, num.length - index + rindex - 1);
        }
    }

    private static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    private static void test() {
        int[] num = new int[]{1, 2, 3};
        nextPermutation(num);
        Utils.printArrayln(num);
    }

    public static void main(String[] args) {
        test();
    }
}
