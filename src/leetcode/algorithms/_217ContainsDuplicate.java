package leetcode.algorithms;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate/
 * @author bkoteshwarreddy
 */

public class _217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        HashSet<Integer> distinct = new HashSet<>();
        for (int num : nums) {
            if (distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }

        return false;
    }
}
