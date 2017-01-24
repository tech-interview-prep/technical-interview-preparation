package leetcode.algorithms;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 *     ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *     ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * http://www.programcreek.com/2012/12/leetcode-evaluate-reverse-polish-notation/
 * http://n00tc0d3r.blogspot.com/2013/08/evaluate-postfix-expression.html
 */
public class _150EvaluateReversePolishNotation {

}

class Solution_EvaluateReversePolishNotation {

    /**
     * After understanding the problem, we should quickly realize that this problem can be solved by using a stack.
     * We can loop through each element in the given array. When it is a number, push it to the stack. When it is an
     * operator, pop two numbers from the stack, do the calculation, and push back the result.
     */
    public int evalRPN(String[] tokens) {

        int returnValue = 0;

        String operators = "+-*/";

        Stack<String> stack = new Stack<String>();

        for (String t : tokens) {
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch (index) {
                case 0:
                    stack.push(String.valueOf(a + b));
                    break;
                case 1:
                    stack.push(String.valueOf(b - a));
                    break;
                case 2:
                    stack.push(String.valueOf(a * b));
                    break;
                case 3:
                    // talk to interviewer on how to handle divide by zero
                    stack.push(String.valueOf(b / a));
                    break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());

        return returnValue;

    }
}
