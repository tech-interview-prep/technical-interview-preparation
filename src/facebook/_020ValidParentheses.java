/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

package facebook;

import utils.Utils;

import java.util.HashSet;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * @author bkoteshwarreddy
 */
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

  public boolean isValid2(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() == 0)
            return true;

        if(s.length() % 2 == 1)
            return false;

        Stack<Character> stack = new Stack<Character>();
        HashSet<Character> rightPars = new HashSet<Character>();
        rightPars.add(')');
        rightPars.add('}');
        rightPars.add(']');

        char arr[] = s.toCharArray();

        for(int i = 0; i < s.length(); i++){
            char c = arr[i];
            if(!rightPars.contains(c)){
                stack.push(c);
            }else{
                if(stack.empty())
                    return false;
                char l = stack.pop();
                if( l != getLeft(c))
                    return false;
            }
        }
        return stack.empty();
    }

    public char getLeft(char right){
        if(right == ')')
            return '(';
        if(right == '}')
            return '{';
        if(right == ']')
            return '[';

        return 'a';
    }
}
