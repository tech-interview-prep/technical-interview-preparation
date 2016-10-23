package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _127WordLadder {
    /*
    Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the dictionary
    For example,

    Given:
    start = "hit"
    end = "cog"
    dict = ["hot","dot","dog","lot","log"]
    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

    Note:
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    */
    public static int ladderLength(String start, String end, HashSet<String> dict) {
        if (start.equals(end)) {
            return 1;
        }

        Set<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();
        dict.add(end);
        visited.add(start);
        q.add(start);
        q.add(null);

        int level = 1;
        while (!q.isEmpty()) {
            String w = q.remove();
            if (w == null && !q.isEmpty()) {
                q.add(null);
                level++;
            } else if (w != null) {
                for (String n : getNeighbors(w)) {
                    if (n.equals(end)) {
                        return level + 1;
                    }

                    if (dict.contains(n) && !visited.contains(n)) {
                        q.add(n);
                        visited.add(n);
                    }
                }
            }
        }

        return 0;
    }

    private static List<String> getNeighbors(String word) {
        List<String> neighbors = new ArrayList<String>();
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < wordChars.length; i++) {
            char oldC = wordChars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != oldC) {
                    wordChars[i] = c;
                    String s = new String(wordChars);
                    neighbors.add(s);
                }
            }
            wordChars[i] = oldC;
        }
        return neighbors;
    }

    private static void test() {
        HashSet<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        Utils.printTestln(ladderLength("hit", "cog", dict), 5);

        dict.clear();
        dict.add("hit");
        dict.add("cog");
        Utils.printTestln(ladderLength("hit", "cog", dict), 0);
    }

    public static void main(String[] args) {
        test();
    }
}
