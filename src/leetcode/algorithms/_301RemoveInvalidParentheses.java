package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible
 * results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Examples:
 *     "()())()" -> ["()()()", "(())()"]
 *     "(a)())()" -> ["(a)()()", "(a())()"]
 *     ")(" -> [""]
 *
 * https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class _301RemoveInvalidParentheses {
}

class Solution_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        // bread-first search implemented by queue
        LinkedList<String> queue = new LinkedList<String>();
        HashSet<String> nextqueue = new HashSet<String>();
        List<String> res = new ArrayList<String>();
        queue.addLast(s);
        boolean GoNext = true;
        // FIFO implemented on queue
        while (!queue.isEmpty()) {
            StringBuffer cur = new StringBuffer(queue.pollFirst());
            // this is the last element in the queue
            if (isValid(cur.toString())) {
                GoNext = false;
                res.add(cur.toString());
            } else {
                for (int i = 0; i < cur.length(); ++i) {
                    if (cur.toString().charAt(i) == '(' || cur.toString().charAt(i) == ')') {
                        StringBuffer tmp = new StringBuffer(cur);
                        tmp.deleteCharAt(i);
                        if (!nextqueue.contains(tmp.toString())) {
                            nextqueue.add(tmp.toString());
                        }
                    }
                }
            }
            // if queue is empty:
            // decide whether or not to go to the next level
            if (queue.isEmpty() && GoNext) {
                queue.addAll(nextqueue);
            }
        }
        return res;
    }
    // not stack implementation of "valid parenthese"
    public boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count ++;
            } else if (c == ')') {
                count --;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
