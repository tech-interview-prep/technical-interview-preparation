package uber;

import java.util.ArrayList;
import java.util.Arrays;

import utils.Utils;

/**
 * https://leetcode.com/problems/combination-sum/
 * @author bkoteshwarreddy
 */
public class _039CombinationSum {
    /*
    Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

    The same repeated number may be chosen from C unlimited number of times.

    Note:
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 � a2 � � � ak).
    The solution set must not contain duplicate combinations.
    For example, given candidate set 2,3,6,7 and target 7,
    A solution set is:
    [7]
    [2, 2, 3]
     */
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, candidates.length - 1, target);
    }

    private static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int end, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        if (end < 0 || target < 0) {
            return ret;
        }

        if (candidates[end] == target) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(target);
            ret.add(tmp);
        }

        ret.addAll(combinationSum(candidates, end - 1, target));

        for (ArrayList<Integer> iL : combinationSum(candidates, end, target - candidates[end])) {
            ret.add(iL);
            iL.add(candidates[end]);
        }

        return ret;
    }

    private static void test() {
        Utils.printListListln(combinationSum(new int[] {2, 3 , 6, 7}, 7));
    }

    public static void main(String[] args) {
        test();
    }

}
