package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _072EditDistance {
    /*
    Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
    (each operation is counted as 1 step.)

    You have the following 3 operations permitted on a word:

    a) Insert a character
    b) Delete a character
    c) Replace a character
    */
    public static int minDistance(String word1, String word2) {
        return minDistance(word1, 0, word2, 0);
    }

    private static int minDistance(String w1, int s1, String w2, int s2) {
        if (s1 == w1.length()) {
            return w2.length() - s2;
        }

        if (s2 == w2.length()) {
            return w1.length() - s1;
        }

        if (w1.charAt(s1) == w2.charAt(s2)) {
            return minDistance(w1, s1 + 1,  w2,  s2 + 1);
        }

        return 1 + Math.min(Math.min(minDistance(w1, s1 + 1,  w2,  s2 + 1), minDistance(w1, s1,  w2,  s2 + 1)),
                            minDistance(w1, s1 + 1,  w2,  s2));
    }

    public static int minDistanceDP(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        if (l1 == 0 || l2 == 0) {
            return Math.max(l1, l2);
        }

        int[][] minDist = new int[l1][l2];

        minDist[l1 - 1][l2 - 1] = word1.charAt(l1 - 1) == word2.charAt(l2 - 1) ? 0 : 1;

        for (int i = l1 - 2; i >= 0; i--) {
            minDist[i][l2 - 1] = word1.charAt(i) == word2.charAt(l2 - 1) ? l1 - i - 1 : 1 + minDist[i + 1][l2 - 1];
        }

        for (int i = l2 - 2; i >= 0; i--) {
            minDist[l1 - 1][i] = word1.charAt(l1 - 1) == word2.charAt(i) ? l2 - i - 1 : 1 + minDist[l1 - 1][i + 1];
        }

        for (int i = l1 - 2; i >= 0; i--) {
            for (int j = l2 - 2; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    minDist[i][j] = minDist[i + 1][j + 1];
                } else {
                    minDist[i][j] = 1 + Math.min(Math.min(minDist[i][j + 1], minDist[i + 1][j]), minDist[i + 1][j + 1]);
                }
            }
        }

        return minDist[0][0];
    }

    public static int minDistanceDP2(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();

        if (l1 == 0 || l2 == 0) {
            return Math.max(l1, l2);
        }

        if (l1 > l2) {
            String tmp = word1;
            word1 = word2;
            word2 = tmp;
            l1 ^= l2;
            l2 ^= l1;
            l1 ^= l2;
        }

        int[] level1 = new int[l1], level2 = new int[l1];

        level1[l1 - 1] = word1.charAt(l1 - 1) == word2.charAt(l2 - 1) ? 0 : 1;

        for (int i = l1 - 2; i >= 0; i--) {
            level1[i] = word1.charAt(i) == word2.charAt(l2 - 1) ? l1 - i - 1 : 1 + level1[i + 1];
        }


        for (int i = l2 - 2; i >= 0; i--) {
            level2[l1 - 1] = word1.charAt(l1 - 1) == word2.charAt(i) ? l2 - i - 1 : 1 + level1[l1 - 1];
            for (int j = l1 - 2; j >= 0; j--) {
                if (word1.charAt(j) == word2.charAt(i)) {
                    level2[j] = level1[j + 1];
                } else {
                    level2[j] = 1 + Math.min(Math.min(level2[j + 1], level1[j]), level1[j + 1]);
                }
            }
            int[] tmp = level1;
            level1 = level2;
            level2 = tmp;
        }
        return level1[0];
    }

    private static void test() {
        Utils.printTestln(minDistance("a", "a"), 0);
        Utils.printTestln(minDistance("a", ""), 1);
        Utils.printTestln(minDistance("", "a"), 1);
        Utils.printTestln(minDistance("horse", "ros"), 3);

        System.out.println(">>>\nBelow is the DP version:\n");

        Utils.printTestln(minDistanceDP("a", "a"), 0);
        Utils.printTestln(minDistanceDP("a", ""), 1);
        Utils.printTestln(minDistanceDP("", "a"), 1);
        Utils.printTestln(minDistanceDP("horse", "ros"), 3);
        Utils.printTestln(minDistanceDP("dinitrophenylhydrazine", "acetylphenylhydrazine"), 6);
        Utils.printTestln(minDistanceDP("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopical"), 28);

        System.out.println(">>>\nBelow is the space optimized DP version:\n");

        Utils.printTestln(minDistanceDP2("a", "a"), 0);
        Utils.printTestln(minDistanceDP2("a", ""), 1);
        Utils.printTestln(minDistanceDP2("", "a"), 1);
        Utils.printTestln(minDistanceDP2("horse", "ros"), 3);
        Utils.printTestln(minDistanceDP2("dinitrophenylhydrazine", "acetylphenylhydrazine"), 6);
        Utils.printTestln(minDistanceDP2("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopical"), 28);
    }

    public static void main(String[] args) {
        test();
    }
}
