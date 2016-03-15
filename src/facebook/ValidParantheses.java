package facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class ValidParantheses {
    /*
        Given "n", generate all valid parenthesis strings of length "2n".

        Example:
        Given n=2

        Output:
        (())
        ()()

        Link: http://www.careercup.com/question?id=6234634354425856

    */
    public ArrayList<String> generateParens(int count) {
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, str, 0);
        return list;
    }

    public void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count) {
        if (leftRem < 0 || rightRem < leftRem) return; // invalid state

        if (leftRem == 0 && rightRem == 0) { /* all out of left and right parentheses */
            String s = String.copyValueOf(str);
            list.add(s);
        } else {
            if (leftRem > 0) { // try a left paren, if there are some available
                str[count] = '(';
                addParen(list, leftRem - 1, rightRem, str, count + 1);
            }
            if (rightRem > leftRem) { // try a right paren, if there’s a matching left
                str[count] = ')';
                addParen(list, leftRem, rightRem - 1, str, count + 1);
            }
        }
    }

    /*
        Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input
        string is valid. The brackets must close in the correct order, "()" and "()[]{}" are all
        valid but "(]" and "([)]" are not.

        Link: https://gist.github.com/zac-xin/4391624

    */
    public boolean isValid(String s) {
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
