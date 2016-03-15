package facebook;

import java.util.LinkedList;
import java.util.List;

/*
	Print all possible words from phone digits
	
	Link: http://www.geeksforgeeks.org/find-possible-words-phone-digits/
	      http://www.lifeincode.net/programming/leetcode-letter-combinations-of-a-phone-number-java/

*/	
public class PhoneNumberToAlphabets {
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

    public List<String> letterCombinations(String digits) {
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
}
