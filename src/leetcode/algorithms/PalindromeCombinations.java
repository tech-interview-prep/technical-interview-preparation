package leetcode.algorithms;

/**
 * Write a function for retrieving the total number of substring palindromes.
 *
 * For example the input is 'abba' then the possible palindromes= a, b, b, a, bb, abba
 * So the result is 6.
 *
 * http://www.careercup.com/question?id=5177378863054848
 * http://ajeetsingh.org/2013/11/06/algorithm-to-find-the-total-number-of-substring-palindromes-in-a-given-string/
 *
 * Complexity: O(N^2) time and O(1) space.
 */
public class PalindromeCombinations {
    public int combinations(String inputText) {
        if (inputText == null) {
            System.out.println("Input cannot be null!");
            return 0;
        }
        // ODD Occuring Palindromes
        int len = inputText.length();
        int palindromes = len;
        for (int i = 1; i < len - 1; i++) {
            for (int j = i - 1, k = i + 1; j >= 0 && k < len; j--, k++) {
                if (inputText.charAt(j) == inputText.charAt(k)) {
                    palindromes++;
                    System.out.println(inputText.subSequence(j, k + 1));
                } else {
                    break;
                }
            }
        }
        // EVEN Occuring Palindromes
        for (int i = 1; i < len - 1; i++) {
            for (int j = i, k = i + 1; j >= 0 && k < len; j--, k++) {
                if (inputText.charAt(j) == inputText.charAt(k)) {
                    palindromes++;
                    System.out.println(inputText.subSequence(j, k + 1));
                } else {
                    break;
                }
            }
        }
        return palindromes;
    }
}
