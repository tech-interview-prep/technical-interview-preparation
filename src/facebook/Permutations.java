package facebook;

import java.util.ArrayList;

public class Permutations {
    /**
     * Given a collection of numbers, return all possible permutations.
     *
     * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
     *
     * https://gist.github.com/zac-xin/4389639
     */
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        return permuteHelper(num, 0);
    }

    public ArrayList<ArrayList<Integer>> permuteHelper(int num[], int index) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (index == num.length - 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(num[index]);
            result.add(list);
            return result;
        } else {
            ArrayList<ArrayList<Integer>> partial = permuteHelper(num, index + 1);
            for (ArrayList<Integer> list : partial) {
                for (int i = 0; i <= list.size(); i++) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>(list);
                    tmp.add(i, num[index]);
                    result.add(tmp);
                }
            }
            return result;
        }
    }

    /**
     * Write a method to compute all permutations of a string
     *
     * https://gist.github.com/zac-xin/3936286
     */

    public static ArrayList<String> getAllPermutations(String input) {
        if (input == null)
            return null;
        ArrayList<String> result = new ArrayList<String>();

        if (input.length() == 0) {
            result.add("");
            return result;
        }

        char c = input.charAt(0);
        String remainder = input.substring(1);
        ArrayList<String> intermediate = getAllPermutations(remainder);
        for (String s : intermediate) {
            for (int i = 0 ; i <= s.length(); i++) {
                String r = insertCharAt(s, c, i);
                result.add(r);
            }
        }
        return result;
    }

    public static String insertCharAt(String s, char c, int index) {
        String s1 = s.substring(0, index);
        String s2 = s.substring(index);
        return s1 + c + s2;
    }
}
