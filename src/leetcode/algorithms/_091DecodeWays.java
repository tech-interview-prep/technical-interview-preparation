package leetcode.algorithms;

import utils.Utils;

/**
 * https://leetcode.com/problems/decode-ways/
 *
 * @author bkoteshwarreddy
 */
public class _091DecodeWays {
    /**
     * A message containing letters from A-Z can be encoded into numbers using the following mapping:
     *
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * To decode an encoded message, all the digits must be grouped then mapped back into letters using the
     * reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
     *
     * "AAJF" with the grouping (1 1 10 6)
     * "KJF" with the grouping (11 10 6)
     * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
     *
     * Given a string s containing only digits, return the number of ways to decode it.
     *
     * The test cases are generated so that the answer fits in a 32-bit integer.
     */
    public static int numDecodings(String s) {
        return numDecodings(s, 0);
    }

    public static int numDecodings(String s, int start) {
        if (start == s.length() || start == s.length() - 1) {
            return 1;
        }
        char c1 = s.charAt(start), c2 = s.charAt(start + 1);
        if (c1 == '0') {
            return 0;
        }
        if ((c1 - '0') * 10 + (c2 - '0') < 27) {
            return numDecodings(s, start + 1) + numDecodings(s, start + 2);
        }

        return numDecodings(s, start + 1);
    }

    public static int numDecodingsDP(String s) {
        int l = s.length();

        if (l == 0) {
            return 0;
        }

        int[] num = new int[l + 1];

        num[num.length - 1] = 1;
        num[num.length - 2] = s.charAt(l - 1) == '0' ? 0 : 1;

        for (int i = num.length - 3; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                num[i] = 0;
            } else {
                if ((s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0' < 27) {
                    num[i] = num[i + 1] + num[i + 2];
                } else {
                    num[i] = num[i + 1];
                }
            }
        }

        return num[0];
    }

    public static int numDecodingsDP2(String s) {
        int l = s.length();
        if (l == 0) {
            return 0;
        }
        int num1 = s.charAt(l - 1) == '0' ? 0 : 1, num2 = 1;

        for (int i = l - 2; i >= 0; i--) {
            int next, sum = (s.charAt(i) - '0' ) * 10 + s.charAt(i + 1) - '0';

            if (sum < 10) {
                next = 0;
            } else if (sum <= 26) {
                next = num1 + num2;
            } else {
                next = num1;
            }
            num2 = num1;
            num1 = next;
        }

        return num1;
    }

    private static void test() {
        Utils.printTestln(numDecodings("12"), 2);
        Utils.printTestln(numDecodings("123"), 3);
        Utils.printTestln(numDecodings("132"), 2);
        Utils.printTestln(numDecodings("201"), 1);
        Utils.printTestln(numDecodings(""), 0);

        System.out.println("\n>>>below is the DP solution:\n");

        Utils.printTestln(numDecodingsDP("12"), 2);
        Utils.printTestln(numDecodingsDP("123"), 3);
        Utils.printTestln(numDecodingsDP("132"), 2);
        Utils.printTestln(numDecodingsDP("201"), 1);
        Utils.printTestln(numDecodingsDP(""), 0);

        System.out.println("\n>>>below is the space optimized DP solution:\n");

        Utils.printTestln(numDecodingsDP2("12"), 2);
        Utils.printTestln(numDecodingsDP2("123"), 3);
        Utils.printTestln(numDecodingsDP2("132"), 2);
        Utils.printTestln(numDecodingsDP2("201"), 1);
        Utils.printTestln(numDecodingsDP2(""), 0);
    }

    public static void main(String[] args) {
        test();
    }
}
