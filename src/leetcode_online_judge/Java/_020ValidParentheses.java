package leetcode_online_judge.Java;

import utils.Utils;

import java.util.Stack;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _020ValidParentheses {
    /*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
    */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0, l = s.length(); i < l; i++) {
            char c = s.charAt(i);
            if ( c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty() || !doesMatch(stack.pop(), c)) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean doesMatch(char left, char right) {
        switch (left) {
            case '(': return right == ')';
            case '[': return right == ']';
            case '{': return right == '}';
            default: return false;
        }
    }

    private static void test() {
        Utils.printTestln(isValid("()[]{}"), true);
        Utils.printTestln(isValid("([)]"), false);
        Utils.printTestln(isValid("("), false);
        Utils.printTestln(isValid("]"), false);
    }

    public static void main(String[] args) {
        test();
    }
}
