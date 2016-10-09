import java.util.*;

public class spiral_matrix {
    public static void spiral(int[][] matrix){
        //if length of matrix is 0 
        if(matrix.length == 0) return;
        
        int topIndex = 0;
        int leftIndex = 0;
        int down = matrix.length - 1; //catch off by 1 errors
        int right = matrix[0].length - 1; //catch off by 1 errors 
        //[column][row index]
        
        while(true){
            for(int i = leftIndex; i <= right; ++i){
                System.out.print(matrix[topIndex][i] + " "); //print topmost row
            }
            topIndex++; //for rightmost column to start at 1 for column [1][...]
            
            for(int j = topIndex; j <= down; ++j){
                System.out.print(matrix[j][right] + " "); //print rightmost column
            }
            right--;
            
            for(int i = right; i >= leftIndex; --i){
                System.out.print(matrix[down][i] + " "); //print bottommost row
            }
            down--;
            
            for(int j = down; j >= topIndex; --j){
                System.out.print(matrix[j][leftIndex] + " "); //print leftmost column
            }
            leftIndex++;
            
            if(topIndex > down || leftIndex > right) break;
        }
    }
    
    public static void main(String[] args){
        int[][] matrix = {{11,12,13,14,15},{21,22,23,24,25}, {31,32,33,34,35},{41,42,43,44,45}};
        spiral(matrix);
    }
}