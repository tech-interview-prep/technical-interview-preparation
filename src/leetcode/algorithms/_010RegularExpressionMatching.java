package leetcode.algorithms;

import utils.Utils;

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
 *
 * https://leetcode.com/problems/regular-expression-matching/
 * http://n00tc0d3r.blogspot.com/2013/05/regular-expression-matching.html
 * @author bkoteshwarreddy
 */
public class _010RegularExpressionMatching {
    public static void main(String[] args) {
        Solution_RegularExpressionMatching sol = new Solution_RegularExpressionMatching();

        Utils.printTestln(sol.isMatch("aa", "a"), false);
        Utils.printTestln(sol.isMatch("aa", "aa"), true);
        Utils.printTestln(sol.isMatch("aaa", "aa"), false);
        Utils.printTestln(sol.isMatch("aa", "a*"), true);
        Utils.printTestln(sol.isMatch("aa", ".*"), true);
        Utils.printTestln(sol.isMatch("ab", ".*"), true);
        Utils.printTestln(sol.isMatch("aab", "c*a*b"), true);
        Utils.printTestln(sol.isMatch("ab", ".*c"), false);
    }
}

class Solution_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int s1, String p, int s2) {
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

    public boolean isMatch2(String s, String p) {
        if (s == null) return (p == null);
        if (p.isEmpty()) return (s.isEmpty());

        // next char is not '*': do current char match?
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.isEmpty()) return false;
            return (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))
                   && isMatch(s.substring(1), p.substring(1));
        }

        // next char is '*'
        // current char match, zero or more repeats
        int i = 0;
        while (i < s.length() && (p.charAt(0) == '.' || s.charAt(i) == p.charAt(0))) {
            if (isMatch(s.substring(i), p.substring(2))) return true;
            i++;
        }

        // zero
        return isMatch(s.substring(i), p.substring(2));
    }
}
