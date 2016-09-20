/**
 * @author bkoteshwarreddy
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * https://leetcode.com/problems/valid-parentheses/
 * 
 */

package facebook;

import utils.Utils;
import java.util.Stack;

public class _020ValidParentheses {
  public static void main(String[] args) {
    Solution_ValidParentheses sol = new Solution_ValidParentheses();

    Utils.printTestln(sol.isValid("()[]{}"), true);
    Utils.printTestln(sol.isValid("([)]"), false);
    Utils.printTestln(sol.isValid("("), false);
    Utils.printTestln(sol.isValid("]"), false);
  }
}

class Solution_ValidParentheses {
  public boolean isValid(String s) {
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
}
