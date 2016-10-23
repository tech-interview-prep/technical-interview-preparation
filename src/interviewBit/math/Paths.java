package interviewBit.math;

/**
 * Created by priyavivek on 10/19/15.
 *
 * Problem statement
 *
 * A robot is located at the top-left corner of an A x B grid

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

 How many possible unique paths are there?

 Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

 Example :

 Input : A = 2, B = 2
 Output : 2

 2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
 OR  : (0, 0) -> (1, 0) -> (1, 1)
 *
 *
 */
public class Paths {
    public int uniquePaths(int a, int b) {
        return uniquePaths(0, 0, a - 1, b - 1);

    }

    public int uniquePaths(int curra, int currb, int targeta, int targetb) {
        if (curra == targeta && currb == targetb) {
            return 1;
        } else if (curra < targeta && currb < targetb) {
            return uniquePaths(curra + 1, currb, targeta, targetb) + uniquePaths(curra, currb + 1, targeta, targetb);
        } else if (curra < targeta) {
            return uniquePaths(curra + 1, currb, targeta, targetb);
        } else if (currb < targetb) {
            return uniquePaths(curra, currb + 1, targeta, targetb);
        }

        return 0;

    }

    public static void main(String[] args) {
        Paths p = new Paths();
        int result;
        result = p.uniquePaths(2, 2);
        System.out.println("Number of unique paths is " + result);


    }
}
