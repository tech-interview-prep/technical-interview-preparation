package leetcode_online_judge;

import utils.Utils;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
    Given a string, find the length of the longest substring without repeating characters. For example, the longest
    substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest
    substring is "b", with the length of 1.
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
