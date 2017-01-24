package leetcode.algorithms;

import utils.Utils;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 *
 * https://leetcode.com/problems/decode-ways/
 * http://n00tc0d3r.blogspot.com/2013/02/the-number-of-ways-to-decode-message.html
 */
public class DecodeWays {
    public static void main(String[] args) {
        Solution_DecodeWays sol = new Solution_DecodeWays();

        Utils.printTestln(sol.numDecodingsDP("12"), 2);
        Utils.printTestln(sol.numDecodingsDP("123"), 3);
        Utils.printTestln(sol.numDecodingsDP("132"), 2);
        Utils.printTestln(sol.numDecodingsDP("201"), 1);
        Utils.printTestln(sol.numDecodingsDP(""), 0);
    }
}

class Solution_DecodeWays {
    public int numDecodingsDP(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int num1 = s.charAt(length - 1) == '0' ? 0 : 1, num2 = 1;

        for (int i = length - 2; i >= 0; i--) {
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
}
