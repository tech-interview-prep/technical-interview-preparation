package leetcode_online_judge.Java;

import utils.Utils;

public class _065ValidNumber {
    /*
    Validate if a given string is numeric.

    Some examples:
    "0" => true
    " 0.1 " => true
    "abc" => false
    "1 a" => false
    "2e10" => true
    Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
     */
    public static boolean isNumber(String s) {
        int index;
        char c;
        boolean hasPoint = false, hasExp = false, hasSign = false, hasNumber = false;

        for (index = s.length() - 1; index >= 0 && s.charAt(index) == ' '; index--);

        for (; index >= 0 && (c = s.charAt(index)) != ' '; index--) {
            if ( c == 'e') {
                if (hasExp || hasPoint || !hasNumber) {
                    return false;
                }
                hasExp = true;
                hasNumber = false;
                hasSign = false;
            } else if ( c == '.') {
                if (hasPoint || hasSign) {
                    return false;
                }
                hasPoint = true;
            } else if ( c == '+' || c == '-') {
                if (hasSign || !hasNumber) {
                    return false;
                }
                hasSign = true;
            } else if (c > '9' || c < '0') {
                return false;
            } else if (!hasSign) {
                hasNumber = true;
            } else {
                return false;
            }
        }

        for (; index >= 0 && s.charAt(index) == ' '; index--);

        return index == -1 && hasNumber;
    }

    private static void test() {
        Utils.printTestln(isNumber("0"), true);
        Utils.printTestln(isNumber("0.1"), true);
        Utils.printTestln(isNumber("abc"), false);
        Utils.printTestln(isNumber("1 a"), false);
        Utils.printTestln(isNumber("2e10"), true);
        Utils.printTestln(isNumber("    "), false);
        Utils.printTestln(isNumber("+"), false);
        Utils.printTestln(isNumber("-"), false);
        Utils.printTestln(isNumber("-.1"), true);
        Utils.printTestln(isNumber("a"), false);
        Utils.printTestln(isNumber("1e"), false);
        Utils.printTestln(isNumber("e+3"), false);
        Utils.printTestln(isNumber("e-3"), false);
        Utils.printTestln(isNumber("6+1"), false);
        Utils.printTestln(isNumber(".-4"), false);
    }

    public static void main(String[] args) {
        test();
    }
}
