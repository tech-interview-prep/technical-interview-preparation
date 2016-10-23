package interviewBit.hashing;

import java.util.HashMap;

/**
 * Created by priyavivek on 11/18/15.
 *
 * Problem statement
 *
 * Given a string,
 find the length of the longest substring without repeating characters.

 Example:

 The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

 For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class Repeatstr {
    public int lengthOfLongestSubstring(String a) {

        int maxLen = 1;
        HashMap<Character,Integer> mappings = new HashMap<>();
        int end = 0;



        for(int i=0;i<a.length();i++) {
            int j=i;
            //Keep moving forward as long as a duplicate character is not found
            while (!mappings.containsKey(a.charAt(j))) {
                mappings.put(a.charAt(j),1);

                j++;
                if(j > a.length()-1){
                    break;
                }
            }

            //When a duplicate character is found, clear the hashmap and find the length of the substring
            //Update length of maximum substring if current substrings length is greater

            end = j-1;
            int currLen = end - i +1;
            if(currLen > maxLen){
                maxLen = currLen;
            }

            mappings.clear();
        }

        return maxLen;

    }

    public static void main(String[] args){
        Repeatstr r = new Repeatstr();
        int result = r.lengthOfLongestSubstring("u");
        System.out.println(result);


    }
}
