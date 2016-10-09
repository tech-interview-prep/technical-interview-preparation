package facebook;

import utils.Utils;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a = "11"
 * b = "1"
 *
 * Return "100".
 * https://leetcode.com/problems/add-binary/
 * http://www.careercup.com/question?id=15420859
 * http://www.careercup.com/question?id=5735540389314560
 * http://www.geeksforgeeks.org/add-two-bit-strings/
 * https://gist.github.com/zac-xin/4381455
 */
public class _067AddBinary {
    public static void main(String[] args) {
        Solution_AddBinary sol = new Solution_AddBinary();

        Utils.printTestln(sol.addBinary("11", "1"), "100");
    }
}

class Solution_AddBinary {
    public String addBinary(String a, String b) {
        String ret = "";
        int carrier = 0, s1, s2;

        for (s1 = a.length() - 1, s2 = b.length() - 1; s1 >= 0 && s2 >= 0; s1--, s2--) {
            int sum = a.charAt(s1) + b.charAt(s2) - '0' - '0' + carrier;
            carrier = sum >> 1;
            sum &= 1;
            ret = sum + ret;
        }

        if (s1 < 0) {
            s1 = s2;
            a = b;
        }

        for (; s1 >= 0; s1--) {
            int sum = a.charAt(s1) - '0' + carrier;
            carrier = sum >> 1;
            sum &= 1;
            ret = sum + ret;
        }

        return carrier > 0 ? carrier + ret : ret;
    }

    public String addBitStrings( String first, String second ) {
        String result = "";  // To store the sum bits

        int len1 = first.length();
        int len2 = second.length();
        // make the lengths same before adding

        if (len1 < len2) {
            for (int i = 0 ; i < len2 - len1 ; i++)
                first = '0' + first;
        } else if (len1 > len2) {
            for (int i = 0 ; i < len1 - len2 ; i++)
                second = '0' + second;
        }

        int length = first.length();

        int carry = 0;  // Initialize carry

        // Add all bits one by one
        for (int i = length - 1 ; i >= 0 ; i--) {
            int firstBit = first.charAt(i) - '0';
            int secondBit = second.charAt(i) - '0';

            // boolean expression for sum of 3 bits
            int sum = (firstBit ^ secondBit ^ carry) + '0';

            result = (char)sum + result;

            // boolean expression for 3-bit addition
            carry = (firstBit & secondBit) | (secondBit & carry) | (firstBit & carry);
        }

        // if overflow, then add a leading 1
        if (carry > 0)
            result = '1' + result;

        return result;
    }
}
