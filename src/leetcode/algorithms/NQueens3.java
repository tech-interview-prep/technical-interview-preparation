package leetcode.algorithms.level.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class NQueens3 {
    /*
    The n-queens puzzle is the problem of placing n queens on an n?n chessboard such that no two queens attack each other.

    // see 8-queens.png

    Given an integer n, return all distinct solutions to the n-queens puzzle.

    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
    queen and an empty space respectively.

    For example,
    There exist two distinct solutions to the 4-queens puzzle:

    [
     [".Q..",  // Solution 1
      "...Q",
      "Q...",
      "..Q."],

     ["..Q.",  // Solution 2
      "Q...",
      "...Q",
      ".Q.."]
    ]
    */
    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> ret = new ArrayList<String[]>();
        solveNQueens(n, 0, ret, new HashMap<Integer, Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
        return ret;

    }

    // x_1 + y_1 == x_2 + y_2 or x_1 - y_1 == x_2 - y_2 means those two points diagnally meet
    private static void solveNQueens(int n, int row, ArrayList<String[]> ret, Map<Integer, Integer> col2Row,
                                     Set<Integer> diff, Set<Integer> sum) {
        if (row == n)  {
            ret.add(convert(col2Row, n));
        }

        for (int col = 0; col < n; col++) {
            if (!col2Row.containsKey(col) && !diff.contains(col - row) && !sum.contains(col + row)) {
                col2Row.put(col, row);
                diff.add(col - row);
                sum.add(col + row);
                solveNQueens(n, row + 1, ret, col2Row, diff, sum);
                col2Row.remove(col);
                diff.remove(col - row);
                sum.remove(col + row);
            }
        }
    }

    private static String[] convert(Map<Integer, Integer> col2Row, int n) {
        String[] board = new String[n];
        for (int k : col2Row.keySet()) {
            char[] chars = new char[n];
            for (int i = 0; i < n; i++) {
                chars[i] = '.';
                chars[k] = 'Q';
            }
            board[col2Row.get(k)] = new String(chars);
        }
        return board;
    }

    private static void test() {
        Utils.printListArrayln(solveNQueens(4), "\n");
    }

    public static void main(String[] args) {
        test();
    }
}
