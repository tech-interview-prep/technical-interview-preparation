package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 *      All numbers (including target) will be positive integers.
 *      The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 *
 * A solution set is:
 *
 * [7]
 * [2, 2, 3]
 *
 * https://leetcode.com/problems/combination-sum/
 * http://n00tc0d3r.blogspot.com/2013/01/combination-sum.html
 * @author bkoteshwarreddy
 */
public class _039CombinationSum {
    public static void main(String[] args) {
        Solution_CombinationSum sol = new Solution_CombinationSum();
        Utils.printListListln(sol.combinationSum(new int[] {2, 3 , 6, 7}, 7));
    }
}

class Solution_CombinationSum {
    public void dfs(List<List<Integer>> res, List<Integer> cur, int[] candidates, int idx, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = idx; i >= 0; --i) {
            cur.add(candidates[i]);
            dfs(res, cur, candidates, i, target - candidates[i]);
            cur.remove(cur.size() - 1);
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // backtracking
        dfs(res, new ArrayList<Integer>(), candidates, candidates.length - 1, target);
        return res;

    }
}
