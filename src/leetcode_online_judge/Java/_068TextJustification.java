package leetcode_online_judge.Java;

import utils.Utils;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _068TextJustification {
    /*
    Given an array of words and a length L, format the text such that each line has exactly L characters and is fully
    (left and right) justified.

    You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
    spaces ' ' when necessary so that each line has exactly L characters.

    Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not
    divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

    For the last line of text, it should be left justified and no extra space is inserted between words.

    For example,
    words: ["This", "is", "an", "example", "of", "text", "justification."]
    L: 16.

    Return the formatted lines as:
    [
       "This    is    an",
       "example  of text",
       "justification.  "
    ]
    Note: Each word is guaranteed not to exceed L in length.

    Corner Cases:
    A line other than the last line might contain only one word. What should you do in this case?
    In this case, that line should be left-justified.
     */
    public static ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> ret = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < words.length;) {
            int start, length, extraSpace, firstSpace, index;
            for (start = i + 1, length = words[i].length();
                 start < words.length && (length + words[start].length() + 1) <= L;
                length += words[start++].length() + 1);
            sb.setLength(0);

            sb.append(words[i]);

            if (start == words.length) {
                for (int j = i + 1; j < start; j++) {
                    sb.append(" ");
                    sb.append(words[j]);
                }
                sb.append(nSpace(L - sb.length()));
            } else if (start - i - 1 > 0) {
                extraSpace = (L - length) / (start - i - 1);
                firstSpace = (L - length) % (start - i - 1);
                String nSpace = nSpace(extraSpace + 1), n1Space = nSpace(extraSpace + 2);


                for (index = i + 1; index - i <= firstSpace; index++) {
                    sb.append(n1Space);
                    sb.append(words[index]);
                }

                for (; index < start; index++) {
                    sb.append(nSpace);
                    sb.append(words[index]);
                }
            } else {
                sb.append(nSpace(L - words[i].length()));
            }

            ret.add(sb.toString());
            i = start;
        }

        return ret;
    }

    private static String nSpace(int n) {
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < n; i++) {
            ret.append(' ');
        }

        return ret.toString();
    }

    private static void test() {
        Utils.printListln(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16), "\n");
        Utils.printListln(fullJustify(new String[]{"What", "must", "be", "shall", "be."}, 12), "\n");
    }

    public static void main(String[] args) {
        test();
    }
}
