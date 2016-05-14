package leetcode_online_judge.Java;

import utils.Utils;

public class _115DistinctSubsequence {
    /*
    Given a string S and a string T, count the number of distinct subsequences of T in S.

    A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
    the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of
     "ABCDE" while "AEC" is not).

    Here is an example:
    S = "rabbbit", T = "rabbit"

    Return 3.
     */
    public static int numDistinct(String S, String T) {
        return numDistinct(S, 0, T, 0);
    }

    public static int numDistinct(String S, int sStart, String T, int tStart) {
        if (tStart == T.length()) {
            return 1;
        }

        if (sStart == S.length()) {
            return 0;
        }

        if (S.charAt(sStart) == T.charAt(tStart)) {
            return numDistinct(S, sStart + 1, T, tStart + 1) + numDistinct(S, sStart + 1, T, tStart);
        }

        return numDistinct(S, sStart + 1, T, tStart);
    }

    public static int numDistinctDP(String S, String T) {
        int s = S.length(), t = T.length();

        if (t == 0) {
            return 1;
        }
        if (s == 0) {
            return 0;
        }

        int[][] num = new int[s][t];
        num[s - 1][t - 1] = S.charAt(s - 1) == T.charAt(t - 1) ? 1 : 0;

        for (int i = s - 2; i >= 0; i--) {
            if (S.charAt(i) == T.charAt(t - 1)) {
                num[i][t - 1] = num[i + 1][t - 1] + 1;
            } else {
                num[i][t - 1] = num[i + 1][t - 1];
            }
            for (int j = 0; j < t - 1; j++) {
                if (S.charAt(i) == T.charAt(j)) {
                    num[i][j] = num[i + 1][j + 1] + num[i + 1][j];
                } else {
                    num[i][j] = num[i + 1][j];
                }
            }
        }

        return num[0][0];
    }

    public static int numDistinctDP2(String S, String T) {
        int s = S.length(), t = T.length();
        if (t == 0) {
            return 1;
        }
        if (s == 0) {
            return 0;
        }
        int[] num = new int[t];
        num[t - 1] = S.charAt(s - 1) == T.charAt(t - 1) ? 1 : 0;

        for (int i = s - 2; i >= 0; i--) {
            for (int j = 0; j < t - 1; j++) {
                if (S.charAt(i) == T.charAt(j)) {
                    num[j] += num[j + 1];
                }
            }
            if (S.charAt(i) == T.charAt(t - 1)) {
                num[t - 1]++;
            }
        }

        return num[0];
    }

    private static void test() {
        Utils.printTestln(numDistinct("", "a"), 0);
        Utils.printTestln(numDistinct("", ""), 1);
        Utils.printTestln(numDistinct("rabbbit", "rabbit"), 3);
        Utils.printTestln(numDistinct("abcde", "ace"), 1);
        Utils.printTestln(numDistinct("abcde", "aec"), 0);
        Utils.printTestln(numDistinct("daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdee" +
                "bcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdb" +
                "cdcbceabcacddbbcedebbcaccac", "ceadbaa"), 8556153);

        System.out.println("\nBelow is the DP algorithm:");

        Utils.printTestln(numDistinctDP("", "a"), 0);
        Utils.printTestln(numDistinctDP("", ""), 1);
        Utils.printTestln(numDistinctDP("rabbbit", "rabbit"), 3);
        Utils.printTestln(numDistinctDP("abcde", "ace"), 1);
        Utils.printTestln(numDistinctDP("abcde", "aec"), 0);
        Utils.printTestln(numDistinctDP("daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdee" +
                "bcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdb" +
                "cdcbceabcacddbbcedebbcaccac", "ceadbaa"), 8556153);

        System.out.println("\nBelow is the space optimized DP algorithm:");

        Utils.printTestln(numDistinctDP2("", "a"), 0);
        Utils.printTestln(numDistinctDP2("", ""), 1);
        Utils.printTestln(numDistinctDP2("rabbbit", "rabbit"), 3);
        Utils.printTestln(numDistinctDP2("abcde", "ace"), 1);
        Utils.printTestln(numDistinctDP2("abcde", "aec"), 0);
        Utils.printTestln(numDistinctDP2("daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdee" +
                "bcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdb" +
                "cdcbceabcacddbbcedebbcaccac", "ceadbaa"), 8556153);
    }

    public static void main(String[] args) {
        test();
    }
}
