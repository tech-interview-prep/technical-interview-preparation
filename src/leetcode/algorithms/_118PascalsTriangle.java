package leetcode.algorithms;

import java.util.ArrayList;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _118PascalsTriangle {
    /*
    Given numRows, generate the first numRows of Pascal's triangle.

    For example, given numRows = 5,
    Return

    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
    */
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) {
            return ret;
        }
        ArrayList<Integer> row = new ArrayList<Integer>(), preRow;
        row.add(1);
        ret.add(row);

        for (int i = 1; i < numRows; i++) {
            row = new ArrayList<Integer>();
            preRow = ret.get(i - 1);
            row.add(1);
            for (int j = 0, l = preRow.size(); j < l - 1; j++) {
                row.add(preRow.get(j) + preRow.get(j + 1));
            }
            row.add(1);
            ret.add(row);
        }
        return ret;
    }

    private static void test() {
        Utils.printListListln(generate(5));
    }

    public static void main(String[] args) {
        test();
    }
}
