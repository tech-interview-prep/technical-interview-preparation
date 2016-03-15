package leetcode_online_judge;

import utils.Utils;

public class PalindromeNumber {
    /*
    Determine whether an integer is a palindrome. Do this without extra space.

    Some hints:
    Could negative integers be palindromes? (ie, -1)

    If you are thinking of converting the integer to string, note the restriction of using extra space.

    You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

    There is a more generic way of solving this problem.
    */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int newX = 0;
        for (int copyX = x; copyX > 0; newX = newX * 10 + copyX % 10, copyX /= 10);

        return x == newX;
    }

    private static void test() {
        Utils.printTestln(isPalindrome(12345), false);
        Utils.printTestln(isPalindrome(123454321), true);
    }

    public static void main(String[] args) {
        test();
    }
}
