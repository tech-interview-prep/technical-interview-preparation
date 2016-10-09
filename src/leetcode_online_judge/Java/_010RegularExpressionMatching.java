package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * @author bkoteshwarreddy
 */
public class _010RegularExpressionMatching {
    /**
     * Implement regular expression matching with support for '.' and '*'.
     *
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     *
     * The matching should cover the entire input string (not partial).
     *
     * The function prototype should be:
     * bool isMatch(const char *s, const char *p)
     *
     * Some examples:
     * isMatch("aa","a") ? false
     * isMatch("aa","aa") ? true
     * isMatch("aaa","aa") ? false
     * isMatch("aa", "a*") ? true
     * isMatch("aa", ".*") ? true
     * isMatch("ab", ".*") ? true
     * isMatch("aab", "c*a*b") ? true
     */
    public static boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private static boolean isMatch(String s, int s1, String p, int s2) {
        if (s2 == p.length()) {
            return s1 == s.length();
        }

        if (s1 < s.length() && (p.charAt(s2) == '.' || p.charAt(s2) == s.charAt(s1))) {
            if (s2 + 1 < p.length() && p.charAt(s2 + 1) == '*') {
                return isMatch(s, s1 + 1, p, s2) || isMatch(s, s1, p, s2 + 2);
            } else {
                return isMatch(s, s1 + 1, p, s2 + 1);
            }
        }

        return s2 + 1 < p.length() && p.charAt(s2 + 1) == '*' && isMatch(s, s1, p, s2 + 2);
    }

    private static void test() {
        Utils.printTestln(isMatch("aa", "a"), false);
        Utils.printTestln(isMatch("aa", "aa"), true);
        Utils.printTestln(isMatch("aaa", "aa"), false);
        Utils.printTestln(isMatch("aa", "a*"), true);
        Utils.printTestln(isMatch("aa", ".*"), true);
        Utils.printTestln(isMatch("ab", ".*"), true);
        Utils.printTestln(isMatch("aab", "c*a*b"), true);
        Utils.printTestln(isMatch("ab", ".*c"), false);
    }

    public static void main(String[] args) {
        test();
    }
}
