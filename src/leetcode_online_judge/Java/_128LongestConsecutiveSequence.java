package leetcode_online_judge.Java;

import utils.Utils;

import java.util.Set;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _128LongestConsecutiveSequence {
    /*
    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

    For example,
    Given [100, 4, 200, 1, 3, 2],
    The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

    Your algorithm should run in O(n) complexity.
    */
    public static int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : num) {
            set.add(i);
        }

        int maxLength = 0;
        for (int i : num) {
            if (set.contains(i)) {
                int length = 1;
                for (int k = i + 1; set.contains(k); length++, set.remove(k), k++);
                for (int k = i - 1; set.contains(k); length++, set.remove(k), k--);
                set.remove(i);
                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;
    }

    private static void test() {
        Utils.printTestln(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}), 4);
    }

    public static void main(String[] args) {
        test();
    }
}
