package leetcode_online_judge;

import utils.Utils;

import java.util.*;

public class WordLadderII {
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
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        Map<String, List<String>> parentMap = new HashMap<String, List<String>>();
        Queue<String> queue = new LinkedList<String>();

        queue.add(end);
        parentMap.put(end, null);
        queue.add(null);

        String word;
        int level = 1;
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            //one word could have muplile pares in one single level, but if the word has been visited in the earlier level,
            // then it should not be added to the queue
            Set<String> visited = new HashSet<String>(parentMap.keySet());
            while ((word = queue.remove()) != null) {
                for (String aw : getAdjacentWords(word, dict, start)) {
                    if (start.equals(aw)) {
                        found = true;
                    }

                    if (!visited.contains(aw)) {
                        if (!parentMap.containsKey(aw)) {
                            queue.add(aw);
                            parentMap.put(aw, new ArrayList<String>());
                        }
                        parentMap.get(aw).add(word);
                    }
                }
            }
            if (!queue.isEmpty()) {
                queue.add(null);
                level++;
            }
        }

        if (found) {
            ArrayList<String> dest = new ArrayList<String>();
            dest.add(start);
            ret.add(dest);

            for (int i = 1; i < level; i++) {
                for (int j = 0, l = ret.size(); j < l; j++) {
                    ArrayList<String> partialPath = ret.get(j);
                    String s = partialPath.get(partialPath.size() - 1);
                    List<String> parent = parentMap.get(s);
                    for (int k = 1; k < parent.size(); k++) {
                        ArrayList<String> tmp = new ArrayList<String>(partialPath);
                        tmp.add(parent.get(k));
                        ret.add(tmp);
                    }
                    partialPath.add(parent.get(0));
                }
            }
        }

        return ret;

    }

    private static List<String> getAdjacentWords(String s, Set<String> dict, String target) {
        char[] chars = s.toCharArray();
        List<String> aWords = new ArrayList<String>();

        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            String word;
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != currentChar) {
                    chars[i] = c;
                    if (dict.contains(word = new String(chars)) || word.equals(target)) {
                        aWords.add(word);
                    }
                }
            }
            chars[i] = currentChar;
        }
        return aWords;
    }

    private static void test() {
        HashSet<String> dict = new HashSet<String>();
        String[] dictArrays = new String[]{"hot","dot","dog","lot","log"};
        for (String w : dictArrays) {
            dict.add(w);
        }

        for (ArrayList<String> sList : findLadders("hit", "cog", dict)) {
            Utils.printListln(sList);
        }
    }

    public static void main(String[] args) {
        test();
    }
}
