package leetcode.algorithms.level.Easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all
 * valid but "(]" and "([)]" are not.
 *
 * Tags: Stack, String
 */
class ValidParentheses {

    public static void main(String[] args) {
        ValidParenthese v = new ValidParenthese();
        System.out.println(v.isValid("()"));
        System.out.println(v.isValid("()[]{}"));
        System.out.println(v.isValid("([)]"));
        System.out.println(v.isValid("[({(())}[()])]"));
        System.out.println(v.isValid("a[a(a{a(a(.)a)a}x[a(a)v]w)q]z"));
    }

    /**
     * Use a stack to store the parens
     * If   left paren, push to stack
     * Elif stk is empty, return false
     * Elif matches, pop and go on
     * Else don't match, return false
     */
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if(stack.size() > 0) {
                char p = stack.pop();

                if(((c == '}') && (p != '{')) || ((c == ']') && (p != '[')) || ((c == ')') && (p != '('))) {
                    return false;
                }
            } else {
                return false;
            }

        }

        return stack.size() == 0;
    }
}
