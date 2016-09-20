/**
 * @author bkoteshwarreddy
 * 
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 *      Only one letter can be changed at a time
 *      Each intermediate word must exist in the dictionary
 * 
 * For example,
 * 
 *  Given:
 *  start = "hit"
 *  end = "cog"
 *  dict = ["hot","dot","dog","lot","log"]
 *  
 *  Return
 *   [
 *      ["hit","hot","dot","dog","cog"],
 *      ["hit","hot","lot","log","cog"]
 *      ]
 *  Note:
 *      All words have the same length.
 *      All words contain only lowercase alphabetic characters.
 *      
 * https://leetcode.com/problems/word-ladder-ii/
 * 
 */
package facebook;

import utils.Utils;
import java.util.*;

public class _126WordLadderII {
    public static void main(String[] args) {
        Solution_WordLadderII sol = new Solution_WordLadderII();
        HashSet<String> dict = new HashSet<String>();
        String[] dictArrays = new String[]{"hot","dot","dog","lot","log"};
        for (String w : dictArrays) {
            dict.add(w);
        }

        for (List<String> sList : sol.findLadders("hit", "cog", dict)) {
            Utils.printListln(sList);
        }
    }
}

class Solution_WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
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

    //----------------------------------------------------------------------------------------------------------------//
    public List<List<String>> findLadders2(String start, String end, Set<String> dict) {
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
