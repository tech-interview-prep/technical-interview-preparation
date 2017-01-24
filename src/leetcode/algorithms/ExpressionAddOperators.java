package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators
 * (not unary) +, -, or * between the digits so they evaluate to the target value.
 *
 * Examples:
 * "123", 6 -> ["1+2+3", "1*2*3"]
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 *
 * https://leetcode.com/problems/expression-add-operators/
 */
public class ExpressionAddOperators {
}

class Solution_ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        helper(res, target, num, "", 0, 0);
        return res;
    }
    public void helper(List<String> res, int target, String left, String before, long prevNum, long sum) {
        if (sum == target && left.length() == 0) {
            res.add(new String(before));
            return;
        }
        // prune case:
        for (int i = 1; i <= left.length(); ++i) {
            String cur = left.substring(0, i);
            if (cur.length() > 1 && cur.charAt(0) == '0') {
                return;
            }
            long curNum = Long.valueOf(cur);
            // not begin of expression
            if (before.length() != 0) {
                // +, -, *
                helper(res, target, left.substring(i, left.length()), before + "+" + cur, curNum, sum + curNum);
                helper(res, target, left.substring(i, left.length()), before + "-" + cur, -1 * curNum, sum - curNum);
                helper(res, target, left.substring(i, left.length()), before + "*" + cur, prevNum * curNum, sum - prevNum + prevNum * curNum);
            } else {
                // number itself
                helper(res, target, left.substring(i, left.length()), cur, curNum, curNum);
            }
        }
    }
}
