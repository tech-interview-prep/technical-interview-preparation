package leetcode.algorithms;

/**
 * Given two strings, write a method to decide if they are anagrams or not.
 */
public class AreAnagrams {
    public static void main(String[] args) {
        Solution_AreAnagrams sol = new Solution_AreAnagrams();
        System.out.println(sol.areAnagrams("abc", "cba"));
    }
}

class Solution_AreAnagrams {
    public boolean areAnagrams(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        int[] letters = new int[128];

        char[] first_array = first.toCharArray();
        for (char c : first_array) { // count number of each char in s.
            letters[c]++;
        }

        for (int i = 0; i < second.length(); i++) {
            int c = (int) second.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
