package leetcode.ImprovedSolutions;

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
 * http://n00tc0d3r.blogspot.com/2013/07/word-search.html
 */
public class WordSearch {
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
    /**
     * There are O(n*m) candidates for starting cell. For each of them we run a DFS with branching factor 3 and
     * depth at most k, where k is the length of the word. The worst case running time for DFS is O(3^k). The worst
     * case total running time is (n*m*2^k).
     * In this algorithm, we use a boolean matrix to store visited information, which requires O(n*m) extra spaces.
     * If we are allowed to modify the original matrix, we can mark a cell as visited by setting it to some special
     * value, such as "#". By doing this, space complexity gets down to O(1). Again, this method modifies the original
     * matrix which may not be a prefer way in practise.
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];

        // find the starting char
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (searchWord(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchWord(char[][] board, String word, boolean[][] visited, int i, int j, int current) {
        // validate input
        if (visited[i][j] || board[i][j] != word.charAt(current)) {
            return false;
        }
        if (current == word.length() - 1) {
            return true;
        }

        // mark the node as visited
        visited[i][j] = true;
        current++;
        // BFS on its neighbors
        if (
            (i > 0 && searchWord(board, word, visited, i - 1, j, current)) ||
            (i + 1 < board.length && searchWord(board, word, visited, i + 1, j, current)) ||
            (j > 0 && searchWord(board, word, visited, i, j - 1, current)) ||
            (j + 1 < board[0].length && searchWord(board, word, visited, i, j + 1, current))
            ) {
            return true;
        }

        // mark the node as unused
        visited[i][j] = false;

        return false;
    }
}
