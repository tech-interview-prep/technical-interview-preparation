package leetcode.algorithms;

import utils.Utils;

/**
 * @author bkoteshwarreddy
 */
public class _066PlusOne {
    /*
    Given a number represented as an array of digits, plus one to the number.
     */
    public static int[] plusOne(int[] digits) {
        int[] sum;
        int i;
        for (i = digits.length - 1; i >= 0 && digits[i] == 9; i--);
        if (i == -1) {
            sum = new int[digits.length + 1];
            sum[0] = 1;
        } else {
            sum = new int[digits.length];
            System.arraycopy(digits, 0, sum, 0, i + 1);
            sum[i]++;
        }

        return sum;
    }

    private static void test() {
        Utils.printArrayln(plusOne(new int[] {1, 2, 8}));
        Utils.printArrayln(plusOne(new int[] {9, 9}));
    }

    public static void main(String[] args) {
        test();
    }

}
