/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *
 * Note: The numbers can be arbitrarily large and are non-negative.
 */

package facebook;

import utils.Utils;

/**
 * https://leetcode.com/problems/multiply-strings/
 * @author bkoteshwarreddy
 */
public class _043MultiplyStrings {
  public static void main(String[] args) {
    Solution_MultiplyStrings sol = new Solution_MultiplyStrings();

    Utils.printTestln(sol.multiply("1234", "45"), String.valueOf(1234 * 45));
    Utils.printTestln(sol.multiply("1234", "0"), "0");
  }
}

class Solution_MultiplyStrings {
  public String multiply(String num1, String num2) {
    if (num1 == null || num2 == null) {
      return null;
    }

    final int len1 = num1.length();
    final int len2 = num2.length();

    // digits1 holds the integer array representation of num1
    int[] digits1 = new int[len1];
    // digits2 holds the integer array representation of num2
    int[] digits2 = new int[len2];
    // maximum number of digits of the product is len1+len2+2
    // reason:
    //      num1 < 10^(len1+1), num2 < 10^(len2+1)
    //      so, num1 * num2 < 10 * (len1+len2+2)
    int[] results = new int[len1 + len2 + 1];

    // instead of dealing with characters,
    // we deal with integers for the maximum performance
    for (int i = 0; i < len1; i++) {
      digits1[i] = num1.charAt(i) - '0';
    }

    for (int i = 0; i < len2; i++) {
      digits2[i] = num2.charAt(i) - '0';
    }

    for (int i = len2 - 1; i >= 0; i--) {
      for (int j = len1 - 1; j >= 0; j--) {
        results[i + j + 2] += digits1[j] * digits2[i];
      }
    }

    StringBuilder sb = new StringBuilder(len1 + len2 + 2);

    // now, we process the carries together in one loop
    // if you do this inside the previous loop,
    // you need len1 * len2 operations.
    // Now, we reduce it to len1 + len2
    for (int i = len1 + len2; i > 0; i--) {
      results[i - 1] += results[i] / 10;
      results[i] %= 10;
    }

    // skip leading zeros
    int i = 0;
    while (i < results.length - 1 && results[i] == 0) i++;

    // convert to strings
    while (i < results.length) {
      sb.append(results[i++]);
    }
    return sb.toString();
  }
}
