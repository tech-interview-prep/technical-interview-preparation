package leetcode_online_judge.Java;

import utils.Utils;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _077Combinations {
    /*
    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

    For example,
    If n = 4 and k = 2, a solution is:

    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
    */
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        for (int i = 1; i <= n - k + 1; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(i);
            ret.add(tmp);
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 0, l = ret.size(); j < l; j++) {
                ArrayList<Integer> comb = ret.get(j);
                int lastInt = comb.get(comb.size() - 1);
                for (int m = lastInt + 2; m <= n - k + i; m++) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>(comb);
                    tmp.add(m);
                    ret.add(tmp);
                }
                comb.add(lastInt + 1);
            }
        }

        return ret;
    }

    //recursion version
    public static ArrayList<ArrayList<Integer>> combine2(int n, int k) {
        ArrayList<ArrayList<Integer>> ret;

        if (n == k) {
            ret = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> comb = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                comb.add(i);
            }

            ret.add(comb);
            return ret;
        }

        if (k == 1) {
            ret = new ArrayList<ArrayList<Integer>>();
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> comb = new ArrayList<Integer>();
                comb.add(i);
                ret.add(comb);
            }
            return ret;
        }

        ret = combine2(n - 1, k - 1);
        for (ArrayList<Integer> al : ret) {
            al.add(n);
        }

        ret.addAll(combine2(n - 1, k));
        return ret;
    }

    private static void test() {
        Utils.printListListln(combine(4, 2));

        System.out.println("\n>>>Below is the recursion version:\n");

        Utils.printListListln(combine2(4, 2));
    }

    public static void main(String[] args) {
        test();
    }
}
