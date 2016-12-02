package leetcode.algorithms.level.Easy;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * <p>
 * Tags: Two Pointers, String
 * Similar Problems: (E) Reverse String
 */
public class ReverseVowelsOfAString {

    private ReverseVowelsOfAString rv;

    /**
     * Use two pointers, search for vowels from both ends
     */
    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder(s);
        String vowels = "aeiouAEIOU";
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && vowels.indexOf(s.charAt(i)) == -1) { i++; }
            while (i < j && vowels.indexOf(s.charAt(j)) == -1) { j--; }
            char c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, c);
            i++;
            j--;
        }
        return sb.toString();
    }
}
