package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Anagrams {
    /*
        Given an array of words, write a method that determines whether there are any words in this array
        that are anagrams of each other.

        Sample #1: @[@"bag", @"bat", @"tab"]; // output TRUE

        Sample #2: @[@"gab", @"bat", @"laf"]; // output FALSE

         http://www.careercup.com/question?id=5654505932718080

    */
    public boolean hasAnagrams(String[] input) {
        if (input == null || input.length <= 1) {
            return false;
        }

        HashSet<String> set = new HashSet<String>();

        for (String s : input) {
            String sortedString = sort(s);
            if (set.contains(sortedString)) {
                return true;
            } else {
                set.add(sortedString);
            }
        }
        return false;
    }

    /*
        Group Anagrams
        input = ["star, astr, car, rac, st"]
        output = [["star, astr"],["car","rac"],["st"]);

         http://www.careercup.com/question?id=5733320654585856

    */
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

    // Write a method to decide if two strings are anagrams or not.

    public boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128];

        char[] s_array = s.toCharArray();
        for (char c : s_array) { // count number of each char in s.
            letters[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }

        return true;
    }

    // ---------------------------------------------------------- //

    public static void anagramSort(ArrayList<String> list) {
        //important!
        Collections.sort(list, new AnagramComparator());
    }
}

class AnagramComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        return sort(s1).compareTo(sort(s2));
    }

    public static String sort(String s) {
        char[] array = s.toCharArray();
        //important!
        Arrays.sort(array);
        String result = new String(array);
        return result;

    }
}
