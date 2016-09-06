package leetcode_online_judge.Java;

import utils.Utils;

import java.util.*;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _018_4Sum {
    /*
    Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all
    unique quadruplets in the array which gives the sum of target.

    Note:
    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ? b ? c ? d)
    The solution set must not contain duplicate quadruplets.
        For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

        A solution set is:
        (-1,  0, 0, 1)
        (-2, -1, 1, 2)
        (-2,  0, 0, 2)
     */
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        if (num.length < 4) {
            return ret;
        }

        Map<Integer, List<Integer>> sumIdx = new HashMap<Integer, List<Integer>>();
        int sum;
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                sum = num[i] + num[j];
                if (!sumIdx.containsKey(sum)){
                    sumIdx.put(sum, new ArrayList<Integer>());
                }
                sumIdx.get(sum).add(i);
                sumIdx.get(sum).add(j);
            }
        }

        for (int k : sumIdx.keySet()) {
            if (sumIdx.containsKey(target - k)) {
                mergeList(num, sumIdx.get(k), sumIdx.get(target - k), ret);
            }
        }

        removeDuplicates(ret);

        return ret;
    }

    private static void mergeList(int[] num, List<Integer> list1, List<Integer> list2, ArrayList<ArrayList<Integer>> ret) {
        for (int i = 0, l = list1.size(); i < l; i += 2) {
            for (int j = 0, m = list2.size(); j < m; j += 2) {
                if (!hasCommon(list1.get(i), list1.get(i + 1), list2.get(j), list2.get(j + 1))) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[list1.get(i)]);
                    tmp.add(num[list1.get(i + 1)]);
                    tmp.add(num[list2.get(j)]);
                    tmp.add(num[list2.get(j + 1)]);
                    Collections.sort(tmp);
                    ret.add(tmp);
                }
            }
        }
    }

    private static boolean hasCommon(int a1, int a2, int b1, int b2) {
         return a1 == b1 || a1 == b2 || a2 == b1 || a2 == b2;
    }

    private static void removeDuplicates(ArrayList<ArrayList<Integer>> ret) {
        int l = ret.size();
        if (l == 0) {
            return;
        }

        Collections.sort(ret, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
                int i;
                for (i = 0; i < 3 && list1.get(i).equals(list2.get(i)); i++);
                return list1.get(i) - list2.get(i);
            }
        });

        ArrayList<Integer> first = ret.get(0);
        for (int i = 1; i < ret.size(); ) {
            if (equals(first, ret.get(i))) {
                ret.remove(i);
            } else {
                first = ret.get(i);
                i++;
            }
        }
    }

    private static boolean equals(List<Integer> l1, List<Integer> l2) {
        for(int i = 0; i < 4; i++) {
            if (!l1.get(i).equals(l2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static void test() {
        for (List<Integer> ilist : fourSum(new int[]{-5, 5, 4, -3, 0 , 0, 4, -2}, 4)) {
            Utils.printIntListln(ilist);
        }

        for (List<Integer> ilist : fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)) {
            Utils.printIntListln(ilist);
        }

        for (List<Integer> ilist : fourSum(new int[]{0, 0, 0, 0}, 1)) {
            Utils.printIntListln(ilist);
        }

        for (List<Integer> ilist : fourSum(new int[]{0, 0, 0}, 0)) {
            Utils.printIntListln(ilist);
        }

        for (List<Integer> ilist : fourSum(new int[]{-493,-470,-464,-453,-451,-446,-445,-407,-406,-393,-328,-312,-307,
                -303,-259,-253,-252,-243,-221,-193,-126,-126,-122,-117,-106,-105,-101,-71,-20,-12,3,4,20,20,54,84,98,
                111,148,149,152,171,175,176,211,218,227,331,352,389,410,420,448,485}, 1057)) {
            Utils.printIntListln(ilist);
        }
    }

    public static void main(String[] args) {
        test();
    }
}
