package leetcode.algorithms;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _012IntegerToRoman {
    /*
    Given an integer, convert it to a roman numeral.

    Input is guaranteed to be within the range from 1 to 3999.
     */
    private static int index = 0;
    private static char[] result = new char[15];

    public static String intToRoman(int num) {
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


    private static void test() {
        Utils.printTestln(intToRoman(1954), "MCMLIV");
        Utils.printTestln(intToRoman(1990), "MCMXC");
        Utils.printTestln(intToRoman(5), "V");
    }

    public static void main(String[] args) {
        test();
    }
}
