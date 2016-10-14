package facebook;

/**
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask
 * yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible
 * to gather all the input requirements up front.
 *
 * Update (2015-02-10):
 *
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const
 * char * argument, please click the reload button  to reset your code definition.
 *
 * Requirements for atoi:
 *     The function first discards as many whitespace characters as necessary until the first non-whitespace character
 *     is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many
 *     numerical digits as possible, and interprets them as a numerical value.
 *
 *     The string can contain additional characters after those that form the integral number, which are ignored and
 *     have no effect on the behavior of this function.
 *
 *     If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
 *     exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 *     If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of
 *     representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 * https://leetcode.com/problems/string-to-integer-atoi/
 * http://www.geeksforgeeks.org/write-your-own-atoi/
 * http://www.geeksforgeeks.org/implement-itoa/
 * http://n00tc0d3r.blogspot.com/2013/06/string-to-integer-atoi.html
 */
public class _008StringToIntegerAtoI {
    public static void main(String[] args) {

    }
}

class Solution_AtoI {
    public static int atoi(String s) {
        char[] chars = s.toCharArray();

        int current = 0;
        char sign = '+';

        //discard blanks
        while (current < s.length() && chars[current] == ' ' ) {
            current++;
        }
        //reach the end, return 0
        if (current == s.length())
            return 0;

        char c = chars[current];
        //check the first non-zero char
        if (c != '-' && c != '+' && (c <= 48 || c > 57))
            return 0;

        if (c == '-')
            sign = '-';

        if (c == '-' || c == '+')
            current++;

        //reach the end or non-1-9, return 0
        if (current >= s.length() || chars[current] <= 48 || chars[current] > 57)
            return 0;

        long result = 0;
        while (current < s.length() && chars[current] >= 48 && chars[current] <= 57) {
            result = result * 10 + chars[current] - 48;
            if (result >= Integer.MAX_VALUE && sign == '+')
                return Integer.MAX_VALUE;
            if (result - 1 >= Integer.MAX_VALUE && sign == '-')
                return Integer.MIN_VALUE;
            current++;
        }

        if (sign == '-')
            result = result * -1;

        return  Long.valueOf(result).intValue();
    }
}
