package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * @author bkoteshwarreddy
 */

public class _013RomanToInteger {
  /**
   * Given a roman numeral, convert it to an integer.
   *
   * Input is guaranteed to be within the range from 1 to 3999.
   */
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

  public static int romanToInt(String s) {
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

  private static void test() {
    Utils.printTestln(romanToInt("MCMLIV"), 1954);
    Utils.printTestln(romanToInt("MCMXC"), 1990);
    Utils.printTestln(romanToInt("V"), 5);
  }

  public static void main(String[] args) {
    test();
  }
}
