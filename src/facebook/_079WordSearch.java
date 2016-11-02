package facebook;

import utils.Utils;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 *
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 * https://leetcode.com/problems/word-search
 * https://gist.github.com/bittib/5676353
 * http://n00tc0d3r.blogspot.com/2013/07/word-search.html
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
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        // find the starting char
        for (int i=0; i<board.length; ++i) {
            for (int j=0; j<board[0].length; ++j) {
                if (searchWord(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }

       return false;
    }

    private boolean searchWord(char[][] board, int x, int y, String word, int cur, boolean[][] visited) {
        // validate input
        if (visited[x][y] || board[x][y] != word.charAt(cur)){
            return false;
        }
        if (cur == word.length() - 1) {
            return true;
        }

        // mark the node as visited
        visited[x][y] = true;

        // BFS on its neighbers
        if (
            (x > 0 && searchWord(board, x-1, y, word, cur+1, visited)) ||
            (x+1 < board.length && searchWord(board, x+1, y, word, cur+1, visited)) ||
            (y > 0 && searchWord(board, x, y-1, word, cur+1, visited)) ||
            (y+1 < board[0].length && searchWord(board, x, y+1, word, cur+1, visited))
        ) {
            return true;
        }

        // mark the node as unused
        visited[x][y] = false;
        return false;
    }
}
