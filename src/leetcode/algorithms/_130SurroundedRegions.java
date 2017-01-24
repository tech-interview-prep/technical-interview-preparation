package leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author bkoteshwarreddy
 */
public class _130SurroundedRegions {
    /*
    Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

    A region is captured by flipping all 'O's into 'X's in that surrounded region .

    For example,
    X X X X
    X O O X
    X X O X
    X O X X
    After running your function, the board should be:

    X X X X
    X X X X
    X X X X
    X O X X
     */
    public static void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        List<Integer> queue = new ArrayList<Integer>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'V';
                    boolean isSurrounded = true;
                    int startIndex = 0;
                    queue.add(i);
                    queue.add(j);
                    while (startIndex < queue.size()) {
                        int iIndex = queue.get(startIndex), jIndex = queue.get(startIndex + 1);
                        if (isSurrounded && iIndex == 0 || iIndex == board.length - 1 || jIndex == 0 || jIndex == board[0].length - 1) {
                            isSurrounded = false;
                        }
                        startIndex += 2;
                        if (iIndex > 0 && board[iIndex - 1][jIndex] == 'O') {
                            queue.add(iIndex - 1);
                            queue.add(jIndex);
                            board[iIndex - 1][jIndex] = 'V';
                        }

                        if (iIndex < board.length - 1 && board[iIndex + 1][jIndex] == 'O') {
                            queue.add(iIndex + 1);
                            queue.add(jIndex);
                            board[iIndex + 1][jIndex] = 'V';
                        }

                        if (jIndex > 0 && board[iIndex][jIndex - 1] == 'O') {
                            queue.add(iIndex);
                            queue.add(jIndex - 1);
                            board[iIndex][jIndex - 1] = 'V';
                        }

                        if (jIndex < board[0].length - 1 && board[iIndex][jIndex + 1] == 'O') {
                            queue.add(iIndex);
                            queue.add(jIndex + 1);
                            board[iIndex][jIndex + 1] = 'V';
                        }
                    }
                    if (isSurrounded) {
                        for (int k = 0; k < queue.size(); k += 2) {
                            board[queue.get(k)][queue.get(k + 1)] = 'X';
                        }
                    }
                    queue.clear();
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void solve2(char[][] board) {
        if (board.length == 0) {
            return;
        }

        int m = board.length, n = board[0].length;
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = 'V';
                queue.add(0);
                queue.add(i);
            }

            if (board[m - 1][i] == 'O') {
                board[m - 1][i] = 'V';
                queue.add(m - 1);
                queue.add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'V';
                queue.add(i);
                queue.add(0);
            }

            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = 'V';
                queue.add(i);
                queue.add(n - 1);
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.remove(), j = queue.remove();
            if (i > 0 && board[i - 1][j] == 'O') {
                queue.add(i - 1);
                queue.add(j);
                board[i - 1][j] = 'V';
            }

            if (i < m - 1 && board[i + 1][j] == 'O') {
                queue.add(i + 1);
                queue.add(j);
                board[i + 1][j] = 'V';
            }

            if (j > 0 && board[i][j - 1] == 'O') {
                queue.add(i);
                queue.add(j - 1);
                board[i][j - 1] = 'V';
            } if (j < n - 1 && board[i][j + 1] == 'O') {
                queue.add(i);
                queue.add(j + 1);
                board[i][j + 1] = 'V';
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static char[][] getSampleBoard() {
        return new char[][] {
                   "XXXX".toCharArray(),
                   "XOOX".toCharArray(),
                   "XXOX".toCharArray(),
                   "XOXX".toCharArray()
               };
    }

    private static char[][] getSampleBoard2() {
        return new char[][] {
                   "XOXOXO".toCharArray(),
                   "OXOXOX".toCharArray(),
                   "XOXOXO".toCharArray(),
                   "OXOXOX".toCharArray()
               };
    }

    private static void printBoard(char[][] board) {
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void test() {
//        char[][] board = getSampleBoard();
        char[][] board2 = getSampleBoard2();
//        solve(board);
        solve2(board2);

//        printBoard(board);
        printBoard(board2);
    }

    public static void main(String[] args) {
        test();
    }
}
