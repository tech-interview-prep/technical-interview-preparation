package leetcode.algorithms;

import utils.Utils;

/**
 * Given an integer, convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 
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
    public String intToRoman(int num) {
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
