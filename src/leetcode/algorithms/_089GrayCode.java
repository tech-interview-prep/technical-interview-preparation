package leetcode.algorithms;

import java.util.ArrayList;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _089GrayCode {
    /*
    The gray code is a binary numeral system where two successive values differ in only one bit.

    Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
    A gray code sequence must begin with 0.

    For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

    00 - 0
    01 - 1
    11 - 3
    10 - 2
    Note:
    For a given n, a gray code sequence is not uniquely defined.

    For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

    For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
    */
    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (n == 0) {
            ret.add(0);
            return ret;
        }
        ret = grayCode(n - 1);
        for (int i = ret.size() - 1, leftOne = (int)Math.pow(2, n - 1); i >= 0; i--) {
            ret.add(ret.get(i) + leftOne);
        }
        return ret;
    }

    public static ArrayList<Integer> grayCode2(int n) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ret.add(0);

        for (int i = 0; i < n; i++) {
            for (int j = ret.size() - 1, leftOne = (int)Math.pow(2, i); j >= 0; j--) {
                ret.add(leftOne + ret.get(j));
            }
        }

        return ret;
    }

    private static void test() {
        Utils.printListln(grayCode(2));
        Utils.printListln(grayCode2(2));
    }

    public static void main(String[] args) {
        test();
    }
}
