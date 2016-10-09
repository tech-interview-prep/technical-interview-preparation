package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @author bkoteshwarreddy
 */

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _003LongestSubstringWithoutRepeatingCharacters {
    /*
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Examples:
     *      Given "abcabcbb", the answer is "abc", which the length is 3.
     *
     *      Given "bbbbb", the answer is "b", with the length of 1.
     *
     *      Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must
     *      be a substring, "pwke" is a subsequence and not a substring.
     *
     */

    public static int lengthOfLongestSubstring(String s) {
        int l = s.length(), maxLength = 0, start = 0;
        boolean[] exist = new boolean[256];

        for (int i = 0; i < l; i++) {
            if (exist[s.charAt(i)]) {
                maxLength = Math.max(i - start, maxLength);
                for (; start < i && s.charAt(start) != s.charAt(i); start++) {
                    exist[s.charAt(start)] = false;
                }
                start++;
            } else {
                exist[s.charAt(i)] = true;
            }
        }

        return Math.max(maxLength, l - start);
    }

    private static void test() {
        Utils.printTestln(lengthOfLongestSubstring("abcabcbb"), 3);
        Utils.printTestln(lengthOfLongestSubstring("bbbbb"), 1);
    }

    public static void main(String[] args) {
        test();
    }
}
