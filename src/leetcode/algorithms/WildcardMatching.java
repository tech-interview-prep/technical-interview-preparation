package leetcode.algorithms;

import utils.Utils;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 *     '?' Matches any single character.
 *     '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 *     bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 *     isMatch("aa","a") ? false
 *     isMatch("aa","aa") ? true
 *     isMatch("aaa","aa") ? false
 *     isMatch("aa", "*") ? true
 *     isMatch("aa", "a*") ? true
 *     isMatch("ab", "?*") ? true
 *     isMatch("aab", "c*a*b") ? false
 *
 * https://leetcode.com/problems/wildcard-matching/
 * http://n00tc0d3r.blogspot.com/2013/05/wildcard-matching.html
 */
public class WildcardMatching {
    private static String padding(char c, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_WildcardMatching sol = new Solution_WildcardMatching();

        long s = System.currentTimeMillis();

        Utils.printTestln(sol.isMatch("", ""), true);
        Utils.printTestln(sol.isMatch("", "ab*"), false);
        Utils.printTestln(sol.isMatch("aa", "a"), false);
        Utils.printTestln(sol.isMatch("aa", "aa"), true);
        Utils.printTestln(sol.isMatch("aaa", "aa"), false);
        Utils.printTestln(sol.isMatch("aa", "a*"), true);
        Utils.printTestln(sol.isMatch("aab", "a*"), true);
        Utils.printTestln(sol.isMatch("aa", "?*"), true);
        Utils.printTestln(sol.isMatch("ab", "?*"), true);
        Utils.printTestln(sol.isMatch("a", "?*"), true);
        Utils.printTestln(sol.isMatch("aab", "c*a*b"), false);
        Utils.printTestln(sol.isMatch("b", "?*?"), false);
        Utils.printTestln(sol.isMatch("aaab", "b**"), false);
        s = System.currentTimeMillis();
        Utils.printTestln(sol.isMatch(padding('a', 32316), '*' + padding('a', 32317) + '*'), false);
        System.out.println("It took " + (System.currentTimeMillis() - s) + " milliseconds");
    }
}

class Solution_WildcardMatching {
    /*
        Iterative solution, from http://blog.sina.com.cn/s/blog_b9285de20101gw2x.html
    */
    public boolean isMatch2(String s, String p) {
        if (s == null) return p == null;
        if (p == null) return false;
        int n = s.length(), m = p.length(), i = 0, j = 0, starPosition = -1, iback = 0;
        while (i < n) {
            while (j < m && p.charAt(j) == '*') {
                starPosition = j++;
                iback = i;
            }
            if (j == m && (p.charAt(j) != '?' && p.charAt(j) != s.charAt(i))) {
                if (starPosition == -1)
                    return false;
                j = starPosition + 1;
                i = ++iback;
            } else {
                i++;
                j++;
            }
        }
        while (j < m && p.charAt(j) == '*')
            j++;
        return j == m;
    }

    public boolean isMatch(String s, String p) {
        int i1 = 0, i2 = 0, lastWildcard = -1;

        while (true) {
            int start1 = i1, start2 = i2;
            for (; i2 < p.length() && p.charAt(i2) != '*'; i2++);

            if (lastWildcard == -1) {
                if (i2 == p.length()) {
                    return isMatchFromEnd(s, s.length(), p, p.length());
                }
                if (!isMatchFromEnd(s, i2, p, i2)) {
                    return false;
                }
                lastWildcard = 1;
                i1 = i2;
            } else {
                if (i2 == p.length()) {
                    return isMatchFromEnd2(s, start1, p, start2);
                }
                if ((i1 = isMatchHelp(s, start1, p, start2, i2)) == -1) {
                    return false;
                }
            }
            i2++;
        }
    }

    private boolean isMatchFromEnd(String s, int end, String p, int end2) {
        int i, j;
        for (i = end - 1, j = end2 - 1; i < s.length() && i >= 0 && j < p.length() && j >= 0 && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)); i--, j--);
        return j == -1 && i == -1;
    }

    private boolean isMatchFromEnd2(String s, int start, String p, int start2) {
        int i, j;
        for (i = s.length() - 1, j = p.length() - 1; i >= start && j >= start2 && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)); i--, j--);
        return j == start2 - 1;
    }

    private int isMatchHelp(String s, int start, String p, int start2, int end2) {
        for (int i = 0, j; i < s.length() - start - end2 + start2 + 1; i++) {
            for (j = 0; j < end2 - start2 && (p.charAt(start2 + j) == '?' || p.charAt(start2 + j) == s.charAt(start + j + i)); j++);
            if (j == end2 - start2) {
                return start + j + i;
            }
        }
        return -1;
    }
}
