package leetcode.algorithms;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _043MultiplyStrings {
    /*
    Given two numbers represented as strings, return multiplication of the numbers as a string.

    Note: The numbers can be arbitrarily large and are non-negative.
    */
    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String ret = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            ret = add(ret, muliply10(multiply(num1, num2.charAt(i)), num2.length() - 1 - i));
        }
        return ret;
    }

    private static String muliply10(String num, int t) {
        for (int i = 0; i < t; i++) {
            num += "0";
        }
        return num;
    }

    private static String multiply(String num, char c) {
        String ret = "";
        int carrier = 0, i;
        for (i = num.length() - 1; i >= 0; i--) {
            int p = (num.charAt(i) - '0') * (c - '0') + carrier;
            if (p >= 10) {
                carrier = p / 10;
                p %= 10;
            } else {
                carrier = 0;
            }
            ret = p + ret ;
        }
        if (carrier > 0) {
            ret = carrier + ret;
        }
        return ret;
    }

    private static String add(String num1, String num2) {
        String ret = "";

        int carrier = 0, m, n;
        for (m = num1.length() - 1, n = num2.length() - 1; m >= 0 && n >= 0; m--, n--) {
            int sum = num1.charAt(m) + num2.charAt(n) - '0' - '0' + carrier;
            if (sum >= 10) {
                carrier = 1;
                sum -= 10;
            } else  {
                carrier = 0;
            }
            ret = sum + ret;
        }

        if (n >= 0) {
            m = n;
            num1 = num2;
        }
        for (; m >= 0; m--) {
            int sum = num1.charAt(m) + carrier - '0';
            if (sum >= 10) {
                carrier = 1;
                sum -= 10;
            } else {
                carrier = 0;
            }
            ret = sum + ret;
        }

        if (carrier == 1) {
            ret = "1" + ret;
        }

        return ret;
    }

    private static void test() {
        Utils.printTestln(multiply("1234", "45"), String.valueOf(1234 * 45));
        Utils.printTestln(multiply("1234", "0"), "0");
    }

    public static void main(String[] args) {
        test();
    }
}
