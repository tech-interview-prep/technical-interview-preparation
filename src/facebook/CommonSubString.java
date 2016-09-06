package facebook;

public class CommonSubString {

	/*
        Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.

        For example, if the given strings are “GeeksforGeeks” and “GeeksQuiz”,
        the output should be 5 as longest common substring is “Geeks”

        Link: http://www.geeksforgeeks.org/longest-common-substring/

        Time Complexity: O(m*n)
        Auxiliary Space: O(m*n)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 String X = "OldSite: GeeksforGeeks.org";
		 String Y = "NewSite:GeeksQuiz.com";



		   System.out.println( "Length of Longest Common Substring is " + LCSubStr(X, Y, 6));


	}

	public static int LCSubStr(String X, String Y) {
		// Create a table to store lengths of longest common suffixes of
		// substrings. Notethat LCSuff[i][j] contains length of longest
		// common suffix of X[0..i-1] and Y[0..j-1]. The first row and
		// first column entries have no logical meaning, they are used only
		// for simplicity of program
		int m = X.length();
		int n = Y.length();
		int[][] LCSuff = new int[m + 1][n + 1];
		int result = 0; // To store length of the longest common substring

		/* Following steps build LCSuff[m+1][n+1] in bottom up fashion. */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					LCSuff[i][j] = 0;

				else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					LCSuff[i][j] = LCSuff[i - 1][j - 1] + 1;
					result = Math.max(result, LCSuff[i][j]);
				} else
					LCSuff[i][j] = 0;
			}
		}
		return result;
	}

    public static boolean LCSubStr(String X, String Y, int k) {
        // Create a table to store lengths of longest common suffixes of
        // substrings. Notethat LCSuff[i][j] contains length of longest
        // common suffix of X[0..i-1] and Y[0..j-1]. The first row and
        // first column entries have no logical meaning, they are used only
        // for simplicity of program
        int m = X.length();
        int n = Y.length();
        int[][] LCSuff = new int[m + 1][n + 1];
        int result = 0; // To store length of the longest common substring

		/* Following steps build LCSuff[m+1][n+1] in bottom up fashion. */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    LCSuff[i][j] = 0;

                else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    LCSuff[i][j] = LCSuff[i - 1][j - 1] + 1;
                    result = Math.max(result, LCSuff[i][j]);
                    if(result == k) {
                        return true;
                    }
                } else
                    LCSuff[i][j] = 0;
            }
        }
        return false;
    }
}