package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _032LongestValidParentheses {
    /*
    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

    For "(()", the longest valid parentheses substring is "()", which has length = 2.

    Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
     */
    public static int longestValidParentheses(String s) {
        int leftMax = 0, rightMax = 0, rightCount = 0, leftCount = 0, l = s.length();

        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
                if (leftCount == rightCount) {
                    leftMax = Math.max(leftMax, leftCount * 2);
                } else if (leftCount < rightCount) {
                    leftCount = rightCount = 0;
                }
            }
        }

        leftCount = rightCount = 0;
        for (int i = l - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                rightCount++;
            } else {
                leftCount++;
                if (leftCount == rightCount) {
                    rightMax = Math.max(rightMax, leftCount * 2);
                } else if (leftCount > rightCount) {
                    leftCount = rightCount = 0;
                }
            }
        }

        return Math.max(leftMax, rightMax);
    }

    private static void test() {
        Utils.printTestln(longestValidParentheses(")()())"), 4);
        Utils.printTestln(longestValidParentheses("(()"), 2);
        Utils.printTestln(longestValidParentheses(")()())"), 4);
        Utils.printTestln(longestValidParentheses(")(((((()())()()))()(()))("), 22);
        Utils.printTestln(longestValidParentheses("()(()"), 2);
        Utils.printTestln(longestValidParentheses("))))())()()(()"), 4);
    }

    public static void main(String[] args) {
        test();
    }
}
