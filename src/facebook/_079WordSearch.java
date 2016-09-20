/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

Link: https://gist.github.com/bittib/5676353

*/

package facebook;

import utils.Utils;

/**
 * https://leetcode.com/problems/subsets/
 * @author bkoteshwarreddy
 */
public class _079WordSearch {
    public static void main(String[] args) {
      char[][] board = new char[][] {
        "abce".toCharArray(),
        "sfcs".toCharArray(),
        "adee".toCharArray()
      };

      Solution_WordSearch sol = new Solution_WordSearch();

      Utils.printTestln(sol.exist(board, "abcced"), true);
      Utils.printTestln(sol.exist(board, "see"), true);
      Utils.printTestln(sol.exist(board, "abcb"), false);
      Utils.printTestln(sol.exist(Utils.getLargeBoard(), "oajgdkcokvfpdaslnmomrpgwitwdoku"), true);
      Utils.printTestln(sol.exist(Utils.getLargeBoard2(), " lcpsvdhalttairlfa"), false);
    }
}

class Solution_WordSearch {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public boolean exist(char[][] board, String word) {
        if ( word.length() == 0 || board.length == 0 || board[0].length == 0 ) return false;
        int m = board.length, n = board[0].length;
        if ( m*n < word.length() ) return false;

        boolean[][] visited = new boolean[m][n];
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if ( board[i][j] == word.charAt(0) ){
                    visited[i][j] = true;
                    if ( dfs(board, i, j, visited, word, 1) )
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, boolean[][] visited, String word, int idx){
        if (idx == word.length())
            return true;
        for (int i=0; i<4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            if ( xx >= 0 && xx < board.length &&
                    yy >= 0 && yy < board[0].length &&
                    !visited[xx][yy] && board[xx][yy] == word.charAt(idx)){

                visited[xx][yy] = true;
                if ( dfs(board, xx, yy, visited, word, idx+1))
                    return true;
                visited[xx][yy] = false;
            }
        }
        return false;
    }

    public static boolean exist2(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, word, new boolean[m][n], i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, String word, boolean[][] hasVisited, int i, int j, int wStart) {
        if (wStart == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(wStart) || hasVisited[i][j]) {
            return false;
        }
        hasVisited[i][j] = true;
        if (exist(board, word, hasVisited, i - 1, j, wStart + 1)
                || exist(board, word, hasVisited, i, j + 1, wStart + 1)
                || exist(board, word, hasVisited, i + 1, j, wStart + 1)
                || exist(board, word, hasVisited, i, j - 1, wStart + 1)) {
            return true;
        }
        hasVisited[i][j] = false;
        return false;
    }
}
