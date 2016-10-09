package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _038CountAndSay {
    /*
    The count-and-say sequence is the sequence of integers beginning as follows:
    1, 11, 21, 1211, 111221, ...

    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.
    Given an integer n, generate the nth sequence.

    Note: The sequence of integers will be represented as a string.
    */
    public static String countAndSay(int n) {
        if (n == 0) {
            return null;
        }

        StringBuffer current = new StringBuffer("1");
        StringBuffer next = new StringBuffer();
        for (int i = 1; i < n; i++) {
            int start = 0;
            next.setLength(0);
            for (int j = 1, l = current.length(); j <= l; j++) {
                if (j == l || current.charAt(start) != current.charAt(j)) {
                    next.append(j - start);
                    next.append(current.charAt(start));
                    start = j;
                }
            }

            StringBuffer tmp = current;
            current = next;
            next = tmp;
        }

        return current.toString();
    }

    private static void test() {
        Utils.printTestln(countAndSay(5), "111221");
    }

    public static void main(String[] args) {
        test();
    }
}
