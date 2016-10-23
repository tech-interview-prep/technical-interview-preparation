package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

import utils.Utils;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * @author bkoteshwarreddy
 */
public class _076MinimumWindowSubstring {
    /*
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

    For example,
    S = "ADOBECODEBANC"
    T = "ABC"
    Minimum window is "BANC".

    Note:
    If there is no such window in S that covers all characters in T, return the emtpy string "".

    If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
     */
    public static String minWindow(String S, String T) {
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        int totalCount = T.length();
        for (int i = 0; i < totalCount; i++) {
            char c = T.charAt(i);
            if (!charCount.containsKey(c)) {
                charCount.put(c, 1);
            } else {
                charCount.put(c, charCount.get(c) + 1);
            }
        }

        int l = S.length(), minStart = 0, minEnd = l - 1;

        for (int start = 0, end = 0; end < l; end++) {
            char c = S.charAt(end);
            if (charCount.containsKey(c)) {
                int count = charCount.get(c);
                if (count > 0) {
                    totalCount--;
                }
                charCount.put(c, count - 1);

                if (totalCount <= 0) {
                    while (start <= end) {
                        if (charCount.containsKey(c = S.charAt(start))) {
                            if ((count = charCount.get(c)) >= 0) {
                                break;
                            }
                            charCount.put(c, count + 1);
                        }
                        start++;
                    }
                    if (end - start < minEnd - minStart) {
                        minStart = start;
                        minEnd = end;
                    }
                }
            }
        }

        return totalCount > 0 ? "" : S.substring(minStart, minEnd + 1);
    }

    private static void test() {
        Utils.printTestln(minWindow("adobecodebanc", "abc"), "banc");
        Utils.printTestln(minWindow("a", "aa"), "");
    }

    public static void main(String[] args) {
        test();
    }
}
