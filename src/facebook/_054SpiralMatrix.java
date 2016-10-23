package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example, given the following matrix:
 *     [
 *         [ 1, 2, 3 ],
 *         [ 4, 5, 6 ],
 *         [ 7, 8, 9 ]
 *     ]
 *
 * You should return [1,2,3,6,9,8,7,4,5].
 *
 * If more than one row and column left, it can form a circle and we process the circle.
 * Otherwise, if only one row or column left, we process that column or row ONLY.
 *
 * https://leetcode.com/problems/spiral-matrix
 * http://www.programcreek.com/2013/01/leetcode-spiral-matrix-java/
 * http://n00tc0d3r.blogspot.com/2013/05/rotate-image.html
 */
public class _054SpiralMatrix {
    public static void main(String[] args) {

    }
}

class Solution_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int i, topRow = 0, leftCol = 0, btmRow = matrix.length, rightCol = matrix[0].length;

        /*  topRow - starting row index
            btmRow - ending row index
            leftCol - starting column index
            rightCol - ending column index
            i - iterator
        */

        while (topRow < btmRow && leftCol < rightCol) {
            /* Print the first row from the remaining rows */
            for (i = leftCol; i < rightCol; ++i) {
                result.add(matrix[topRow][i]);
            }
            topRow++;

            /* Print the last column from the remaining columns */
            for (i = topRow; i < btmRow; ++i) {
                result.add(matrix[i][rightCol - 1]);
            }
            rightCol--;

            /* Print the last row from the remaining rows */
            if ( topRow < btmRow) {
                for (i = rightCol - 1; i >= leftCol; --i) {
                    result.add(matrix[btmRow - 1][i]);
                }
                btmRow--;
            }

            /* Print the first column from the remaining columns */
            if (leftCol < rightCol) {
                for (i = btmRow - 1; i >= topRow; --i) {
                    result.add(matrix[i][leftCol]);
                }
                leftCol++;
            }
        }
        return result;
    }
}
