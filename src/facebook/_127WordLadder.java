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

    Link: http://www.programcreek.com/2012/12/leetcode-word-ladder/
    */
package facebook;

import utils.Utils;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 * @author bkoteshwarreddy
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
            } else if (w != null){
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


        while(!wordQueue.isEmpty()){
            String currWord = wordQueue.pop();
            Integer currDistance = distanceQueue.pop();

            if(currWord.equals(end)){
                return currDistance;
            }

            for(int i=0; i<currWord.length(); i++){
                char[] currCharArr = currWord.toCharArray();
                for(char c='a'; c<='z'; c++){
                    currCharArr[i] = c;

                    String newWord = new String(currCharArr);
                    if(dict.contains(newWord)){
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance+1);
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

         Still, BFS is the solution to search min/max path. In order to restore the path, we need to keep a parent node list.

         Moreover, BFS should stop when current steps > minSteps. Without this, it cannot pass the larget data sets.
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        if (start == null || end == null || start.length() != end.length() || dict == null || dict.size() == 0)
            return new ArrayList<List<String>>();

        List<String> queue = new ArrayList<String>();
        Map<String, List<String>> parents = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        if (dict.contains(start))
            dict.remove(start);
        if (!dict.contains(end))
            dict.add(end);
        queue.add(start);
        distance.put(start, 1);
        int min = Integer.MAX_VALUE;

        for (int i=0; i<queue.size(); i++){
            String u = queue.get(i);
            int steps = distance.get(u);
            if (steps == min)
                break; // why ? since this is BFS. The minimum path will be discovered by within min steps only.
            char[] chs = u.toCharArray();
            for (int j=0; j<chs.length; j++){
                char oldch = chs[j];
                for (char c = 'a'; c <= 'z'; c++){
                    if (c == oldch)
                        continue;
                    chs[j] = c;
                    String v = new String(chs);

                    if (dict.contains(v)) {
                        if (!distance.containsKey(v)){
                            queue.add(v);
                            ArrayList<String> pList = new ArrayList<String>();
                            pList.add(u);
                            parents.put(v, pList);
                            distance.put(v, steps + 1);
                        }else if (distance.get(v) == steps + 1){ // Don't forget this case
                            parents.get(v).add(u);
                        }
                    }
                    if (v.equals(end)){
                        min = Math.min(min, steps + 1);
                    }
                }// enf of for loop
                chs[j] = oldch;
            }
        }
        return restorePath(end, parents, start);
    }

    public List<List<String>> restorePath(String end, Map<String, List<String>> parents, String start){
        List<List<String>> paths = new ArrayList<List<String>>();
        if (end.equals(start)){
            List<String> pList = new ArrayList<String>();
            pList.add(start);
            paths.add(pList);
        }else if (parents.containsKey(end)){
            for (String v : parents.get(end)){
                List<List<String>> list = restorePath(v, parents, start);
                for (List<String> p : list){
                    p.add(end);
                    paths.add(p);
                }
            }
        }
        return paths;
    }
}
