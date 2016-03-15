package leetcode_online_judge;

import utils.Utils;

import java.util.Map;
import java.util.HashMap;

public class IntegerToRoman {
    /*
    Given an integer, convert it to a roman numeral.

    Input is guaranteed to be within the range from 1 to 3999.
     */
    public static String intToRoman(int num) {
        Map<Integer, Character> map = new HashMap<Integer, Character>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');

        String ret = "";

        int digits = num % 10;
        ret = getRoman(digits, 'I', 'V', 'X');

        digits = (num % 100) / 10;
        ret = getRoman(digits, 'X', 'L', 'C') + ret;

        digits = (num % 1000) / 100;
        ret = getRoman(digits, 'C', 'D', 'M') + ret;

        digits = num / 1000;
        ret = padding('M', digits) + ret;
        
        return ret;
    }

    private static String getRoman(int digit, char i, char v, char x) {
        StringBuffer ret = new StringBuffer();
        if (digit < 5) {
            return digit == 4 ? ret.append(i).append(v).toString() : padding(i, digit);
        } else if (digit == 5) {
            return ret.append(v).toString();
        } else if (digit == 9) {
            return ret.append(i).append(x).toString();
        }

        return ret.append(v).append(getRoman(digit - 5, i, v, x)).toString();
    }

    private static String padding(char c, int n) {
        StringBuffer  sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }

        return sb.toString();
    }

    private static void test() {
        Utils.printTestln(intToRoman(1954), "MCMLIV");
        Utils.printTestln(intToRoman(1990), "MCMXC");
        Utils.printTestln(intToRoman(5), "V");
    }

    public static void main(String[] args) {
        test();
    }
}
