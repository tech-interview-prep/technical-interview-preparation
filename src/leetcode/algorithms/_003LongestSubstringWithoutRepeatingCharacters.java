package leetcode.algorithms;

import java.util.Arrays;

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
 * http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * http://n00tc0d3r.blogspot.com/2013/04/longest-substring-without-repeating.html
 */
public class _003LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution_LongestSubstringNoRepeatingChars sol = new Solution_LongestSubstringNoRepeatingChars();
        System.out.println(sol.lengthOfLongestSubstring("eceba"));
    }
}

class Solution_LongestSubstringNoRepeatingChars {
    //same as longestSubStrWithUniqueChars(String target)
    public int lengthOfLongestSubstring(String target) {
        if (target == null || target.isEmpty()) {
            return 0;
        }

        char[] chars = target.toCharArray();

        int current = 0;//current pos in string
        int length = 0; //current longest substr length
        int pos = 0;    //current longest substr starting pos

        for (current = 0 ; current < target.length(); current++) {
            pos = current;
            boolean[] found = new boolean[256];

            while (pos < target.length() && !found[chars[pos]]) {
                found[chars[pos]] = true;
                pos++;
            }

            length = Math.max(length, pos - current);
        }

        return length;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] cArr = s.toCharArray();
        int dict[] = new int[256], sum = 0, prev = 0, i, len = cArr.length;
        Arrays.fill( dict, -1 );

        for (i = 0; i < len; i++ ) {
            int c = cArr[i];
            if (dict[c] >= prev) {
                sum = Math.max(i - prev, sum);
                prev = dict[c] + 1;
            }
            dict[c] = i;
        }
        return Math.max( i - prev, sum);
    }
}
