package leetcode_online_judge.Java;

import java.util.HashSet;
import java.util.Set;

public class _159LongestSubstringWithAtMostTwoDistinctCharacters {
    /*
	Longest Substring with At Most Two Distinct Characters

        Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
        For example, Given s = “eceba”,
        T is “ece” which its length is 3.
	 */
    public static String longestSubStrWithTwoChars(String s){
        if(s==null || s.isEmpty())
            return null;

        char[] chars = s.toCharArray();
        String result = null; //current longest substr with two chars

        int current = 0;//current pos in string
        int length = 0; //current longest substr length
        int pos = 0;    //current longest substr starting pos

        for(current=0; current<chars.length; current++){
            pos = current;
            Set<Character> found = new HashSet<Character>();
            while(current<chars.length){
                found.add(chars[current]);
                if(found.size()<3 )
                    current++;
                else
                    break;
            }
            if(length < current-pos){
                result = s.substring(pos, current);
                length = current - pos;
            }
            current = pos;
        }
        return result;
    }
}
