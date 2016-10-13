package facebook;

import java.util.ArrayList;
import java.util.Arrays;

import utils.Utils;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 *
 * For example,
 * If S = [1,2,2], a solution is:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * https://leetcode.com/problems/subsets-ii/
 */
public class _090SubsetII {
    public static void main(String[] args) {
        Solution_SubsetII sol = new Solution_SubsetII();
        for (ArrayList<Integer> il : sol.subsetsWithDup(new int[] {1, 2, 2})) {
            Utils.printIntListln(il);
        }
    }
}

class Solution_SubsetII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.add(new ArrayList<Integer>());
        Arrays.sort(num);
        int pre = num.length == 0 || num[0] == 0 ? 1 : num[0] >> 1, lastUpdateIdx = 0, startIdx;

        for (int i = 0 ; i < num.length; i++) {
            startIdx = pre == num[i] ? lastUpdateIdx : 0;
            pre = num[i];
            lastUpdateIdx = ret.size();
            for (int j = startIdx; j < lastUpdateIdx; j++) {
                ArrayList<Integer> set = new ArrayList<Integer>(ret.get(j));
                set.add(num[i]);
                ret.add(set);
            }
        }

        return ret;
    }
}
