package leetcode_online_judge;

import utils.Utils;

public class SingleNumber {
    /*
    Given an array of integers, every element appears twice except for one. Find that single one.

    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     */
    public static int singleNumber(int[] A) {
        int sum = 0;
        for(int i : A) {
            sum ^= i;
        }

        return sum;
    }

    private static void test() {
        Utils.printTestln(singleNumber(new int[]{1, 3, 5, 6, 5, 3, 1}), 6);

    }

    public static void main(String[] args) {
        test();
    }

}
