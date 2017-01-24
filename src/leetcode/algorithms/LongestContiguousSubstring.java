package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string you need to print longest possible substring that has at most M unique characters.
 * <p>
 * If there are more than one substring of longest possible length, then print any one of them.
 * <p>
 * Example:
 * input: abcsxfaaxfe, 5
 * output: sxfaaxfe
 * <p>
 * Similar:
 * http://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
 * <p>
 * Created by kiyan on 6/5/16.
 */
public class LongestContiguousSubstring {

    private LongestContiguousSubstring lcs;

    /**
     * O(n) Time, O(n) Space
     * Maintain a window and add elements to the window till it contains less or equal k
     * Update our result if required while doing so.
     * If unique elements exceeds than required in window, start removing the elements from left side.
     * We can reduce the space to O(1) if change the map to an array of all characters
     */
    public String findLongestContiguous(String s, int M) {
        if (s == null || s.length() <= M) return s;
        Map<Character, Integer> map = new HashMap<>();
        String res = "";
        int start = 0;
        int end = 0;
        while (start <= end && end < s.length()) {
            char c = s.charAt(end);
            // Update map
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            // Move start pointer
            while (map.size() > M) {
                char toRemove = s.charAt(start);
                if (map.containsKey(toRemove)) map.put(toRemove, map.get(toRemove) - 1);
                if (!map.containsKey(toRemove) || map.get(toRemove) <= 0) map.remove(toRemove);
                start++;
            }
            // Update result
            String temp = s.substring(start, end + 1);
            if (res.length() < temp.length()) {
                res = temp;
            }
            end++;
        }
        return res;
    }
}
