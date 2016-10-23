package leetcode.algorithms;

import utils.Utils;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author bkoteshwarreddy
 */

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _005LongestPalindromicSubstring {
    /*
     * Given a string S, find the longest palindromic substring in S. You may assume that
     * the maximum length of S is 1000, and there exists one unique longest palindromic substring
     */

    public static String longestPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int maxLength = 1, start = 0, l = s.length();

        isPalindrome[l - 1][l - 1] = true;
        for (int i = 0; i < l - 1 ; i++) {
            isPalindrome[i][i] = true;
            isPalindrome[i + 1][i] = true;
        }

        for (int i = 1; i < l; i++) {
            for (int j = 0; j < l - i ; j++) {
                if ((isPalindrome[j][j + i] = isPalindrome[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i)) && i + 1 > maxLength) {
                    maxLength = i + 1;
                    start = j;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    private static void test() {
        Utils.printTestln(longestPalindrome("abb"), "bb");
        Utils.printTestln(longestPalindrome("ccd"), "cc");
        Utils.printTestln(longestPalindrome("bananas"), "anana");
    }

    public static void main(String[] args) {
        test();
    }
}
