package facebook;

import java.util.HashMap;

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

/**
 * int: 1000, 900, 500, 400, 100, 90, 50,  40,  10,  9,  5,  4,  1
 * roman: "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
 */
class Solution_RomanToInteger {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int length = s.length();
        int result = map.get(s.charAt(length - 1));
        for (int i = length - 2; i >= 0; i--) {
            if (map.get(s.charAt(i + 1)) <= map.get(s.charAt(i))) {
                result += map.get(s.charAt(i));
            } else {
                result -= map.get(s.charAt(i));
            }
        }
        return result;
    }
}
