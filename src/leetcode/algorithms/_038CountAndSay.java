package leetcode.algorithms;

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
    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }

        String result = "1";
        int i = 1;
        char prev;
        int count;
        StringBuilder sb;

        while (i < n) {
            sb = new StringBuilder();
            prev = result.charAt(0);
            count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == prev) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(prev);
                    prev = result.charAt(j);
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(prev);
            result = sb.toString();
            i++;
        }

        return result;
    }

    private static void test() {
        Utils.printTestln(countAndSay(5), "111221");
    }

    public static void main(String[] args) {
        test();
    }
}
