/**
 * Implement strStr().
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Link: http://www.programcreek.com/2012/12/leetcode-implement-strstr-java/
 * Link: http://algs4.cs.princeton.edu/53substring/KMP.java.html
 * Link: http://www.fmi.uni-sofia.bg/fmi/logic/vboutchkova/sources/KMPMatch_java.html
 * Link: https://github.com/junminstorage/code4fun/blob/master/src/org/blueocean/KMPStringMatch.java
 */

package facebook;

import utils.Utils;

/**
 * https://leetcode.com/problems/implement-strstr/
 * @author bkoteshwarreddy
 */
public class _028ImplementStrStr {
  public static void main(String[] args) {
    Solution_ImplementStrStr sol = new Solution_ImplementStrStr();
    
    Utils.printTestln(sol.strStr("hello, world", "world"), "worldd");
    Utils.printTestln(sol.strStr("hello, world", "word"), null);
    Utils.printTestln(sol.strStr("a", ""), "a");
  }
}

class Solution_ImplementStrStr {
  public String strStr(String haystack, String needle) {
    int m = haystack.length(), n = needle.length(), i, j;
    for (i = 0; i < m - n + 1; i++) {
      for (j = 0; j < n && haystack.charAt(i + j) == needle.charAt(j); j++);

      if (j == n) {
        return haystack.substring(i);
      }
    }
    return null;
  }

  public String strStrSearch(String text, String pattern) {
    if(pattern == null || text==null) {
      return null;
    }

    int patternLen = pattern.length();
    int textLen = text.length();

    if (patternLen == textLen && patternLen == 0)
      return "";

    if (patternLen == 0)
      return text;

    for (int i = 0; i < textLen; i++) {
      // make sure in boundary of needle
      if (textLen - i + 1 < patternLen)
        return null;

      int k = i;
      int j = 0;

      while (j < patternLen && k < textLen && pattern.charAt(j) == text.charAt(k)) {
        j++;
        k++;
        if (j == patternLen)
          return text.substring(i);
      }
    }

    return null;
  }
}
