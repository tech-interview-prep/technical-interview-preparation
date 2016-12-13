package leetcode.algorithms.level.Easy;

import java.util.HashSet;
import java.util.Set;

import utils.Utils;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * @author bkoteshwarreddy
 */
public class ValidSudoku {
    /**
     * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
     *
     * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
     *
     * A partially filled sudoku which is valid.
     */
    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;
        // check each column
        for (int i = 0; i < 9; i++) {
            boolean[] m = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (m[(int) (board[i][j] - '1')]) {
                        return false;
                    }
                    m[(int) (board[i][j] - '1')] = true;
                }
            }
        }

        //check each row
        for (int j = 0; j < 9; j++) {
            boolean[] m = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (m[(int) (board[i][j] - '1')]) {
                        return false;
                    }
                    m[(int) (board[i][j] - '1')] = true;
                }
            }
        }

        //check each 3*3 matrix
        for (int block = 0; block < 9; block++) {
            boolean[] m = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        if (m[(int) (board[i][j] - '1')]) {
                            return false;
                        }
                        m[(int) (board[i][j] - '1')] = true;
                    }
                }
            }
        }

        return true;
    }

    private static void test() {
        char[][] board = new char[][] {
            ".1...1...".toCharArray(),
            ".........".toCharArray(),
            ".........".toCharArray(),
            ".........".toCharArray(),
            ".........".toCharArray(),
            ".........".toCharArray(),
            ".........".toCharArray(),
            ".........".toCharArray(),
            ".........".toCharArray()
        };

        Utils.printTestln(isValidSudoku(board), false);

        board = new char[][] {
            ".87654321".toCharArray(),
            "2........".toCharArray(),
            "3........".toCharArray(),
            "4........".toCharArray(),
            "5........".toCharArray(),
            "6........".toCharArray(),
            "7........".toCharArray(),
            "8........".toCharArray(),
            "9........".toCharArray()
        };
        Utils.printTestln(isValidSudoku(board), true);

    }

    public static void main(String[] args) {
        test();
    }

}
