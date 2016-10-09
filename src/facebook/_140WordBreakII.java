/*
  Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a
  valid dictionary word.

  Return all such possible sentences.

  For example, given
  s = "catsanddog",
  dict = ["cat", "cats", "and", "sand", "dog"].

  A solution is ["cats and dog", "cat sand dog"].
 */
package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.Utils;

/**
 * https://leetcode.com/problems/word-break-ii/
 * @author bkoteshwarreddy
 */
public class _140WordBreakII {
    public static void main(String[] args) {
        Solution_WordBreakII sol = new Solution_WordBreakII();
        Utils.printListln(sol.wordBreak("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        Utils.printListln(sol.wordBreak("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        Utils.printListln(sol.wordBreak("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        Utils.printListln(sol.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                                        new HashSet<String>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"))));
    }
}

class Solution_WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (isWordBreak(s, wordDict))
            dfs(result, s, "", wordDict);
        return result;
    }

    public void dfs(List<String> result, String s, String sub,
                    Set<String> wordDict) {
        if (s.length() == 0) {
            result.add(sub.trim());
            return;
        }
        for (int i = 1; i <= s.length(); ++i) {
            if (wordDict.contains(s.substring(0, i))) {
                sub += " " + s.substring(0, i);
                dfs(result, s.substring(i), sub, wordDict);
                sub = sub.substring(0, sub.length() - i - 1);
            }
        }
    }

    public boolean isWordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0)
            return false;
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i; ++j) {
                if (wordDict.contains(s.substring(j, i + 1)) &&
                        (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
}
