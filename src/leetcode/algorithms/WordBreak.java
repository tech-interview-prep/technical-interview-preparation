package leetcode.algorithms.level.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import utils.Utils;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence
 * of one or more dictionary words.
 *
 * For example, given
 *     s = "leetcode",
 *     dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * https://leetcode.com/problems/word-break/
 * http://www.programcreek.com/2012/12/leetcode-solution-word-break/
 */
public class WordBreak {
    public static void main(String[] args) {
        Solution_WordBreak sol = new Solution_WordBreak();

        Utils.printTestln(sol.wordBreak("leetcode", new HashSet<String>(Arrays.asList("leet", "code"))), true);
        Utils.printTestln(sol.wordBreak("letecoed", new HashSet<String>(Arrays.asList("leet", "code"))), false);
        Utils.printTestln(sol.wordBreak("aaaaaaa", new HashSet<String>(Arrays.asList("aaaa", "aa"))), false);

        System.out.println("------------------");

        Utils.printTestln(sol.wordBreak("leetcode", new HashSet<String>(Arrays.asList("leet", "code"))), true);
        Utils.printTestln(sol.wordBreak("letecoed", new HashSet<String>(Arrays.asList("leet", "code"))), false);
        Utils.printTestln(sol.wordBreak("aaaaaaa", new HashSet<String>(Arrays.asList("aaaa", "aa"))), false);
    }
}

class Solution_WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len+1];
        f[0] = true;

        for (int i=1; i<len+1; i++) {
            for (int j=0; j<i; j++) {
                if (f[j] && wordDict.contains(s.substring(j,i))) {
                    f[i] = true;
                    continue;
                }
            }
        }
        return f[len];
    }

    /*
    Time Complexity: O(string length * dict size)
     */
    public boolean wordBreak2(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state

        for (int i = 0; i < s.length(); i++) {
            //should continue from match position
            if (!t[i])
                continue;

            for (String a : dict) {
                int len = a.length();
                int end = i + len;
                if (end > s.length())
                    continue;

                if (t[end]) continue;

                if (s.substring(i, end).equals(a)) {
                    t[end] = true;
                }
            }
        }

        return t[s.length()];
    }
}
