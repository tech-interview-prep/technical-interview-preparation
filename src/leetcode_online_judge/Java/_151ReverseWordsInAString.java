package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _151ReverseWordsInAString {
    /*
    Given an input string, reverse the string word by word.

    For example,
    Given s = "the sky is blue",
    return "blue is sky the".


    Clarification:
    What constitutes a word?
    A sequence of non-space characters constitutes a word.

    Could the input string contain leading or trailing spaces?
    Yes. However, your reversed string should not contain leading or trailing spaces.

    How about multiple spaces between two words?
    Reduce them to a single space in the reversed string.
     */

    public static String reverseWords(String s) {
        StringBuffer ret = new StringBuffer();
        int end, start;
        for (start = s.length() - 1, end = s.length(); start >= -1; start--) {
            if (start == - 1 || s.charAt(start) == ' ') {
                if (start + 1 < end) {
                    ret.append(s.substring(start + 1, end)).append(' ') ;
                }
                end = start;
            }
        }
        ret.setLength(Math.max(0, ret.length() - 1));

        return ret.toString();
    }

    private static void test() {
        Utils.printTestln(reverseWords("the sky is blue"), "blue is sky the");
        Utils.printTestln(reverseWords(" the sky is blue"), "blue is sky the");
        Utils.printTestln(reverseWords(" the sky   is   blue"), "blue is sky the");
        Utils.printTestln(reverseWords(" the sky   is   blue  "), "blue is sky the");
        Utils.printTestln(reverseWords(""), "");
        Utils.printTestln(reverseWords(" "), "");
    }

    public static void main(String[] args) {
        test();
    }

}
