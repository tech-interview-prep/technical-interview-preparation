package facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import utils.Utils;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start
 * to end, such that:
 *     Only one letter can be changed at a time
 *     Each intermediate word must exist in the dictionary
 *
 * For example,
 *
 * Given:
 *     start = "hit"
 *     end = "cog"
 *     dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 * https://leetcode.com/problems/word-ladder/
 * http://www.programcreek.com/2012/12/leetcode-word-ladder/
 */
public class _127WordLadder {
    public static void main(String[] args) {
        Solution_WordLadder sol = new Solution_WordLadder();
        HashSet<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        Utils.printTestln(sol.ladderLength("hit", "cog", dict), 5);

        dict.clear();
        dict.add("hit");
        dict.add("cog");
        Utils.printTestln(sol.ladderLength("hit", "cog", dict), 0);
    }
}

class Solution_WordLadder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
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

    private List<String> getNeighbors(String word) {
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

    public int ladderLength2(String start, String end, HashSet<String> dict) {

        if (dict.size() == 0)
            return 0;

        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

        wordQueue.add(start);
        distanceQueue.add(1);


        while (!wordQueue.isEmpty()) {
            String currWord = wordQueue.pop();
            Integer currDistance = distanceQueue.pop();

            if (currWord.equals(end)) {
                return currDistance;
            }

            for (int i = 0; i < currWord.length(); i++) {
                char[] currCharArr = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currCharArr[i] = c;

                    String newWord = new String(currCharArr);
                    if (dict.contains(newWord)) {
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance + 1);
                        dict.remove(newWord);
                    }
                }
            }
        }

        return 0;
    }


    /*
        Given two words (start and end), and a dictionary, write a method to transform from one word
        into another word such that:

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

        https://gist.github.com/bittib/5783270
        https://gist.github.com/bittib/6208836

    */
    public LinkedList<String> transform(String startWord, String stopWord, Set<String> dictionary) {
        startWord = startWord.toUpperCase();
        stopWord = stopWord.toUpperCase();
        Queue<String> actionQueue = new LinkedList<String>();
        Set<String> visitedSet = new HashSet<String>();
        Map<String, String> backtrackMap = new TreeMap<String, String>();

        actionQueue.add(startWord);
        visitedSet.add(startWord);

        while (!actionQueue.isEmpty()) {
            String w = actionQueue.poll();
            // For each possible word v from w with one edit operation
            for (String v : getOneEditWords(w)) {
                if (v.equals(stopWord)) {
                    // Found our word!  Now, back track.
                    LinkedList<String> list = new LinkedList<String>();
                    // Append v to list
                    list.add(v);
                    while (w != null) {
                        list.add(0, w);
                        w = backtrackMap.get(w);
                    }
                    return list;
                }

                // If v is a dictionary word
                if (dictionary.contains(v)) {
                    if (!visitedSet.contains(v)) {
                        actionQueue.add(v);
                        visitedSet.add(v); // mark visited
                        backtrackMap.put(v, w);
                    }
                }
            }
        }
        return null;
    }

    private Set<String> getOneEditWords(String word) {
        Set<String> words = new TreeSet<String>();
        // for every letter
        for (int i = 0; i < word.length(); i++) {
            char[] wordArray = word.toCharArray();
            // change that letter to something else
            for (char c = 'A'; c <= 'Z'; c++) {
                if (c != word.charAt(i)) {
                    wordArray[i] = c;
                    words.add(new String(wordArray));
                }
            }
        }
        return words;
    }
}
