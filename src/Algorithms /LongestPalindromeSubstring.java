import java.util.*;

public class LongestPalindromeSubstring {
	private static int start, maxLen;
    
    public static String longestPalindrome(String s) {
        int len = s.length();
        
        if (len < 2)
            return s;

        //when length is > 2 
        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        System.out.println(s.substring(start,start + maxLen));
        return s.substring(start, start + maxLen);
    }

    private static void extendPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (maxLen < j - i - 1) {
            start = i + 1;
            maxLen = j - i - 1;
        }
    }

	public static void main(String[] args){
		String s = "abcdeba";
		longestPalindrome(s);
	}





}

