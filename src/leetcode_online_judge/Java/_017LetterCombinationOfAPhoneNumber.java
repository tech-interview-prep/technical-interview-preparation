package leetcode_online_judge.Java;

import utils.Utils;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class _017LetterCombinationOfAPhoneNumber {
    /*
    Given a digit string, return all possible letter combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below.

    // see graph 200px-Telephone-keypad2.svg.png

    Input:Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    Note:
    Although the above answer is in lexicographical order, your answer could be in any order you want.
    */
    public static ArrayList<String> letterCombinations(String digits) {
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

    public static void letterCombinations(String digits, List<String> ret, int start, StringBuffer sb, Map<Character, char[]> n2l) {
        if (start == digits.length()) {
            ret.add(sb.toString());
            return;
        }

        for (char c : n2l.get(digits.charAt(start))) {
            letterCombinations(digits, ret, start + 1, sb.append(c), n2l);
            sb.setLength(sb.length() - 1);
        }
    }

    private static void test() {
        Utils.printListln(letterCombinations(""));
    }

    public static void main(String[] args) {
    	List<String> s = letterCombinations("");
    	System.out.println(s);
        test();
    }
}
