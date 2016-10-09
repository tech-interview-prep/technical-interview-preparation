package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _132PalindromePartitionII {
    /*
     Given a string s, partition s such that every substring of the partition is a palindrome.

    Return the minimum cuts needed for a palindrome partitioning of s.

    For example, given s = "aab",
    Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
     */
    public static int minCut(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int[] minCut = new int[s.length() + 1];

        isPalindrome[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            isPalindrome[i][i] = true;
            isPalindrome[i][i - 1] = true;
        }

        minCut[s.length()] = -1;
        minCut[s.length() - 1] = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                isPalindrome[j][j + s.length() - i - 1] = s.charAt(j) == s.charAt(j + s.length() - i - 1) && isPalindrome[j + 1][j + s.length() - i - 2];
            }
            minCut[i] = 1 + minCut[i + 1];
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrome[i][j]) {
                    minCut[i] = Math.min(minCut[i], minCut[j + 1] + 1);
                }
            }
        }

        return minCut[0];
    }

    private static void test() {
        Utils.printTestln(minCut("aab"), 1);
        Utils.printTestln(minCut("ab"), 1);
        Utils.printTestln(minCut("cabababcbc"), 3);
        Utils.printTestln(minCut("ababababababababababababcbabababababababababababa"), 0);
    }

    public static void main(String[] args) {
        test();
    }

}
