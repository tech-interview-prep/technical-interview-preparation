package leetcode.algorithms;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _097InterleavingString {
    /*
    Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

    For example,
    Given:
    s1 = "aabcc",
    s2 = "dbbca",

    When s3 = "aadbbcbcac", return true.
    When s3 = "aadbbbaccc", return false.
    */
    public static boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }

    private static boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3) {
        if (i1 == s1.length() && i2 == s2.length()) {
            return i3 == s3.length();
        }

        if (i1 == s1.length()) {
            return s3.substring(i3).equals(s2.substring(i2));
        }

        if (i2 == s2.length()) {
            return s3.substring(i3).equals(s1.substring(i1));
        }

        if (s3.charAt(i3) != s1.charAt(i1) && s3.charAt(i3) != s2.charAt(i2)) {
            return false;
        }

        if (s1.charAt(i1) == s3.charAt(i3) && isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1)) {
            return true;
        }

        if (s2.charAt(i2) == s3.charAt(i3) && isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1)) {
            return true;
        }

        return false;
    }

    public static boolean isInterleaveDP(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();

        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[l1][l2] = l1 + l2 == l3;

        for (int i = l2 - 1; i >= 0; i--) {
            dp[l1][i] = s3.substring(l1 + i).equals(s2.substring(i));
        }

        for (int i = l1 - 1; i >= 0; i--) {
            dp[i][l2] = s3.substring(l2 + i).equals(s1.substring(i));
        }

        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] && s3.charAt(i + j) == s1.charAt(i) || dp[i][j + 1] && s3.charAt(i + j) == s2.charAt(j);
            }
        }

        return dp[0][0];
    }


    public static boolean isInterleaveDP2(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();

        if (l1 > l2) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
            l1 = l2;
            l2 = s2.length();

        }

        boolean[] dp = new boolean[l1 + 1];
        dp[l1] = l1 + l2 == l3;

        for (int i = l1 - 1; i >= 0; i--) {
            dp[i] = s3.substring(l2 + i).equals(s1.substring(i));
        }

        for (int i = l2 - 1; i >= 0; i--) {
            dp[l1] = s2.substring(i).equals(s3.substring(l1 + i));
            for (int j = l1 - 1; j >= 0; j--) {
                dp[j] = dp[j] && s3.charAt(i + j) == s2.charAt(i) || dp[j + 1] && s3.charAt(i + j) == s1.charAt(j);
            }
        }

        return dp[0];
    }

    private static void test() {
        Utils.printTestln(isInterleave("", "", ""), true);
        Utils.printTestln(isInterleave("aabcc", "dbbca", "aadbbcbcac"), true);
        Utils.printTestln(isInterleave("aabcc", "dbbca", "aadbbbaccc"), false);
        Utils.printTestln(isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                                       "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                                       "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"),
                          false);

        System.out.println("\n>>>Below is the DP version:");

        Utils.printTestln(isInterleaveDP("", "", ""), true);
        Utils.printTestln(isInterleaveDP("aabcc", "dbbca", "aadbbcbcac"), true);
        Utils.printTestln(isInterleaveDP("aabcc", "dbbca", "aadbbbaccc"), false);
        Utils.printTestln(isInterleaveDP("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                                         "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                                         "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"),
                          false);

        System.out.println("\n>>>Below is the space optimized DP version:");

        Utils.printTestln(isInterleaveDP2("", "", ""), true);
        Utils.printTestln(isInterleaveDP2("aabcc", "dbbca", "aadbbcbcac"), true);
        Utils.printTestln(isInterleaveDP2("aabcc", "dbbca", "aadbbbaccc"), false);
        Utils.printTestln(isInterleaveDP2("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                                          "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                                          "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"),
                          false);

    }

    public static void main(String[] args) {
        test();
    }
}


