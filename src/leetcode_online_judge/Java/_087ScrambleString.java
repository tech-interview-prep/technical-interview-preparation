package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _087ScrambleString {
    /*
    Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

    Below is one possible representation of s1 = "great":

        great
       /    \
      gr    eat
     / \    /  \
    g   r  e   at
               / \
              a   t
    To scramble the string, we may choose any non-leaf node and swap its two children.

    For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

        rgeat
       /    \
      rg    eat
     / \    /  \
    r   g  e   at
               / \
              a   t
    We say that "rgeat" is a scrambled string of "great".

    Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

        rgtae
       /    \
      rg    tae
     / \    /  \
    r   g  ta  e
           / \
          t   a
    We say that "rgtae" is a scrambled string of "great".

    Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
     */
    public static boolean isScramble(String s1, String s2) {
        int l = s1.length();

        if (l != s2.length()) {
            return false;
        }

        if (l == 1) {
            return s1.equals(s2);
        }

        for (int i = 1; i < l; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)) ||
                    isScramble(s1.substring(0, i), s2.substring(l - i)) && isScramble(s1.substring(i), s2.substring(0, l - i))) {
                return true;
            }
        }

        return false;
    }

    // isScramble[i][j][k]: check whether s1's substring which start at i with length k is scrabmel string of s2's substring which start
    // at j with length k

    // denote isScramble[i][j][k] as s(i, j, k), then
    // s(i, j, k) = s(i, j, m) && s(i + m, j + m, k - m) || s(i, j + k - m, m) && s(i + m, j, k - m) where m = 1, 2, ... , k - 1

    // is[i][j][k] = is[i][j][m] && is[i + m][j + m][k - m] || is[i][j + k - m][m] && is[i + m][j][k - m] where
    // m = 0, 1, 2, ... , k - 2 and k = 0, 1, ... s1.length() - 1
    public static boolean isScrambleDP(String s1, String s2) {
        int l = s1.length();
        if (l != s2.length()) {
            return false;
        }

        boolean[][][] is = new boolean[l][l][l];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                is[i][j][0] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int k = 1; k < l; k++) {
            for (int i = 0; i < l - k; i++) {
                for (int j = 0; j < l - k ; j++) {
                    for (int m = 0; m < k; m++) {
                        if (is[i][j][m] && is[i + m + 1][j + m + 1][k - m - 1] || is[i][j + k - m][m] && is[i + m + 1][j][k - m - 1]) {
                            is[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }

        return is[0][0][l - 1];
    }

    private static void test() {
        Utils.printTestln(isScramble("great", "rgtae"), true);
        Utils.printTestln(isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"), false);

        System.out.println("\n>>>Below is the output for DP:\n");

        Utils.printTestln(isScramble("great", "rgtae"), true);
        Utils.printTestln(isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"), false);

    }

    public static void main(String[] args) {
        test();
    }
}
