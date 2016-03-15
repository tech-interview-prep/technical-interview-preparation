package leetcode_online_judge;

import utils.Utils;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    /*
    You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of
    substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

    For example, given:
    S: "barfoothefoobarman"
    L: ["foo", "bar"]

    You should return the indices: [0,9].
    (order does not matter).
     */

    // There could be duplicates in L
    public static ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        int l = S.length();
        if (l == 0 || L.length == 0) {
            return ret;
        }

        int wordLength = L[0].length();
        Map<String, Integer> occurance = new HashMap<String, Integer>();

        for (String w : L) {
            if (!occurance.containsKey(w)) {
                occurance.put(w, 1);
            } else {
                occurance.put(w, occurance.get(w) + 1);
            }
        }

        for (int i = 0 ; i < l - wordLength * L.length + 1; i++) {
            Map<String, Integer> tmp = new HashMap<String, Integer>(occurance);
            String word;
            int totalCount = 0;
//            for (int j = i, count; j + wordLength <= l && tmp.containsKey(word = S.substring(j, j + wordLength))
//                    && (count = tmp.get(word)) > 0; j += wordLength) {
            for (int j = i, count; tmp.containsKey(word = S.substring(j, j + wordLength)) && (count = tmp.get(word)) > 0; j += wordLength) {
                tmp.put(word, count - 1);
                totalCount++;
            }

            if (totalCount == L.length) {
                ret.add(i);
            }
        }

        return ret;
    }

    private static void test() {
        Utils.printIntListln(findSubstring("a", new String[]{"a"}));
        Utils.printIntListln(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

    public static void main(String[] args) {
        test();
    }
}
