package leetcode_online_judge.Java;

import utils.Utils;

public class _136SingleNumber {
    /*
    Given an array of integers, every element appears twice except for one. Find that single one.

    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     */
    public static int singleNumber(int[] A) {
        int num = 0;

        for (int i = 0; i < A.length; i++) {
            num ^= A[i];
        }
        return num;
    }

    private static void test() {
        Utils.printTestln(singleNumber(new int[]{1, 3, 5, 6, 5, 3, 1}), 6);

    }

    public static void main(String[] args) {
        test();
    }

}
