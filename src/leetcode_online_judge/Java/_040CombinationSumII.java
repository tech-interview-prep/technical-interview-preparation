package leetcode_online_judge.Java;

import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class _040CombinationSumII {
    /*
    Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the
    candidate numbers sums to T.

    Each number in C may only be used once in the combination.

    Note:
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 � a2 � � � ak).
    The solution set must not contain duplicate combinations.
    For example, given candidate set 10,1,2,7,6,1,5 and target 8,
    A solution set is:
    [1, 7]
    [1, 2, 5]
    [2, 6]
    [1, 1, 6]
     */
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        combinationSum2(num, 0, target, ret, new ArrayList<Integer>());
        return ret;
    }

    public static void combinationSum2(int[] num, int start, int target, ArrayList<ArrayList<Integer>> ret,
                                       ArrayList<Integer> current) {
        if (target == 0) {
            ret.add(new ArrayList<Integer>(current));
            return;
        }

        if (start == num.length || target < num[start]) {
            return;
        }

        int nextStart, sum;
        for (nextStart = start + 1, sum = num[start], current.add(num[start]);
             nextStart < num.length && num[nextStart] == num[start];
             current.add(num[nextStart]), sum += num[start], nextStart++);

        for (int i = nextStart; i >= start; i--) {
            combinationSum2(num, nextStart, target - sum, ret, current);
            sum -= num[start];
            if (sum >= 0) {
                current.remove(current.size() - 1);
            }
        }
    }

    private static void test() {
        Utils.printListListln(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public static void main(String[] args) {
        test();
    }
}
