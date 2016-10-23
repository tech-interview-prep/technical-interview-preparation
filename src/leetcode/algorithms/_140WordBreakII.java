package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import utils.Utils;

/**
 * https://leetcode.com/problems/word-break-ii/
 * @author bkoteshwarreddy
 */
public class _140WordBreakII {
    /*
      Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a
      valid dictionary word.

      Return all such possible sentences.

      For example, given
      s = "catsanddog",
      dict = ["cat", "cats", "and", "sand", "dog"].

      A solution is ["cats and dog", "cat sand dog"].
     */
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();
        Set<Integer> dictLen = new HashSet<Integer>();
        for (String w : dict) {
            dictLen.add(w.length());
        }

        wordBreak(s, 0, dict, dictLen, new StringBuffer(), ret);
        return ret;
    }

    // it is depth first search
    private static void wordBreak(String s, int start, Set<String> dict, Set<Integer> dictLen, StringBuffer sb, List<String> ret) {
        if (start == s.length()) {
            ret.add(sb.toString().trim());
            return;
        }

        for (int i : dictLen) {
            int end = i + start;
            if ( end <= s.length() && dict.contains(s.substring(start, end))) {
                sb.append(s.substring(start, end)).append(' ');
                wordBreak(s, end, dict, dictLen, sb, ret);
                sb.setLength(sb.length() - end + start - 1);
            }
        }
    }


    public static ArrayList<String> wordBreakFromEnd(String s, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();
        Set<Integer> dictLen = new HashSet<Integer>();
        for (String w : dict) {
            dictLen.add(w.length());
        }

        wordBreakFromEnd(s, s.length(), dict, dictLen, new ArrayList<String>(), ret);
        return ret;
    }

    // it is depth first search
    private static void wordBreakFromEnd(String s, int end, Set<String> dict, Set<Integer> dictLen, List<String> words, List<String> ret) {
        if (end == 0) {
            ret.add(joinString(words));
            return;
        }

        for (int i : dictLen) {
            int start = end - i;
            if ( start >= 0 && dict.contains(s.substring(start, end))) {
                words.add(s.substring(start, end));
                wordBreakFromEnd(s, start, dict, dictLen, words, ret);
                words.remove(words.size() - 1);
            }
        }
    }

    private static String joinString(List<String> words) {
        StringBuffer ret = new StringBuffer();
        for (int i = words.size() - 1; i >= 0; i--) {
            ret.append(words.get(i)).append(' ');
        }
        ret.setLength(ret.length() - 1);

        return ret.toString();
    }



    // this approach is slow since it recompute lots of elements in the Queue q
    public static ArrayList<String> wordBreakBFS(String s, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();
        Set<Integer> wordLength = new HashSet<Integer>();

        for (String w : dict) {
            wordLength.add(w.length());
        }

        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);

        while (!q.isEmpty()) {
            int start = q.remove();
            for (int l : wordLength) {
                int end = start + l;
                if (end <= s.length() && dict.contains(s.substring(start, end))) {
                    //q.add(end);   ---> move this line below makes the problem much fast. Otherwise it is same as recursin(brute force)
                    if (!map.containsKey(end)) {
                        map.put(end, new HashSet<Integer>());
                        q.add(end);
                    }
                    map.get(end).add(start);
                }
            }
        }

        if (map.containsKey(s.length())) {
            getSentence(s, map, s.length(), new ArrayList<String>(), ret);
        }

        return ret;
    }

    private static void getSentence(String s, Map<Integer, ? extends Collection<Integer>> tree, int end, List<String> words, List<String> ret) {
        if (end == 0) {
            ret.add(joinString(words));
            return;
        }

        for (int i : tree.get(end)) {
            words.add(s.substring(i, end));
            getSentence(s, tree, i, words, ret);
            words.remove(words.size() - 1);
        }
    }

    public static ArrayList<String> wordBreakDP(String s, Set<String> dict) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        map.put(0, null);
        List<Integer> parent = new ArrayList<Integer>();
        for (int end = 0; end <= s.length(); end++) {
            parent.clear();
            for (int start : map.keySet()) {
                if (dict.contains(s.substring(start, end))) {
                    parent.add(start);
                }
            }
            if (!parent.isEmpty()) {
                map.put(end, new ArrayList<Integer>(parent));
            }
        }

        ArrayList<String> ret = new ArrayList<String>();

        if (map.containsKey(s.length())) {
            getSentence(s, map, s.length(), new ArrayList<String>(), ret);
        }

        return ret;
    }

    private static void test() {
        Utils.printListln(wordBreak("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        Utils.printListln(wordBreakFromEnd("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        Utils.printListln(wordBreakBFS("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        Utils.printListln(wordBreakBFS("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                                       new HashSet<String>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"))));


        System.out.println(">>>Below is the DP version:");
        Utils.printListln(wordBreakDP("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        Utils.printListln(wordBreakDP("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                                      new HashSet<String>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"))));
    }

    public static void main(String[] args) {
        test();
    }
}
