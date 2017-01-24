package leetcode.algorithms;

import utils.Utils;

/**
 * @author bkoteshwarreddy
 */
public class _058LengthOfLastWord {
    /*
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last
    word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

    For example,
    Given s = "Hello World",
    return 5.
    */
    public static int lengthOfLastWord(String s) {
        int end, start;
        for (end = s.length() - 1; end >= 0 && s.charAt(end) == ' '; end--);
        for (start = end; start >= 0 && s.charAt(start) != ' '; start--);
        return end - start;
    }

    private static void test() {
        Utils.printTestln(lengthOfLastWord("Hello World"), 5);
        Utils.printTestln(lengthOfLastWord("a "), 1);
        Utils.printTestln(lengthOfLastWord(" "), 0);
    }

    public static void main(String[] args) {
        test();
    }
}
