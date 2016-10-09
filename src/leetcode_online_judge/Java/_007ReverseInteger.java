package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/reverse-integer/
 * @author bkoteshwarreddy
 */

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _007ReverseInteger {
    /*
     * Reverse digits of an integer.
     *
     *      Example1: x = 123, return 321
     *      Example2: x = -123, return -321
     *
     * click to show spoilers.
     *
     * Have you thought about this?
     * Here are some good questions to ask before coding. Bonus points for you if you have
     * already thought through this!
     *
     * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
     *
     * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit
     * integer, then the reverse of 1000000003 overflows. How should you handle such cases?
     *
     * Throw an exception? Good, but what if throwing an exception is not an option? You would
     * then have to re-design the function (ie, add an extra parameter).
     *
     */

    public static int reverse(int x) {
        int newValue = 0;

        while (x != 0) {
            int mod = x % 10;
            newValue = newValue * 10 + mod;
            x /= 10;
        }
        return newValue;
    }

    private static void test() {
        Utils.printTestln(reverse(123), 321);
        Utils.printTestln(reverse(-123), -321);
    }

    public static void main(String[] args) {
        test();
    }
}
