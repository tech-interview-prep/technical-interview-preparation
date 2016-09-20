package interview_bit.arrays;

import java.util.ArrayList;

/**
 * Problem statement
 *
 * You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to
 (x+1, y),
 (x - 1, y),
 (x, y+1),
 (x, y-1),
 (x-1, y-1),
 (x+1,y+1),
 (x-1,y+1),
 (x+1,y-1)
 You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.

 Example :

 Input : [(0, 0), (1, 1), (1, 2)]
 Output : 2
 It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 *
 *
 */
public class Reach {
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {

        int arrayLength = X.size();

        int minSteps = 0;

        for(int i=0;i<arrayLength-1;i++){
            int currX = X.get(i);
            int currY = Y.get(i);

            int nextX = X.get(i+1);
            int nextY = Y.get(i+1);

            while((currX != nextX) || (currY != nextY)){
                if(currX > nextX){
                    currX-=1;
                }else if(currX < nextX){
                    currX+=1;
                }

                if(currY > nextY){
                    currY-=1;
                }else if(currY < nextY){
                    currY+=1;
                }
                minSteps++;

            }

        }

        return minSteps;


    }



}
