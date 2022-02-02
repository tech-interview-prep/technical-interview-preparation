package leetcode.algorithms;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _009PalindromeNumber {
    /*
     * Determine whether an integer is a palindrome. Do this without extra space.
     *
     * Some hints:
     * Could negative integers be palindromes? (ie, -1)
     *
     * If you are thinking of converting the integer to string, note the restriction of using
     * extra space.
     *
     * You could also try reversing an integer. However, if you have solved the problem
     * "Reverse Integer", you know that the reversed integer might overflow. How would you handle
     * such case?
     *
     * There is a more generic way of solving this problem.
     *
     */

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int revertedNumber = 0;
        int num = x;

        while (num > 0) {
            revertedNumber = ( revertedNumber * 10 ) + num % 10;
            num = num / 10;
        }

        return x == revertedNumber;
    }

    private static void test() {
        Utils.printTestln(isPalindrome(12345), false);
        Utils.printTestln(isPalindrome(123454321), true);
    }

    public static void main(String[] args) {
        test();
    }
}
