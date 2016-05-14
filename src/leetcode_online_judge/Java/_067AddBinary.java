package leetcode_online_judge.Java;

import utils.Utils;

public class _067AddBinary {
    /*
    Given two binary strings, return their sum (also a binary string).

    For example,
    a = "11"
    b = "1"
    Return "100".
    */
    public static String addBinary(String a, String b) {
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

        for (; s1 >=0; s1--) {
            int sum = a.charAt(s1) - '0' + carrier;
            carrier = sum >> 1;
            sum &= 1;
            ret = sum + ret;
        }

        return carrier > 0 ? carrier + ret: ret;
    }

    private static void test() {
        Utils.printTestln(addBinary("11", "1"), "100");
    }

    public static void main(String[] args) {
        test();
    }
}
