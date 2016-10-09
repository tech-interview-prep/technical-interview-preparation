package uber;

import java.util.ArrayList;

import utils.Utils;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * @author bkoteshwarreddy
 */
public class _022GenerateParentheses {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     *  For example, given n = 3, a solution set is:
     *
     *  "((()))", "(()())", "(())()", "()(())", "()()()"
     */
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<String>();
        generateParenthesis(n, 1, 0, "(", ret);
        return ret;
    }

    public static void generateParenthesis(int n, int i, int j, String prefix, ArrayList<String> ret) {
        if (j == n) {
            ret.add(prefix);
            return;
        }

        if (i > j) {
            generateParenthesis(n, i, j + 1, prefix + ")", ret);
        }

        if (i < n) {
            generateParenthesis(n, i + 1, j, prefix + "(", ret);
        }
    }

    private static void test() {
        Utils.printListln(generateParenthesis(3));
    }

    public static void main(String[] args) {
        test();
    }
}
