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
    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }

        String result = "1";
        char prev;
        int count;
        StringBuilder sb;

        for (int i = 0; i < n ; i++) {
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
        }

        return result;
    }
}
