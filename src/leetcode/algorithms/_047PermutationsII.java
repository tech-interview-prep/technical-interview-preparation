package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _047PermutationsII {
    /*
    Given a collection of numbers that might contain duplicates, return all possible unique permutations.

    For example,
    [1,1,2] have the following unique permutations:
    [1,1,2], [1,2,1], and [2,1,1].
    */
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>>  ret = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) {
            return ret;
        }

        ArrayList<Integer> order = new ArrayList<Integer>();
        for (int i : num) {
            order.add(i);
        }

        Collections.sort(order);
        ret.add(order);

        while (true) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(ret.get(ret.size() - 1));
            int index;
            for (index = tmp.size() - 2; index >= 0 && tmp.get(index) >= tmp.get(index + 1); index--);
            if (index < 0) {
                return ret;
            }
            int minIdx;
            for (minIdx = tmp.size() - 1; minIdx > index && tmp.get(minIdx) <=  tmp.get(index); minIdx--);
            swap(tmp, minIdx, index);
            for (int i = index + 1, j = tmp.size() - 1; i < j; i++, j--) {
                swap(tmp, i, j);
            }
            ret.add(tmp);
        }
    }

    private static void swap(List<Integer> list, int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    private static void test() {
        Utils.printListListln(permuteUnique(new int[] {1, 1, 2}));
        System.out.println();
        Utils.printListListln(permuteUnique(new int[] {1, 2, 3})); //[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    }

    public static void main(String[] args) {
        test();
    }
}
