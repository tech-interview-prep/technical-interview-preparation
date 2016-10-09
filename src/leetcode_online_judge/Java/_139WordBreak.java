package leetcode_online_judge.Java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import utils.Utils;

/**
 * https://leetcode.com/problems/word-break/
 * @author bkoteshwarreddy
 */
public class _139WordBreak {
    /*
    Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence
    of one or more dictionary words.

    For example, given
    s = "leetcode",
    dict = ["leet", "code"].

    Return true because "leetcode" can be segmented as "leet code".
     */
    public static boolean wordBreak(String s, Set<String> dict) {
        return wordBreak(s, 0, dict);
    }

    private static boolean wordBreak(String s, int start, Set<String> dict) {
        if (start == s.length()) {
            return true;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(start, i)) && wordBreak(s, i, dict)) {
                return true;
            }
        }

        return false;
    }

    public static boolean wordBreakDP(String s, Set<String> dict) {
        Set<Integer> indice = new HashSet<Integer>();
        indice.add(s.length());

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j : indice) {
                if (dict.contains(s.substring(i, j))) {
                    indice.add(i);
                    break;
                }
            }
        }

        return indice.contains(0);
    }

    public static void test() {
        Utils.printTestln(wordBreak("leetcode", new HashSet<String>(Arrays.asList("leet", "code"))), true);
        Utils.printTestln(wordBreak("letecoed", new HashSet<String>(Arrays.asList("leet", "code"))), false);
        Utils.printTestln(wordBreak("aaaaaaa", new HashSet<String>(Arrays.asList("aaaa", "aa"))), false);

        System.out.println("------------------");

        Utils.printTestln(wordBreakDP("leetcode", new HashSet<String>(Arrays.asList("leet", "code"))), true);
        Utils.printTestln(wordBreakDP("letecoed", new HashSet<String>(Arrays.asList("leet", "code"))), false);
        Utils.printTestln(wordBreakDP("aaaaaaa", new HashSet<String>(Arrays.asList("aaaa", "aa"))), false);
        Utils.printTestln(wordBreakDP("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                                      new HashSet<String>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"))), false);
    }

    public static void main(String[] args) {
        test();
    }

}
