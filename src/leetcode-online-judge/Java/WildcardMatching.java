package leetcode_online_judge;

import utils.Utils;

public class WildcardMatching {
    /*
    Implement wildcard pattern matching with support for '?' and '*'.

    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).

    The matching should cover the entire input string (not partial).

    The function prototype should be:
    bool isMatch(const char *s, const char *p)

    Some examples:
    isMatch("aa","a") ? false
    isMatch("aa","aa") ? true
    isMatch("aaa","aa") ? false
    isMatch("aa", "*") ? true
    isMatch("aa", "a*") ? true
    isMatch("ab", "?*") ? true
    isMatch("aab", "c*a*b") ? false
     */
    public static boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private static boolean isMatch(String s, int sS, String p, int pS) {
        if (pS == p.length())  {
            return sS == s.length();
        }


        if (p.charAt(pS) != '*') {
            return sS < s.length() && (p.charAt(pS) == '.' || p.charAt(pS) == s.charAt(sS)) && isMatch(s, sS + 1, p, pS + 1);
        }

        return isMatch(s, sS, p, pS + 1) || isMatch(s, sS + 1, p, pS);
    }

    public static boolean isMatchDP(String s, String p) {
        int m = s.length(), n = p.length();

        if (n == 0) {
            return m == n;
        }

        boolean[][] dp = new boolean[2][m + 1];

        if (p.charAt(n - 1) == '*') {
            for (int i = 0; i <= m; i++) {
                dp[0][i] = true;
            }
        } else if (m > 0) {
            dp[0][m - 1] = s.charAt(m - 1) == p.charAt(n - 1) || p.charAt(n - 1) == '.';
        }

        for (int i = n - 2; i >= 0; i--) {
            boolean[] tmp = dp[0];
            dp[0] = dp[1];
            dp[1] = tmp;
            
            dp[0][m] = dp[1][m] && p.charAt(i) == '*';
            for (int j = m - 1; j >= 0; j--) {
                if (p.charAt(i) != '*') {
                    dp[0][j] = dp[1][j + 1] && (s.charAt(j) == p.charAt(i) || p.charAt(i) == '.');
                } else {
                    dp[0][j] = dp[0][j + 1] || dp[1][j];
                }
            }
        }

        return dp[0][0];
    }

    public static boolean isMatchGreedy(String s, String p) {
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

    private static boolean isMatchFromEnd(String s, int end, String p, int end2) {
        int i, j;
        for (i = end - 1, j = end2 - 1; i < s.length() && i >= 0 && j < p.length() && j >= 0 && (p.charAt(j) == '?' ||s.charAt(i) == p.charAt(j)); i--, j--);
        return j == -1 && i == -1;
    }

    private static boolean isMatchFromEnd2(String s, int start, String p, int start2) {
        int i, j;
        for (i = s.length() - 1, j = p.length() - 1; i >= start && j >= start2 && (p.charAt(j) == '?' ||s.charAt(i) == p.charAt(j)); i--, j--);
        return j == start2 - 1;
    }

    private static int isMatchHelp(String s, int start, String p, int start2, int end2) {
        for (int i = 0, j; i < s.length() - start - end2 + start2 + 1; i++) {
            for (j = 0; j < end2 - start2 && (p.charAt(start2 + j) == '?' || p.charAt(start2 + j) == s.charAt(start + j + i)); j++);
            if (j == end2 - start2) {
                return start + j + i;
            }
        }
        return -1;
    }

    private static void test() {
//        Utils.printTestln(isMatch("",""), true);
//        Utils.printTestln(isMatch("","*"), true);
//        Utils.printTestln(isMatch("aa","a"), false);
//        Utils.printTestln(isMatch("aa","aa"), true);
//        Utils.printTestln(isMatch("aaa","aa"), false);
//        Utils.printTestln(isMatch("aa", "a*"), true);
//        Utils.printTestln(isMatch("aab", "a*"), true);
//        Utils.printTestln(isMatch("aa", "?*"), true);
//        Utils.printTestln(isMatch("ab", "?*"), true);
//        Utils.printTestln(isMatch("a", "?*"), true);
//        Utils.printTestln(isMatch("aab", "c*a*b"), false);
//
//        System.out.println("\n>>>Below is the DP version:");
//
//        Utils.printTestln(isMatchDP("",""), true);
//        Utils.printTestln(isMatchDP("","*"), true);
//        Utils.printTestln(isMatchDP("aa","a"), false);
//        Utils.printTestln(isMatchDP("aa","aa"), true);
//        Utils.printTestln(isMatchDP("aaa","aa"), false);
//        Utils.printTestln(isMatchDP("aa", "a*"), true);
//        Utils.printTestln(isMatchDP("aab", "a*"), true);
//        Utils.printTestln(isMatchDP("aa", "?*"), true);
//        Utils.printTestln(isMatchDP("ab", "?*"), true);
//        Utils.printTestln(isMatchDP("a", "?*"), true);
//        Utils.printTestln(isMatchDP("aab", "c*a*b"), false);
        long s = System.currentTimeMillis();
//        Utils.printTestln(isMatchDP(padding('a', 32316), '*' + padding('a', 32317) + '*'), false);
//        System.out.println("It took " + (System.currentTimeMillis() - s) + " milliseconds");

        System.out.println("\n>>>Below is the Greedy version:");

//        Utils.printTestln(isMatchGreedy("",""), true);
        Utils.printTestln(isMatchGreedy("","ab*"), false);
        Utils.printTestln(isMatchGreedy("aa","a"), false);
        Utils.printTestln(isMatchGreedy("aa","aa"), true);
        Utils.printTestln(isMatchGreedy("aaa","aa"), false);
        Utils.printTestln(isMatchGreedy("aa", "a*"), true);
        Utils.printTestln(isMatchGreedy("aab", "a*"), true);
        Utils.printTestln(isMatchGreedy("aa", "?*"), true);
        Utils.printTestln(isMatchGreedy("ab", "?*"), true);
        Utils.printTestln(isMatchGreedy("a", "?*"), true);
        Utils.printTestln(isMatchGreedy("aab", "c*a*b"), false);
        Utils.printTestln(isMatchGreedy("b", "?*?"), false);
        Utils.printTestln(isMatchGreedy("aaab", "b**"), false);
        s = System.currentTimeMillis();
        Utils.printTestln(isMatchGreedy(padding('a', 32316), '*' + padding('a', 32317) + '*'), false);
        System.out.println("It took " + (System.currentTimeMillis() - s) + " milliseconds");
    }

    private static String padding(char c, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        test();
    }
}
