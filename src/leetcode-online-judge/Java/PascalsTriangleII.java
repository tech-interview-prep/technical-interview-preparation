package leetcode_online_judge;

import utils.Utils;

import java.util.ArrayList;

public class PascalsTriangleII {
    /*
    Pascal's Triangle II Total Accepted: 3919 Total Submissions: 13385 My Submissions
    Given an index k, return the kth row of the Pascal's triangle.

    For example, given k = 3,
    Return [1,3,3,1].

    Note:
    Could you optimize your algorithm to use only O(k) extra space?
    */

    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ret.add(1);
        for (int i = 0; i < rowIndex; i++) {
            int pre = ret.get(0);
            for (int j = 1, l = ret.size(); j < l; j++) {
                ret.set(j, pre + (pre = ret.get(j)));
            }
            ret.add(1);
        }
        return ret;
    }

    private static void test() {
        Utils.printListln(getRow(3));
        Utils.printListln(getRow(6));
    }

    public static void main(String[] args) {
        test();
    }
}
