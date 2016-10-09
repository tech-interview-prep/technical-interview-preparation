package facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is
 *     a subsequence and not a substring.
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * https://leetcode.com/articles/longest-substring-without-repeating-characters/
 * http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 */
public class _003LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution_LongestSubstringNoRepeatingChars sol = new Solution_LongestSubstringNoRepeatingChars();
        System.out.println(sol.lengthOfLongestSubstring("eceba"));
    }
}

class Solution_LongestSubstringNoRepeatingChars {
    public int lengthOfLongestSubstring(String target) {
        Map<Character, Integer> char2pos = new HashMap<Character, Integer>();

        int start = 0;
        int end = -1;
        int max = 0;

        for (int i = 0; i < target.length(); i++) {
            end++;
            if (char2pos.containsKey(target.charAt(i))) {
                //only move start when the repeat is after start, discard any char before start
                if (char2pos.get(target.charAt(i)) >= start) {
                    start = char2pos.get(target.charAt(i)) + 1;
                }
            }
            //update the new pos to i
            char2pos.put(target.charAt(i), i);

            if (end - start > max) {
                max = end - start;
            }
        }

        return max + 1;
    }

    public int longestSubStrWithUniqueChars(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        char[] chars = s.toCharArray();

        int current = 0;//current pos in string
        int length = 0; //current longest substr length
        int pos = 0;    //current longest substr starting pos

        for (current = 0 ; current < s.length(); current++) {
            pos = current;
            boolean[] found = new boolean[256];

            while (pos < s.length() && !found[chars[pos]]) {
                found[chars[pos]] = true;
                pos++;
            }

            length = Math.max(length, pos - current);
        }

        return length;
    }
}
