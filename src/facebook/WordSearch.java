package facebook;

/* 	
	Given a 2D board and a word, find if the word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
    horizontally or vertically neighboring. The same letter cell may not be used more than once.

    For example,
    Given board =

    [
      ["ABCE"],
      ["SFCS"],
      ["ADEE"]
    ]

    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.
	
	Link: https://gist.github.com/bittib/5676353

*/	
public class WordSearch {
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

    boolean dfs(char[][] board, int x, int y, boolean[][] visited, String word, int idx){
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
}
