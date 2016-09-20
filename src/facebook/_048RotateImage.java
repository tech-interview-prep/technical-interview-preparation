/*
     Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method
     to rotate the image by 90 degrees. Can you do this in place?

    You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).

    Follow up:
    Could you do this in-place?

*/

package facebook;

public class _048RotateImage {
public static void main(String[] args) {

  }
}

class RotateMatrix {
    public void rotate(int[][] input, int n){
        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - 1 - layer;
            for(int i = 0; i < last - layer ; i++){
                int offset = i - first;

                // Save top
                int top = input[first][i];
                // left -> top
                input[first][i] = input[last-offset][first];

                // bottom -> left
                input[last-offset][first] = input[last][last - offset];

                // right -> bottom
                input[last][last - offset] = input[i][last];

                // top -> right
                input[i][last] = top;
            }
        }
    }

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = temp;
			}
		}
	}
}
