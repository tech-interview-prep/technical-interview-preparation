    /*
    Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence
    of one or more dictionary words.

    For example, given
    s = "leetcode",
    dict = ["leet", "code"].

    Return true because "leetcode" can be segmented as "leet code".
     */

package uber;

import utils.Utils;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 * @author bkoteshwarreddy
 */

public class _139WordBreak {
    public static void main(String[] args) {
      Solution_WordBreak sol = new Solution_WordBreak();

      Utils.printTestln(sol.wordBreak("leetcode", new HashSet<String>(Arrays.asList("leet", "code"))), true);
      Utils.printTestln(sol.wordBreak("letecoed", new HashSet<String>(Arrays.asList("leet", "code"))), false);
      Utils.printTestln(sol.wordBreak("aaaaaaa", new HashSet<String>(Arrays.asList("aaaa", "aa"))), false);

      System.out.println("------------------");

      Utils.printTestln(sol.wordBreakDP("leetcode", new HashSet<String>(Arrays.asList("leet", "code"))), true);
      Utils.printTestln(sol.wordBreakDP("letecoed", new HashSet<String>(Arrays.asList("leet", "code"))), false);
      Utils.printTestln(sol.wordBreakDP("aaaaaaa", new HashSet<String>(Arrays.asList("aaaa", "aa"))), false);
      Utils.printTestln(sol.wordBreakDP("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
              new HashSet<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))), false);
    }
}

class Solution_WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        return wordBreak(s, 0, dict);
    }

    private boolean wordBreak(String s, int start, Set<String> dict) {
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

    public boolean wordBreakDP(String s, Set<String> dict) {
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

    /*
    Time Complexity: O(string length * dict size)

    Link: http://www.programcreek.com/2012/12/leetcode-solution-word-break/
     */
    public boolean wordsInDictionary(String str, ArrayList<String> dictionary) {
        if (str == null || dictionary == null) {
            return false;
        }
        int length = str.length();
        String firstHalf = str.substring(0, length/2);
        String secondHalf = str.substring(length/2);
        int append = 0;
        int longest = firstHalf.length() > secondHalf.length() ? firstHalf.length() : secondHalf.length();

        for(int i=0; i<longest;i++) {
            if(dictionary.contains(firstHalf)) {
                if(dictionary.contains(secondHalf.substring(2*append))) {
                    return true;
                }
            } else if(dictionary.contains(secondHalf)) {
                if(dictionary.contains(firstHalf.substring(0, firstHalf.length() - 2*append))) {
                    return true;
                }
            } else {
                firstHalf = str.substring(0, i + 1 + length/2);
                secondHalf = str.substring(length/2 - i - 1);
                append++;
            }
        }
        return false;
    }
}
