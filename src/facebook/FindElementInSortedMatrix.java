package facebook;

/* 	
	Given a matrix in which each row and each column is sorted, write a method to find an element in it.
	
	Link: https://gist.github.com/zac-xin/3950004

*/	
public class FindElementInSortedMatrix {
    public static boolean findElement(int[][] matrix, int elem) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == elem) {
                return true;
            } else if (matrix[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
