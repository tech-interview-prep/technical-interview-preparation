package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import utils.Utils;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * http://www.geeksforgeeks.org/find-possible-words-phone-digits/
 * http://www.lifeincode.net/programming/leetcode-letter-combinations-of-a-phone-number-java/
 * http://n00tc0d3r.blogspot.com/2013/03/letter-combinations-of-phone-number.html
 */
public class _017LetterCombinationOfAPhoneNumber {
    public static void main(String[] args) {
        Solution_LetterCombinationOfAPhoneNumber sol = new Solution_LetterCombinationOfAPhoneNumber();

        Utils.printListln(sol.letterCombinations(""));
    }
}

class Solution_LetterCombinationOfAPhoneNumber {
    public List<String> letterCombinations_Iterative(String digits) {
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> list = new LinkedList<String>();
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '2';
            int size = list.size();
            for (int k = 0; k < size; k++) {
                String tmp = list.pop();
                for (int j = 0; j < letters[num].length(); j++)
                    list.add(tmp + letters[num].charAt(j));
            }
        }
        List<String> rec = new LinkedList<String>();
        rec.addAll(list);
        return rec;
    }

    // ----------------------------------------------- //

    public List<String> letterCombinations2(String digits) {
        String[] letters = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> rec = new LinkedList<String>();
        StringBuilder string = new StringBuilder();
        letterCombinations(digits, 0, letters, string, rec);
        return rec;
    }

    private void letterCombinations(String digits, int number, String[] letters, StringBuilder string, List<String> rec) {
        if (digits.length() == number) {
            rec.add(string.toString());
            return;
        }
        String letter = letters[digits.charAt(number) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            string.append(letter.charAt(i));
            letterCombinations(digits, number + 1, letters, string, rec);
            string.deleteCharAt(string.length() - 1);
        }
    }

    public ArrayList<String> letterCombinations(String digits) {
        Map<Character, char[]> n2l = new HashMap<Character, char[]>();
        n2l.put('2', "abc".toCharArray());
        n2l.put('3', "def".toCharArray());
        n2l.put('4', "ghi".toCharArray());
        n2l.put('5', "jkl".toCharArray());
        n2l.put('6', "mno".toCharArray());
        n2l.put('7', "pqrs".toCharArray());
        n2l.put('8', "tuv".toCharArray());
        n2l.put('9', "wxyz".toCharArray());

        ArrayList<String> ret = new ArrayList<String>();
        letterCombinations(digits, ret, 0, new StringBuffer(), n2l);
        return ret;
    }

    public void letterCombinations(String digits, List<String> ret, int start, StringBuffer sb, Map<Character, char[]> n2l) {
        if (start == digits.length()) {
            ret.add(sb.toString());
            return;
        }

        for (char c : n2l.get(digits.charAt(start))) {
            letterCombinations(digits, ret, start + 1, sb.append(c), n2l);
            sb.setLength(sb.length() - 1);
        }
    }
}
