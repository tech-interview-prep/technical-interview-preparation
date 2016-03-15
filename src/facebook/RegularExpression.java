package facebook;

public class RegularExpression {
    /*
 	Implement regular expression matching with support for '.' and '*'.

 	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.

	The matching should cover the entire input string (not partial).

	The function prototype should be:
	bool isMatch(const char *s, const char *p)

	Some examples:
	isMatch("aa","a") return false
	isMatch("aa","aa") return true
	isMatch("aaa","aa") return false
	isMatch("aa", "a*") return true
	isMatch("aa", ".*") return true
	isMatch("ab", ".*") return true
	isMatch("aab", "c*a*b") return true


	Link: http://www.careercup.com/question?id=5293306254721024
 */
	 public boolean isMatch(String s, String p) {  
	   if (s == null) return (p == null);  
	   if (p.isEmpty()) return (s.isEmpty());  
	   
	   // next char is not '*': do current char match?  
	   if (p.length() == 1 || p.charAt(1) != '*') {  
	     if (s.isEmpty()) return false;  
	     return (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))  
	           && isMatch(s.substring(1), p.substring(1));  
	   }  
	   
	   // next char is '*'  
	   // current char match, zero or more repeats  
	   int i = 0;  
	   while (i < s.length() && (p.charAt(0) == '.' || s.charAt(i) == p.charAt(0))) {  
	     if (isMatch(s.substring(i), p.substring(2))) return true;  
	     i++;  
	   }  
	   
	   // zero  
	   return isMatch(s.substring(i), p.substring(2));  
	 }

   /*
    Implement wildcard pattern matching with support for '?' and '*'.

    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).

    The matching should cover the entire input string (not partial).

    The function prototype should be:
    bool isMatch(const char *s, const char *p)

    Some examples:
      isMatch("aa","a") ? false
      isMatch("aa","aa") ? true
      isMatch("aaa","aa") ? false
      isMatch("aa", "*") ? true
      isMatch("aa", "a*") ? true
      isMatch("ab", "?*") ? true
      isMatch("aab", "c*a*b") ? false
    */

    /*
        Iterative solution, copyed from http://blog.sina.com.cn/s/blog_b9285de20101gw2x.html
    */
    public boolean isMatch2(String s, String p){
        if (s == null) return p == null;
        if (p == null) return false;
        int n = s.length(), m = p.length(), i = 0, j=0, starPosition = -1, iback = 0;
        while (i < n){
            while (j < m && p.charAt(j) == '*'){
                starPosition = j++;
                iback = i;
            }
            if (j == m && (p.charAt(j) != '?' && p.charAt(j) != s.charAt(i))){
                if (starPosition == -1)
                    return false;
                j = starPosition + 1;
                i = ++iback;
            }else{
                i++;
                j++;
            }
        }
        while (j < m && p.charAt(j) == '*')
            j++;
        return j == m;
    }

}
