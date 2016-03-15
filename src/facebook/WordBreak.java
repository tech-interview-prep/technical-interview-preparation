package facebook;
import java.util.ArrayList;

/*
	Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated 
	sequence of one or more dictionary words.
	
	For example, given
	s = "leetcode",
	dict = ["leet", "code"].
	
	Return true because "leetcode" can be segmented as "leet code".
	
	Time Complexity: O(string length * dict size)
	
	Link: http://www.programcreek.com/2012/12/leetcode-solution-word-break/
 */
public class WordBreak {
	public boolean wordsInDictionary(String str, ArrayList<String> dictionary) {
		if (str == null || dictionary == null) {
			return false;
		}
		int length = str.length();
		String firstHalf = str.substring(0, length/2);
		String secondHalf = str.substring(length/2);
		int append = 0;
		int longest = firstHalf.length() > secondHalf.length() ? firstHalf.length() : secondHalf.length();
		
		for(int i=0; i<longest;i++) {
			if(dictionary.contains(firstHalf)) {
				if(dictionary.contains(secondHalf.substring(2*append))) {
					return true;
				}
			} else if(dictionary.contains(secondHalf)) {
				if(dictionary.contains(firstHalf.substring(0, firstHalf.length() - 2*append))) {
					return true;
				}
			} else {
				firstHalf = str.substring(0, i + 1 + length/2);
				secondHalf = str.substring(length/2 - i - 1);
				append++;
			}
		}
		return false;
	}
}
