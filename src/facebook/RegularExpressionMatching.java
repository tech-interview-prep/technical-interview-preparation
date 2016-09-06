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

package facebook;

public class RegularExpressionMatching {
    /*
        Iterative solution, from http://blog.sina.com.cn/s/blog_b9285de20101gw2x.html
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
