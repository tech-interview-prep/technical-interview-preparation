/*
    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

    For example,
    Given [100, 4, 200, 1, 3, 2],
    The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

    Your algorithm should run in O(n) complexity.
    */
package facebook;

import java.util.HashSet;
import java.util.Set;

import utils.Utils;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * @author bkoteshwarreddy
 */
public class _128LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution_LongestConsecutiveSequence sol = new Solution_LongestConsecutiveSequence();
        Utils.printTestln(sol.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}), 4);
    }
}

class Solution_LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
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

    /*
     http://www.programcreek.com/2013/01/leetcode-longest-consecutive-sequence-java/

    We can use a HashSet to add and remove elements. HashSet is implemented by using a hash table.
    Elements are not ordered. The add, remove and contains methods have constant time complexity O(1).

    After an element is checked, it should be removed from the set. Otherwise, time complexity would
    be O(mn) in which m is the average length of all consecutive sequences.

    To clearly see the time complexity, I suggest you use some simple examples and manually execute
    the program. For example, given an array {1,2,4,5,3}, the program time is m. m is the length of
    longest consecutive sequence.

    We do have an extreme case here: If n is number of elements, m is average length of consecutive
    sequence, and m==n, then the time complexity is O(n^2). The reason is that in this case, no element
    is removed from the set each time. You can use this array to get the point: {1,3,5,7,9}.
    */
    public int longestConsecutive2(int[] num) {
        // if array is empty, return 0
        if (num.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();
        int max = 1;

        for (int e : num)
            set.add(e);

        for (int e : num) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }

            max = Math.max(count, max);
        }

        return max;
    }
}
