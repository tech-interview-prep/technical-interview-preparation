/**
 * Given a string find the length of longest substring which has none of its character repeated.
 * 
 * Link: http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 */
package facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _003LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    Solution_LongestSubstringNoRepeatingChars sol = new Solution_LongestSubstringNoRepeatingChars();
    System.out.println(sol.longestSubStrWithTwoChars("eceba"));
  }
}

class Solution_LongestSubstringNoRepeatingChars {
    public int findNonRepeastSubString(String target){
        Map<Character, Integer> char2pos = new HashMap<Character, Integer>();

        int start = 0;
        int end = -1;
        int max = 0;
        for(int i=0; i< target.length(); i++){
            end++;
            if(char2pos.containsKey(target.charAt(i))){
                //only move start when the repeat is after start, discard any char before start
                if(char2pos.get(target.charAt(i))>=start)
                    start = char2pos.get(target.charAt(i)) + 1;
            }
            //update the new pos to i
            char2pos.put(target.charAt(i), i);
            if(end-start>max){
                max = end-start;
            }
        }
        return max + 1;
    }

    /*
	 * "abcbbbbcccbdddadacb", the longest substring that
	 * contains 2 unique character is "bcbbbbcccb".
	 *
	 */
    public String longestSubStrWithTwoChars(String s){
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

    /*
     * input: aabccdaga
     * output: abc
     *
     * @param s
     */
    public int LongestSubStrWithUniqueChars(String s){
        if(s==null || s.isEmpty())
            return 0;

        char[] chars = s.toCharArray();

        int current = 0;//current pos in string
        int length = 0; //current longest substr length
        int pos = 0;    //current longest substr starting pos

        for(current =0 ; current<s.length(); current++){
            pos = current;
            boolean[] found = new boolean[256];
            while(current<s.length() && !found[chars[current]]){
                found[chars[current]] = true;
                current++;
            }
            length = Math.max(length, current - pos);
            current = pos;
        }
        return length;
    }
}
