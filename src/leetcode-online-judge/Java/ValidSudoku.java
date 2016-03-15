package leetcode_online_judge;

import utils.Utils;

import java.util.Set;
import java.util.HashSet;

public class ValidSudoku {
    /*
    Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

    // see 250px-Sudoku-by-L2G-20050714.svg.png


    A partially filled sudoku which is valid.
    */
    public static boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<Character>();
        Set<Character> colSet = new HashSet<Character>();
        //row
        for (int i = 0; i < 9; i++) {
            rowSet.clear();
            colSet.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && colSet.contains(board[j][i])) {
                    return false;
                }
                rowSet.add(board[i][j]);
                colSet.add(board[j][i]);
            }
        }

        //block
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rowSet.clear();
                for (int k = i * 3; k < (i + 1) * 3; k++) {
                    for (int l = j * 3; l < (j + 1) * 3; l++) {
                        if (board[k][l] != '.' && rowSet.contains(board[k][l])) {
                            return false;
                        }
                        rowSet.add(board[k][l]);
                    }
                }
            }
        }

        return true;
    }

    private static void test() {
        char[][] board = new char[][]{
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
