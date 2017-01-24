package leetcode.algorithms;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid
 * are all surrounded by water.
 *
 * Example 1:
 *     11110
 *     11010
 *     11000
 *     00000
 * Answer: 1
 *
 * Example 2:
 *     11000
 *     11000
 *     00100
 *     00011
 * Answer: 3
 *
 * https://leetcode.com/problems/number-of-islands/
 * https://github.com/poplav92/ProgrammingProblems/blob/master/NumberOfIslands.java
 */
public class NumberOfIslands {

}

class Solution_NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, m, n, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int x, int y, int m, int n, boolean[][] visited) {
        if((x < m) && (x >= 0) && (y < n) && (y >= 0) && !visited[x][y] && grid[x][y] != '0') {
            visited[x][y] = true;
            dfs(grid, x + 1, y, m, n, visited);
            dfs(grid, x, y + 1, m, n, visited);
            dfs(grid, x - 1, y, m, n, visited);
            dfs(grid, x, y - 1, m, n, visited);
        }
    }

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i, j + 1);
    }

    public int numIslands3(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfsFill(grid, i, j);
                    count++;
                }
            }
        return count;
    }

    private void dfsFill(char[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfsFill(grid, i + 1, j);
            dfsFill(grid, i - 1, j);
            dfsFill(grid, i, j + 1);
            dfsFill(grid, i, j - 1);
        }
    }
}
