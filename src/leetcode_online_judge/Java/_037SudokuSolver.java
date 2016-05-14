package leetcode_online_judge.Java;

import utils.Utils;

import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

public class _037SudokuSolver {
    /*
    Write a program to solve a Sudoku puzzle by filling the empty cells.

    Empty cells are indicated by the character '.'.

    // see 250px-Sudoku-by-L2G-20050714.svg.png

    You may assume that there will be only one unique solution.


    A sudoku puzzle...

    // see 250px-Sudoku-by-L2G-20050714_solution.svg.png

    ...and its solution numbers marked in red.
     */
    public static void solveSudoku(char[][] board) {
        List<Set<Character>> rowSet = new ArrayList<Set<Character>>();
        List<Set<Character>> colSet = new ArrayList<Set<Character>>();
        List<Set<Character>> blockSet = new ArrayList<Set<Character>>();

        for (int i = 0; i < 9; i++) {
            rowSet.add(new HashSet<Character>());
            colSet.add(new HashSet<Character>());
            blockSet.add(new HashSet<Character>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                int k = (i / 3) * 3 + (j / 3);
                if (c != '.') {
                    if (rowSet.get(i).contains(c) || colSet.get(j).contains(c) || blockSet.get(k).contains(c)) {
                        return;
                    }
                    rowSet.get(i).add(board[i][j]);
                    colSet.get(j).add(board[i][j]);
                    blockSet.get(k).add(board[i][j]);
                }
            }
        }

        solveSudoku(board, 0, rowSet, colSet, blockSet);
    }

    private static boolean solveSudoku(char[][] board, int index, List<? extends Set<Character>> rowSet,
                                       List<? extends Set<Character>> colSet, List<? extends Set<Character>> blockSet) {
        if (index == 81) {
            return true;
        }

        int i = index / 9, j = index % 9;
        if (board[i][j] != '.') {
            return solveSudoku(board, index + 1, rowSet, colSet, blockSet);
        }

        Set<Character> row = rowSet.get(i);
        Set<Character> col = colSet.get(j);
        int k = (i / 3) * 3 + (j / 3);
        Set<Character> block = blockSet.get(k);

        for (char c = '9'; c > '0'; c--) {
            if (!row.contains(c) && !col.contains(c) && !block.contains(c)) {
                row.add(c);
                col.add(c);
                block.add(c);
                board[i][j] = c;

                if (solveSudoku(board, index + 1, rowSet, colSet, blockSet)) {
                    return true;
                }

                row.remove(c);
                col.remove(c);
                block.remove(c);
                board[i][j] = '.';
            }
        }
        return false;
    }

    private static void test() {
        char[][] board = new char[][] {
                "53..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray()
        };

        solveSudoku(board);
        Utils.print2DArrayln(board);

        System.out.println("\n>>>Another Board:");

        board = new char[][] {
                "..9748...".toCharArray(),
                "7........".toCharArray(),
                ".2.1.9...".toCharArray(),
                "..7...24.".toCharArray(),
                ".64.1.59.".toCharArray(),
                ".98...3..".toCharArray(),
                "...8.3.2.".toCharArray(),
                "........6".toCharArray(),
                "...2759..".toCharArray()
        };

        solveSudoku(board);
        Utils.print2DArrayln(board);

        long start = System.currentTimeMillis();
        System.out.println("\n>>>This is so-called hardest Sudoku in the world:");
        board = new char[][]{
                "8........".toCharArray(),
                "..36.....".toCharArray(),
                ".7..9.2..".toCharArray(),
                ".5...7...".toCharArray(),
                "....457..".toCharArray(),
                "...1...3.".toCharArray(),
                "..1....68".toCharArray(),
                "..85...1.".toCharArray(),
                ".9....4..".toCharArray(),
        };

        solveSudoku(board);
        Utils.print2DArrayln(board);
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void main(String[] args) {
        test();
    }
}
