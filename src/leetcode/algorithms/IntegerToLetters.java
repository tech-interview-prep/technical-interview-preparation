package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of integers and a mapping between integers and letters, 1 to A, 2 to B ... 26 to Z.
 * Generate all possible combinations of letters from the intergers.
 * <p>
 * Tags: Backtracking
 */
public class IntegerToLetters {

    private IntegerToLetters itl;

    public List<String> toLetters(String nums) {
        List<String> res = new ArrayList<>();
        helper(nums, "", 0, res);
        return res;
    }

    private void helper(String nums, String s, int start, List<String> res) {
        if (start >= nums.length()) {
            res.add(s);
            return;
        }
        for (int end = start + 1; end <= nums.length() && end <= start + 2; end++) {
            int temp = Integer.parseInt(nums.substring(start, end));
            if (1 <= temp && temp <= 26) {
                s += ((char) (temp + 'A' - 1));
                helper(nums, s, end, res);
                s = s.substring(0, s.length() - 1);
            }
        }
    }
}
