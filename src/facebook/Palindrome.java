package facebook;

/* 	
	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

	For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.

	Note:
		Have you consider that the string might be empty? This is a good question to ask during an interview.
		
		For the purpose of this problem, we define empty string as valid palindrome.
	
	Link: http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/
	
*/	
public class Palindrome {
	public static boolean isValidPalindrome(String s){
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

    public static boolean isValidPalindromeNumber(int n) {
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
