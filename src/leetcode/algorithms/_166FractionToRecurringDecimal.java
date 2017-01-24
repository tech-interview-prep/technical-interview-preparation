package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bkoteshwarreddy
 */
public class _166FractionToRecurringDecimal {
    /*
    Fraction to Recurring Decimal
        Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

        If the fractional part is repeating, enclose the repeating part in parentheses.

        For example,

        Given numerator = 1, denominator = 2, return "0.5".
        Given numerator = 2, denominator = 1, return "2".
        Given numerator = 2, denominator = 3, return "0.(6)".
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)
            return "NULL";

        long num = numerator > 0 ? numerator : -(long)numerator;
        long den = denominator > 0 ? denominator : -(long)denominator;
        StringBuilder sb = new StringBuilder();
        if (1.0 * numerator / denominator < 0)
            sb.append('-');

        sb.append(num / den);
        num %= den;
        if (num == 0)
            return sb.toString();
        sb.append('.');

        int i = sb.length();
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while (num > 0) {
            if (map.containsKey(num)) {
                int t = map.get(num);
                sb.insert(t, '(');
                sb.append(')');
                return sb.toString();
            }
            map.put(num, i++);
            num *= 10;
            sb.append(num / den);
            num %= den;
        }
        return sb.toString();
    }
}
