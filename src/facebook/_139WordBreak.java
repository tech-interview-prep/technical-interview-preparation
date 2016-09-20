    /*
    Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence
    of one or more dictionary words.

    For example, given
    s = "leetcode",
    dict = ["leet", "code"].

    Return true because "leetcode" can be segmented as "leet code".

    Link: http://www.programcreek.com/2012/12/leetcode-solution-word-break/
     */

package facebook;

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

    public boolean wordBreakDP2(String s, Set<String> wordDict) {
        int[] pos = new int[s.length()+1];

        Arrays.fill(pos, -1);

        pos[0]=0;

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=-1){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i, j);
                    if(wordDict.contains(sub)){
                        pos[j]=i;
                    }
                }
            }
        }

        return pos[s.length()]!=-1;
    }

    /*
    Time Complexity: O(string length * dict size)
     */
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state

        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i])
                continue;

            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;

                if(t[end]) continue;

                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }

        return t[s.length()];
    }
}
