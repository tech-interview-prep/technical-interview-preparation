/*
A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns
the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after
each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or
vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */
package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * @author bkoteshwarreddy
 */

public class _305NumberofIslandsII {

}

class Solution_NumberofIslandsII {
    // union find Solution
    int []id;
    // deceide the root
    public int root(int n) {
        if(id[n] == 0) {
            return 0;
        }
        while(id[n] != n) {
            n = id[n];
        }
        return n;
    }

    public boolean neighbor(int row, int col, int m, int n) {
        if(row < 0 || col < 0 || row >= m || col >= n) {
            return false;
        }
        return id[row * n + col + 1] != 0;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    public int searchNeighbor(int row, int col, int m, int n) {
        // search four directions
        int count = 1;
        int pos = row * n + col + 1;
        // up
        if(neighbor(row - 1, col, m, n)) {
            int idx = (row - 1) * n + col + 1;
            if(root(idx) != pos) {
                union(root(idx), pos);
                --count;
            }
        }
        // down
        if(neighbor(row + 1, col, m, n)) {
            int idx = (row + 1) * n + col + 1;
            if(root(idx) != pos) {
                union(root(idx), pos);
                --count;
            }
        }
        // left
        if(neighbor(row, col - 1, m, n)) {
            int idx = row * n + col;
            if(root(idx) != pos) {
                union(root(idx), pos);
                --count;
            }
        }
        // right
        if(neighbor(row, col + 1, m, n)) {
            int idx = row * n + col + 2;
            if(root(idx) != pos) {
                union(root(idx), pos);
                --count;
            }
        }
        return count;
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        
        if(m <= 0 || n <= 0 || positions == null) {
            return res;
        }
        
        id = new int[m * n + 1];
        int count = 0;
        for(int i = 0; i < positions.length; ++i) {
            // find neighbor with 1
            int row = positions[i][0];
            int col = positions[i][1];

            // set the parent of (row, col): its idx
            id[row * n + col + 1] = row * n + col + 1;
            // union its neighbor
            count += searchNeighbor(row, col, m, n);
            res.add(count);
        }
        return res;
    }
}
