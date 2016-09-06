package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _029DivideTwoIntegers {
    /*
    Divide two integers without using multiplication, division and mod operator.
     */
    public static int divide(int dividend, int divisor) {
        boolean negative = (dividend ^ divisor) < 0;
        long div = dividend < 0 ? -(long)dividend : dividend;
        long dis = divisor < 0 ? -(long)divisor : divisor;

        int quotient = 0, shift;
        while (dis <= div) {
            for (shift = 1; (dis << shift) > 0 && (dis << shift) <= div; shift++);
            quotient += 1 << (shift - 1);
            div -= (dis << (shift - 1));
        }
        return negative ? -quotient : quotient;
    }

    private static void test() {
        Utils.printTestln(divide(10, 3), 3);
        Utils.printTestln(divide(10, -3), -3);
        Utils.printTestln(divide(Integer.MAX_VALUE, 2), Integer.MAX_VALUE >> 1);
        Utils.printTestln(divide(Integer.MAX_VALUE, Integer.MIN_VALUE), 0);
        Utils.printTestln(divide(Integer.MIN_VALUE, Integer.MIN_VALUE), 1);
    }

    public static void main(String[] args) {
        test();
    }
}
