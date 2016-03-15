package leetcode_online_judge;

import utils.Utils;

public class ValidPalindrome {
    /*
    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    For example,
    "A man, a plan, a canal: Panama" is a palindrome.
    "race a car" is not a palindrome.

    Note:
    Have you consider that the string might be empty? This is a good question to ask during an interview.

    For the purpose of this problem, we define empty string as valid palindrome.
     */
    public static boolean isPalindrome(String s) {
        int  start =  0, end = s.length() - 1;
        char charAtStart, charAtEnd;
        while (start < end) {
            if (!isAlphanumeric(charAtStart = s.charAt(start))) {
                start++;
            }

            if (!isAlphanumeric(charAtEnd = s.charAt(end))) {
                end--;
            }

            if (isAlphanumeric(charAtStart) && isAlphanumeric(charAtEnd)) {
                if (charAtStart != charAtEnd && charAtStart - 'A' + 'a' != charAtEnd && charAtStart + 'A' - 'a' != charAtEnd) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    private static boolean isAlphanumeric(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    private static void test() {
        Utils.printTestln(isPalindrome("A man, a plan, a canal: Panama"), true);
        Utils.printTestln(isPalindrome("race a car"), false);
    }

    public static void main(String[] args) {
        test();
    }

}
