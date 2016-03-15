package leetcode_online_judge;

import utils.Utils;

import java.util.ArrayList;

public class Permutations {
    /*
    Given a collection of numbers, return all possible permutations.

    For example,
    [1,2,3] have the following permutations:
    [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
    */
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        permute(num, 0, ret);
        return ret;
    }

    private static void permute(int[] num, int start, ArrayList<ArrayList<Integer>> ret) {
        if (start == num.length - 1) {
            ArrayList<Integer> buf = new ArrayList<Integer>();
            for (int i : num) {
                buf.add(i);
            }
            ret.add(buf);
        }

        for (int i = start; i < num.length; i++) {
            swap(num, start, i);
            permute(num, start + 1, ret);
            swap(num, start, i);
        }
    }

    private static void swap(int[] num, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    private static void test() {
        Utils.printListListln(permute(new int[]{1, 2, 3}));
    }

    public static void main(String[] args) {
        test();
    }

}
