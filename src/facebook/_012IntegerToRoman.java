package facebook;

import utils.Utils;

/**
 * Given an integer, convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * https://leetcode.com/problems/palindrome-number/
 * http://n00tc0d3r.blogspot.com/2013/03/integer-and-roman-numeral.html
 */
public class _012IntegerToRoman {
    public static void main(String[] args) {
        Solution_IntegerToRoman sol = new Solution_IntegerToRoman();
        Utils.printTestln(sol.intToRoman(1954), "MCMLIV");
        Utils.printTestln(sol.intToRoman(1990), "MCMXC");
        Utils.printTestln(sol.intToRoman(5), "V");
    }
}

class Solution_IntegerToRoman {
    private static int index = 0;
    private static char[] result = new char[15];

    public String intToRoman(int num) {
        index = 0;
        if (num > 999) {
            if (num > 2999) {
                result[index++] = 'M';
                result[index++] = 'M';
            } else if (num > 1999)
                result[index++] = 'M';
            result[index++] = 'M';
            num = num % 1000;
        }
        if (num > 99) {
            ten(result, num / 100, 'M', 'D', 'C');
            num = num % 100;
        }
        if (num > 9) {
            ten(result, num / 10, 'C', 'L', 'X');
            num = num % 10;
        }
        ten(result, num, 'X', 'V', 'I');
        return new String(result, 0, index);
    }

    public static char[] ten(char[] result, int val, char f1, char f2, char f3) {
        if (val > 8) {
            result[index++] = f3;
            result[index++] = f1;
        } else if (val > 5) {
            result[index++] = f2;
            while (val-- > 5) result[index++] = f3;
        } else if (val > 4) {
            result[index++] = f2;
        } else if (val == 4) {
            result[index++] = f3;
            result[index++] = f2;
        } else while (val-- > 0) result[index++] = f3;
        return result;
    }

    // ------------------------------------------------------------------------ //

    public String intToRoman2(int num) {
        if (num < 1 || num > 3999) {
            return "INVALID";
        }

        String[] s = {
            "M", "CM", "D", "CD", "C", "XC",
            "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] u = {
            1000, 900, 500, 400, 100, 90,
            50, 40, 10, 9, 5, 4, 1
        };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 13; i++) {
            while (num >= u[i]) {
                sb.append(s[i]);
                num -= u[i];
            }
        }

        return sb.toString();
    }
}
