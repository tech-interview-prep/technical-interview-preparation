package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _126WordLadderII {
    /*
    Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
    For example,

    Given:
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]
    Return
      [
        ["hit","hot","dot","dog","cog"],
        ["hit","hot","lot","log","cog"]
      ]
    Note:
    All words have the same length.
    All words contain only lowercase alphabetic characters.
     */
    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        HashMap<String, ArrayList<String>> h = new HashMap<String, ArrayList<String>>();
        Set<String> set1 = new HashSet<String>(), set2 = new HashSet<String>();
        set1.add(beginWord); set2.add(endWord);
        BFS(set1, set2, wordList, h, true);

        List<List<String>> ans = new ArrayList<List<String>>();
        List<String> cur = new ArrayList<String>();
        cur.add(beginWord);
        DFS(beginWord, endWord, h, cur, ans);
        return ans;
    }

    private static void BFS(Set<String> set1, Set<String> set2, Set<String> wordList, HashMap<String, ArrayList<String>> h, boolean forward) {
        if (set1.size() > set2.size()) {
            BFS(set2, set1, wordList, h, !forward);
            return;
        }
        wordList.removeAll(set1);
        wordList.removeAll(set2);
        boolean connected = false;
        Set<String> set3 = new HashSet<String>();

        for (String s : set1) {
            char[] c = s.toCharArray();
            for (int i = 0, len = c.length; i < len; i++) {
                char ch = c[i];
                for (char x = 'a'; x <= 'z'; x++)
                    if (x != ch) {
                        c[i] = x;
                        String cand = new String(c);
                        if (set2.contains(cand) || (!connected && wordList.contains(cand))) {
                            if (set2.contains(cand))
                                connected = true;
                            else
                                set3.add(cand);

                            String cand1 = forward ? cand : s;
                            String s1 = forward ? s : cand;
                            ArrayList<String> cur = h.containsKey(s1) ? h.get(s1) : new ArrayList<String>();
                            cur.add(cand1);
                            h.put(s1, cur);
                        }
                    }
                c[i] = ch;
            }
        }
        if (!connected && !set3.isEmpty())
            BFS(set3, set2, wordList, h, forward);
    }

    private static void DFS(String str, String ed, HashMap<String, ArrayList<String>> h, List<String> cur, List<List<String>> ans) {
        if (str.equals(ed)) {
            ans.add(new ArrayList<String>(cur));
            return;
        }

        if (!h.containsKey(str)) return;
        List<String> next = h.get(str);
        for (String i : next) {
            cur.add(i);
            DFS(i, ed, h, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }

    private static void test() {
        HashSet<String> dict = new HashSet<String>();
        String[] dictArrays = new String[] {"hot", "dot", "dog", "lot", "log"};
        for (String w : dictArrays) {
            dict.add(w);
        }

        for (List<String> sList : findLadders("hit", "cog", dict)) {
            Utils.printListln(sList);
        }
    }

    public static void main(String[] args) {
        test();
    }
}
