/*
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new
language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
"wrt",
"wrf",
"er",
"ett",
"rftt"
]
The correct order is: "wertf".

Note:
You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
 */
package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/alien-dictionary/
 * @author bkoteshwarreddy
 */
public class _269AlienDictionary {
}

class Solution_AlienDictionary {
    public String alienOrder(String[] words) {
        HashSet<Integer> set = new HashSet<Integer>();
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        StringBuffer order = new StringBuffer();
        if (words.length == 0) {
            return order.toString();
        }
        // build graph
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                set.add(words[i].charAt(j) - 'a');
            }
            if (i < words.length - 1) {
                int len = Math.min(words[i].length(), words[i + 1].length());
                for (int k = 0; k < len; ++k) {
                    if (words[i].charAt(k) != words[i + 1].charAt(k)) {
                        if (map.containsKey(words[i].charAt(k) - 'a')) {
                            List<Integer> tmp = map.get(words[i].charAt(k) - 'a');
                            tmp.add(words[i + 1].charAt(k) - 'a');
                            map.put(words[i].charAt(k) - 'a', tmp);
                        } else {
                            List<Integer> tmp = new ArrayList<Integer>();
                            tmp.add(words[i + 1].charAt(k) - 'a');
                            map.put(words[i].charAt(k) - 'a', tmp);
                        }
                        break;
                    }
                }
            }
        }
        // graph traversal
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int[] visited = new int[26];
        for (int i = 0; i < 26; ++i) {
            if (visited[i] != 1 && set.contains(i)) {
                if (traverse(map, queue, i, visited) == false) {
                    return "";
                }
            }
        }
        while (!queue.isEmpty()) {
            char c = (char)('a' + queue.pollLast());
            order.append(c);
        }
        return order.toString();
    }

    public boolean traverse(HashMap<Integer, List<Integer>> map, LinkedList<Integer> queue, int i, int[] visited) {
        // parent is visited as descendents
        if (visited[i] == -1) {
            return false;
        }
        // visited
        if (visited[i] == 1) return true;
        // no pre-char
        if (!map.containsKey(i)) {
            queue.add(i);
            visited[i] = 1;
            return true;
        }
        // get all following nodes of node with index i
        List<Integer> tmp = map.get(i);
        visited[i] = -1;
        for (int j = 0; j < tmp.size(); ++j) {
            if (!traverse(map, queue, tmp.get(j), visited)) {
                return false;
            }
        }
        queue.add(i);
        visited[i] = 1;
        return true;
    }
}
