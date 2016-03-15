package leetcode_online_judge;

import utils.Utils;

import java.util.Map;
import java.util.HashMap;

public class RomanToInteger {
    /*
    Given a roman numeral, convert it to an integer.

    Input is guaranteed to be within the range from 1 to 3999.
     */
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int lastNum = 0, currentNum, sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            currentNum = map.get(s.charAt(i));
            if (currentNum < lastNum) {
                sum -= currentNum;
            } else {
                sum += currentNum;
            }
            lastNum = currentNum;
        }
        return sum;
    }

    private static void test() {
        Utils.printTestln(romanToInt("MCMLIV"), 1954);
        Utils.printTestln(romanToInt("MCMXC"), 1990);
        Utils.printTestln(romanToInt("V"), 5);
    }

    public static void main(String[] args) {
        test();
    }
}
