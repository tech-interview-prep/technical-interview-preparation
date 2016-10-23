package interviewBit.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by priyavivek on 11/27/15.
 *
 * Problem statement
 *
 * Knight movement on a chess board

 Given any source point and destination point on a chess board, we need to find whether Knight can move to the destination or not.

 Knight's movements

 The above figure details the movements for a knight ( 8 possibilities ). Note that a knight cannot go out of the board.

 If yes, then what would be the minimum number of steps for the knight to move to the said point.
 If knight can not move from the source point to the destination point, then return -1

 Input:

 N, M, x1, y1, x2, y2
 where N and M are size of chess board
 x1, y1  coordinates of source point
 x2, y2  coordinates of destination point
 Output:

 return Minimum moves or -1
 Example

 Input : 8 8 1 1 8 8
 Output :  6
 */
public class Knight {
    private static final int[] moveX = new int[]{2,2,1,-1,-2,-2,1,-1};
    private static final int[] moveY = new int[]{1,-1,2,2,1,-1,-2,-2};
    private final int NUM_MOVES = 8;

    public int knight(int N, int M, int x1, int y1, int x2, int y2) {

        boolean[][] visited = new boolean[N][M];
        int count = 0;


        Queue<Point> queue = new LinkedList<Point>();
        Point startPoint = new Point(x1,y1);
        queue.add(startPoint);

        //Use BFS to find the shortest path from start point to end point
        while(!queue.isEmpty()){

            int queuesize = queue.size();
            int x,y;
            for(int i=0;i<queuesize;i++){
                Point currPoint = queue.poll();
                x = currPoint.x;
                y = currPoint.y;
                visited[x-1][y-1] = true;
                if(x == x2 && y == y2){
                    return count;
                }

                //There are 8 possible moves from a given point. Check to see if a position has not been visited.
                //If it hasn't been visited, add it to the queue
                for(int j=0;j<NUM_MOVES;j++){
                    int nextX = x+moveX[j];
                    int nextY = y+moveY[j];

                    if(isWithinBounds(N,M,nextX,nextY)){
                        Point nextPoint = new Point(nextX,nextY);
                        if(!visited[nextX-1][nextY-1]){
                            queue.add(nextPoint);
                        }
                    }

                }

            }

            count++;
        }

        //No path from start point to end point
        return -1;

    }



    public boolean isWithinBounds(int N, int M, int x, int y){
        if(x < 1 || x > N || y < 1 || y >  M){
            return false;
        }

        return true;


    }

    public class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args){
        Knight k = new Knight();
        int result = k.knight(2,20,1,18,1,5);

        System.out.println("Min moves: " + result);



    }
}
