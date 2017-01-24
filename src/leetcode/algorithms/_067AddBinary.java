package leetcode.algorithms;

import utils.Utils;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 *
 * Return "100".
 *
 * https://leetcode.com/problems/add-binary/
 * http://www.careercup.com/question?id=15420859
 * http://www.careercup.com/question?id=5735540389314560
 * http://www.geeksforgeeks.org/add-two-bit-strings/
 * https://gist.github.com/zac-xin/4381455
 * http://n00tc0d3r.blogspot.com/2013/01/add-two-binary-numbers.html
 */
public class _067AddBinary {
    public static void main(String[] args) {
        Solution_AddBinary sol = new Solution_AddBinary();

        Utils.printTestln(sol.addBinary("11", "1"), "100");
    }
}

class Solution_AddBinary {
    public String addBinary(String first, String second) {
        String ret = "";
        int carrier = 0, s1, s2;

        for (s1 = first.length() - 1, s2 = second.length() - 1; s1 >= 0 && s2 >= 0; s1--, s2--) {
            int sum = first.charAt(s1) + second.charAt(s2) - '0' - '0' + carrier;
            carrier = sum >> 1;
            sum &= 1;
            ret = sum + ret;
        }

        if (s1 < 0) {
            s1 = s2;
            first = second;
        }

        for (; s1 >= 0; s1--) {
            int sum = first.charAt(s1) - '0' + carrier;
            carrier = sum >> 1;
            sum &= 1;
            ret = sum + ret;
        }

        return carrier > 0 ? carrier + ret : ret;
    }

    public String addBinary2(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carryin = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            if (i < 0) {
                int bBit = b.charAt(j) - '0';
                result.insert(0, bBit ^ carryin);
                carryin = bBit & carryin;
            } else if (j < 0) {
                int aBit = a.charAt(i) - '0';
                result.insert(0, aBit ^ carryin);
                carryin = aBit & carryin;
            } else {
                int aBit = a.charAt(i) - '0', bBit = b.charAt(j) - '0';
                int carryout = (aBit & bBit) | (aBit & carryin) | (bBit & carryin);
                result.insert(0, aBit ^ bBit ^ carryin);
                carryin = carryout;
            }
        }
        if (carryin == 1) result.insert(0, carryin);
        return result.toString();
    }
}
