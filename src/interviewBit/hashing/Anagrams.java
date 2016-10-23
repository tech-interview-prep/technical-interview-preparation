package interviewBit.hashing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by priyavivek on 11/11/15.
 *
 * Problem statement
 *
 * Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.

 Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp'
 Note: All inputs will be in lower-case.
 Example :

 Input : cat dog god tca
 Output : [[1, 4], [2, 3]]
 cat and tca are anagrams which correspond to index 1 and 4.
 dog and god are another set of anagrams which correspond to index 2 and 3.
 The indices are 1 based ( the first element has index 1 instead of index 0).

 Ordering of the result : You should not change the relative ordering of the words / phrases within
 */
public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        //Initialize a boolean array that indicates if a word in the list has already been visited and it was found to be in an anagram group.
        boolean[] flags = new boolean[a.size()];

        for (int i = 0; i < a.size(); i++) {
            String string1 = a.get(i);
            ArrayList<Integer> temp = new ArrayList<>();

            //Check if the current element hasn't been visited before

            if (flags[i] != true) {
                temp.add(i + 1);
                flags[i] = true;
            } else {
                continue;
            }

            //Find the groups of anagrams in the list
            for (int j = 0; j < a.size(); j++) {
                if (j != i && flags[j] != true) {
                    String string2 = a.get(j);
                    if (isAnagram(string1, string2)) {
                        temp.add(j + 1);
                        flags[j] = true;
                    }
                }
            }

            result.add(temp);

        }

        return result;


    }


    //Method to determine if 2 strings are anagrams of each other or not
    public boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        HashMap<Character, Integer> aTable = new HashMap<>();

        //Store the counts of all the characters of the first string in a hashmap
        for (int i = 0; i < a.length(); i++) {
            Character currChar = a.charAt(i);
            if (aTable.containsKey(currChar)) {
                aTable.put(currChar, aTable.get(currChar) + 1);
            } else {
                aTable.put(currChar, 1);
            }
        }

        //Now iterate through the second string and decrement the count of the characters
        for (int j = 0; j < b.length(); j++) {
            Character currChar = b.charAt(j);
            if (!aTable.containsKey(currChar)) {
                return false;
            } else if (aTable.get(currChar) == 0) {
                return false;
            } else if (aTable.get(currChar) > 0) {
                aTable.put(currChar, aTable.get(currChar) - 1);
            }

        }

        return  true;


    }

    public static void main(String[] args) {
        Anagrams a = new Anagrams();
        List<String> ip = new ArrayList<String>(Arrays.asList( "abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"));
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        result = a.anagrams(ip);

    }
}
