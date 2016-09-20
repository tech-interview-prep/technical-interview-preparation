  /*
  You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the
distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled
with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
   */
package facebook;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/walls-and-gates/
 * @author bkoteshwarreddy
 */

public class _286WallsandGates {
}

class Solution_WallsandGates {
    public LinkedList<Integer>queue = new LinkedList<Integer>();
    public void change(int[][]rooms, int i, int j, int val) {
        if(i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] == -1 || rooms[i][j] == 0) {
            return;
        }
        if(val < rooms[i][j]){
            rooms[i][j] = val;
            queue.add(i * rooms[0].length + j);
        }
        return;
    }
    public void bfsRooms(int[][] rooms) {
        while(!queue.isEmpty()) {
            int top = queue.pop();
            int i = top / rooms[0].length;
            int j = top % rooms[0].length;
            change(rooms, i + 1, j, rooms[i][j] + 1);
            change(rooms, i - 1, j, rooms[i][j] + 1);
            change(rooms, i, j - 1, rooms[i][j] + 1);
            change(rooms, i, j + 1, rooms[i][j] + 1);
        }
    }
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                // find the gate
                if(rooms[i][j] == 0) {
                    queue.add(i * n + j);
                }
            }
        }
        bfsRooms(rooms);
        return;
    }
}
