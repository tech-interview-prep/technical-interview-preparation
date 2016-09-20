  /*

      Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

      For example,
      "A man, a plan, a canal: Panama" is a palindrome.
      "race a car" is not a palindrome.

      Note:
        Have you consider that the string might be empty? This is a good question to ask during an interview.

        For the purpose of this problem, we define empty string as valid palindrome.

      Link: http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/

    */
package facebook;

import utils.Utils;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * @author bkoteshwarreddy
 */
public class _125ValidPalindrome {
    public static void main(String[] args) {
      Solution_ValidPalindrome sol = new Solution_ValidPalindrome();
      Utils.printTestln(sol.isPalindrome("A man, a plan, a canal: Panama"), true);
      Utils.printTestln(sol.isPalindrome("race a car"), false);
    }
}

class Solution_ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        while(start < end) {
            if(!Character.isAlphabetic(s.charAt(start)) && !Character.isDigit(s.charAt(start))) {
                start++;
            } else if(!Character.isAlphabetic(s.charAt(end)) && !Character.isDigit(s.charAt(end))) {
                end--;
            } else if(s.charAt(start) != s.charAt(end)){
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    public boolean isValidPalindrome(String s){
        if(s==null || s.length()==0) return false;

        int i = 0;
        int j = s.length();
        while(i<j) {
            if(s.charAt(i) == ' ') {
                i++;
            } else if(s.charAt(j) == ' ') {
                j--;
            } else if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValidPalindromeNumber(int n) {
        int k = 1;
        while (n / k > 10) {
            k *= 10;
        }
        while (n != 0) {
            int i = n % 10;
            int j = n / k;
            if (i != j) {
                return false;
            }
            n = (n % k) / 10;
            k = k / 100;
        }
        return true;
    }
}
