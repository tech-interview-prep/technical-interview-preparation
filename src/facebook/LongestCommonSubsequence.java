package facebook;

/*
	Dynamic Programming : Longest Common Subsequence

	Link: https://gist.github.com/bittib/5547064

*/
public class LongestCommonSubsequence {
    public String lcs(String a, String b){
        int m = a.length(), n = b.length();
        int[][] f = new int[m+1][n+1];
        for (int i=0; i<=n; i++)
            f[0][i] = 0;
        for (int i=0; i<=m; i++)
            f[i][0] = 0;
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (a.charAt(i-1) == b.charAt(j-1))
                    f[i][j] = f[i-1][j-1] + 1;
                else
                    f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
            }
        }
        // f[m][n] is the length of lcs

        // construct lcs based on 2D array f
        char[] lcs = new char[f[m][n]];
        int i = m, j = n, idx = f[m][n]-1;
        while (f[i][j] != 0){
            if (f[i][j] == f[i][j-1])
                j--;
            else if (f[i][j] == f[i-1][j])
                i--;
            else{
                lcs[idx--] = a.charAt(i-1);
                i--;
                j--;
            }
        }
        return new String(lcs);
    }
}
