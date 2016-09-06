    /*
        Given "n", generate all valid parenthesis strings of length "2n".

        Example:
        Given n=2

        Output:
        (())
        ()()

        Link: http://www.careercup.com/question?id=6234634354425856

    */
package facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class GenerateValidParantheses {
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
}
