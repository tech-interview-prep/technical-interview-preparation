package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * @author bkoteshwarreddy
 */

public class _008StringToInteger {
  /* Implement atoi to convert a string to an integer.
   *
   * Hint: Carefully consider all possible input cases. If you want a challenge, please
   * do not see below and ask yourself what are the possible input cases.
   *
   * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
   * You are responsible to gather all the input requirements up front.
   *
   * spoilers alert... click to show requirements for atoi.
   *
   * Requirements for atoi:
   * The function first discards as many whitespace characters as necessary until the first
   * non-whitespace character is found. Then, starting from this character, takes an optional
   * initial plus or minus sign followed by as many numerical digits as possible, and interprets
   * them as a numerical value.
   *
   * The string can contain additional characters after those that form the integral number,
   * which are ignored and have no effect on the behavior of this function.
   *
   * If the first sequence of non-whitespace characters in str is not a valid integral number,
   * or if no such sequence exists because either str is empty or it contains only whitespace
   * characters, no conversion is performed.
   *
   * If no valid conversion could be performed, a zero value is returned. If the correct value
   * is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648)
   * is returned.
   *
   */

  public static int atoi(String str) {
    long ret = 0;
    boolean isNegative = false;
    int index, length = str.length();

    for (index = 0; index < length && str.charAt(index) == ' '; index++);

    if (index < length && str.charAt(index) == '-') {
      isNegative = true;
      index++;
    } else if (index < length && str.charAt(index) == '+') {
      index++;
    }

    for (; index < length && str.charAt(index) <= '9' && str.charAt(index) >= '0'; index++) {
      ret = ret * 10 + str.charAt(index) - '0';
      if (!isNegative && ret > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }

      if (isNegative && ret - 1 > Integer.MAX_VALUE) {
        return Integer.MIN_VALUE;
      }
    }

    return isNegative ? -(int)ret : (int)ret;
  }


  private static void test() {
    Utils.printTestln(atoi(""), 0);
    Utils.printTestln(atoi("123"), 123);
    Utils.printTestln(atoi("-123"), -123);
    Utils.printTestln(atoi("-123fg"), -123);
    Utils.printTestln(atoi("+123"), 123);
    Utils.printTestln(atoi("    10522545459"), Integer.MAX_VALUE);
    Utils.printTestln(atoi("2147483647"), Integer.MAX_VALUE);
    Utils.printTestln(atoi("-2147483648"), Integer.MIN_VALUE);
  }

  public static void main(String[] args) {
    test();
  }
}
