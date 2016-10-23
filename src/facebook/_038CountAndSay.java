package facebook;

import utils.Utils;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 *
 * 1, 11, 21, 1211, 111221, ...
 *
 *      1 is read off as "one 1" or 11.
 *      11 is read off as "two 1s" or 21.
 *      21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 *
 * https://leetcode.com/problems/count-and-say/
 * http://n00tc0d3r.blogspot.com/2013/02/count-and-say.html
 */
public class _038CountAndSay {
    public static void main(String[] args) {
        Solution_CountAndSay sol = new Solution_CountAndSay();

        Utils.printTestln(sol.countAndSay(5), "111221");
    }
}

class Solution_CountAndSay {
    public String lookAndSay(int input) {
        if (input < 0) {
            return "";
        }
        String output = "1";
        for (int i = 0; i < input; i++) {
            output = lookAndSay(input, output);
        }
        return output;
    }

    private String lookAndSay(int input, String str) {
        StringBuffer sb = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (last == str.charAt(i)) {
                count++;
            } else {
                sb.append(count);
                sb.append(last);
                last = str.charAt(i);
                count = 1;
            }
        }

        sb.append(count);
        sb.append(last);
        return sb.toString();
    }

    public String countAndSay(int n) {
        if (n == 0) {
            return null;
        }

        String current = "1";

        if (n == 1) {
            return current;
        }

        for (int i = 1; i < n; i++) {
            int count = 1;
            char curChar = current.charAt(0);
            StringBuffer temp = new StringBuffer();

            for (int charIndex = 1; charIndex < current.length(); charIndex++) {
                if (current.charAt(charIndex) == curChar) {
                    count++;
                } else {
                    temp.append(count).append(curChar);
                    count = 1;
                    curChar = current.charAt(charIndex);
                }
            }

            temp.append(count).append(curChar);
            current = temp.toString();
        }

        return current;
    }
}
