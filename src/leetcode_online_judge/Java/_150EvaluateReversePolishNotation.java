package leetcode_online_judge.Java;

import java.util.Stack;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _150EvaluateReversePolishNotation {
    /*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.

    Valid operators are +, -, *, /. Each operand may be an integer or another expression.

    Some examples:
      ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
      ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int op1, op2;
        for (String s : tokens) {
            if ("+".equals(s) || "-".equals(s) || "/".equals(s) || "*".equals(s)) {
                op2 = stack.pop();
                op1 = stack.pop();
                switch (s.charAt(0)) {
                case '+' : stack.push(op1 + op2); break;
                case '-' : stack.push(op1 - op2); break;
                case '*' : stack.push(op1 * op2); break;
                case '/' : stack.push(op1 / op2); break;
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    private static void test() {
        Utils.printTestln(evalRPN(new String[] {"2", "1", "+", "3", "*"}), 9);
        Utils.printTestln(evalRPN(new String[] {"4", "13", "5", "/", "+"}), 6);
    }

    public static void main(String[] args) {
        test();
    }
}
