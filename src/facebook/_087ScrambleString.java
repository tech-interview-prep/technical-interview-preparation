/**
 * @author bkoteshwarreddy
 * 
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great":
 * 
 *     great
 *     /    \
 *    gr    eat
 *   / \    /  \
 *  g   r  e   at
 *             / \
 *            a   t
 *       
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * 
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 *      
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * 
 *      rgtae
 *      /    \
 *     rg    tae
 *    / \    /  \
 *   r   g  ta  e
 *          / \
 *         t   a
 *         
 * We say that "rgtae" is a scrambled string of "great".
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * 
 * https://leetcode.com/problems/scramble-string/
 * 
 * Link: https://gist.github.com/WeizhengZhou/5d1a6c3029cc5ed65e35
 *       http://www.lifeincode.net/programming/leetcode-scramble-string-java/
 *       
 * Time ComplexityL O(N^4)
 */

package facebook;

public class _087ScrambleString {
  public static void main(String[] args) {
  }
}

class Solution_ScrambleString {
	public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null) return false;
		if(s1.length() != s2.length()) return false;

		int n = s1.length();
		//dp[i][j][l] represents whether s1.sub(i,i+l) is a scramble string of s2.sub(j,j+l)
		boolean[][][] dp = new boolean[n][n][n+1];
		for(int l=1;l<=n;l++){//length = 1 to n
			for(int i=0;i<=n-l;i++){//i from 0 to n-length
				for(int j=0;j<=n-l;j++){//j from 0 to n-length
					if(s1.substring(i,i+l).equals(s2.substring(j,j+l)))//identical
						dp[i][j][l] = true;
					else{
						for(int k=1;k<l;k++){
							//s1.sub(i,i+l) = s1.sub(i,i+k) + s1.sub(i+k,i+l)
							//s2.sub(j,j+l) = s2.sub(j,j+k) + s2.sub(j+k,j+l)
							dp[i][j][l] = dp[i][j][l] || (dp[i][j][k] && dp[i+k][j+k][l-k]);
							//s1.sub(i,i+l) = s1.sub(i,i+k)     + s1.sub(i+k,i+l)
							//s2.sub(j,j+l) = s2.sub(j,j+l-k) + s2.sub(j+l-k,j+l)
							dp[i][j][l] = dp[i][j][l] || (dp[i][j+l-k][k] && dp[i+k][j][l-k]);
							//found a possible solution
							if(dp[i][j][l]) break;
						}
					}
				}
			}
		}
		return dp[0][0][n];
	}
}
