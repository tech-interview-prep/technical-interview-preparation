package facebook;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array of words, write a method that determines whether there are any words in this array that are
 * anagrams of each other.
 *
 * Sample #1: @[@"bag", @"bat", @"tab"]; // output TRUE
 * Sample #2: @[@"gab", @"bat", @"laf"]; // output FALSE
 *
 * http://www.careercup.com/question?id=5654505932718080
 */
public class HasAnagrams {
    public static void main(String[] args) {
        Solution_HasAnagrams sol = new Solution_HasAnagrams();
        String[] input = new String[] {"abc", "adc", "cab"};

        System.out.println(sol.hasAnagrams(input));
    }
}

class Solution_HasAnagrams {
    public boolean hasAnagrams(String[] input) {
        if (input == null || input.length <= 1) {
            return false;
        }

        HashSet<String> set = new HashSet<String>();

        for (String str : input) {
            String sortedString = sort(str);
            if (set.contains(sortedString)) {
                return true;
            } else {
                set.add(sortedString);
            }
        }
        return false;
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
