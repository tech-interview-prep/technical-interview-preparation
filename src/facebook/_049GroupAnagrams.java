package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 *
 * Note: All inputs will be in lower-case.
 *
 * https://leetcode.com/problems/anagrams/
 */
public class _049GroupAnagrams {
    public static void main(String[] args) {
        Solution_GroupAnagrams sol = new Solution_GroupAnagrams();

    }
}

class Solution_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] input) {
        if (input == null || input.length <= 0) {
            return new ArrayList<List<String>>();
        }

        HashMap<String, List<String>> set = new HashMap<String, List<String>>();

        for (String s : input) {
            String sortedString = sort(s);
            if (set.containsKey(sortedString)) {
                set.get(sortedString).add(s);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                set.put(sortedString, list);
            }
        }
        return new ArrayList<List<String>>(set.values());
    }

    public String sort(String s) {
        if (s == null) {
            return "";
        }

        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
