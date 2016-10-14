package facebook;

import utils.Utils;

/**
 * Given a Roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * https://leetcode.com/problems/roman-to-integer/
 * http://n00tc0d3r.blogspot.com/2013/03/integer-and-roman-numeral.html
 */
public class _013RomanToInteger {
    public static void main(String[] args) {
        Solution_RomanToInteger sol = new Solution_RomanToInteger();
        Utils.printTestln(sol.romanToInt("MCMLIV"), 1954);
        Utils.printTestln(sol.romanToInt("MCMXC"), 1990);
        Utils.printTestln(sol.romanToInt("V"), 5);
    }
}

class Solution_RomanToInteger {
    private static final int[] vals;
    static {
        vals = new int[256];
        vals['I'] = 1;
        vals['V'] = 5;
        vals['X'] = 10;
        vals['L'] = 50;
        vals['C'] = 100;
        vals['D'] = 500;
        vals['M'] = 1000;
    }

    public int romanToInt(String s) {
        char[] r = s.toCharArray();
        int previousVal = Integer.MAX_VALUE;
        int result = 0;
        int carry = 0;

        for (char c : r) {
            int val = vals[c];
            if (previousVal > val) {
                result += carry;
                carry = val;
            } else if (previousVal == val) {
                carry += val;
            } else {
                carry = -carry + val;
            }
            previousVal = val;
        }

        return result + carry;
    }

    // ------------------------------------------------------------------------ //

    public int romanToInt2(String s) {
        char symbols[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int values[] = {1000, 500, 100, 50, 10, 5, 1};

        if (s.length() == 0) {
            return 0;
        }

        s = s.toUpperCase();

        for (int i = 0; i < symbols.length; i++) {
            int index = s.indexOf(symbols[i]);
            if (index != -1) {
                return values[i] - romanToInt(s.substring(0, index)) + romanToInt(s.substring(index + 1));
            }
        }

        return 0;
    }
}
