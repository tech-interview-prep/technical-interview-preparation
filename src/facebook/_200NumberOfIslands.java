/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid
are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

 https://github.com/poplav92/ProgrammingProblems/blob/master/NumberOfIslands.java
 */

package facebook;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-islands/
 * @author bkoteshwarreddy
 */
public class _200NumberOfIslands {

}

class Solution_NumberOfIslands {
    public int numIslands(char[][] grid) {
        return 0;
    }

    public void noOfIslands(int[][] arr) {
        boolean visited [][] = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < visited.length; i++)
            Arrays.fill(visited[i], false);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    dfs(arr, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println("Number of islands = " + count);
    }

    public void dfs(int arr[][], int row, int col, boolean[][] visited) {
        int rowNbr[] = { -1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = { -1,  0,  1, -1, 1, -1, 0, 1};
        visited[row][col] = true;
        for (int i = 0; i < 8; i++) {
            int newRow = row + rowNbr[i];
            int newCol = col + colNbr[i];
            if (newRow >= 0 && newRow < arr.length && newCol >= 0 && newCol < arr[0].length
                    && arr[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                dfs(arr, newRow, newCol, visited);
            }
        }
    }
}
