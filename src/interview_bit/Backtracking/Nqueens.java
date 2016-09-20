package interview_bit.backtracking;
import java.util.*;
/**
 * Created by priyavivek on 11/14/15.
 *
 * Problem statement
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:

 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 */
public class Nqueens {
    ArrayList<ArrayList<String>> soln = new ArrayList<>();

    public ArrayList<ArrayList<String>> solveNQueens(int N) {

        int[][] restricted = new int[N][N];
        ArrayList<String> result = new ArrayList<>();
        computeNQueens(N,0,restricted,result);
        return soln;
    }

    public void computeNQueens(int N,int row,int[][] restricted,ArrayList<String> result){

        //Base case of recursion
        if(row == N){
            soln.add(result);
            return;
        }

        int[][] currRestricted = new int[N][N];

        for(int i=0;i<N;i++){

            //Copy the original value of restricted for each iteration, so as to not have previous iterations influence the current one
            for(int m=0;m<N;m++){
                for(int n=0;n<N;n++){
                    currRestricted[m][n] = restricted[m][n];
                }
            }

            //Check if a Queen can be placed in the current position
            if(currRestricted[row][i] != 1){
                StringBuilder s = new StringBuilder();
                for(int j=0;j<N;j++){
                    if(j==i){
                        s.append('Q');
                    }else{
                        s.append('.');
                    }
                }
                ArrayList<String> currRow = new ArrayList<>();
                currRow.addAll(result);
                currRow.add(s.toString());

                //Update restricted boxes based on current Queen position
                updateRestricted(currRestricted,row,i,N);

                computeNQueens(N,row+1,currRestricted,currRow);

            }

        }

    }

    public void updateRestricted(int[][] restricted,int row,int col,int N){
        //Update the entire row
        for(int i=0;i<N;i++){
            restricted[row][i] = 1;
        }

        //Update the entire column
        for(int i=0;i<N;i++){
            restricted[i][col] = 1;
        }

        //Update diagonal elements
        int i=row;
        int j=col;

        //Left and up
        while( i >= 0 && i < N && j >= 0 && j < N){
            restricted[i][j] = 1;
            i--;
            j--;
        }

        i=row;
        j=col;

        //right and up
        while( i >= 0 && i < N && j >= 0 && j < N){
            restricted[i][j] = 1;
            i--;
            j++;
        }

        i=row;
        j=col;

        //right and down
        while( i >= 0 && i < N && j >= 0 && j < N){
            restricted[i][j] = 1;
            i++;
            j++;
        }

        i=row;
        j=col;


        //left and down
        while( i >= 0 && i < N && j >= 0 && j < N){
            restricted[i][j] = 1;
            i++;
            j--;
        }



    }

    public static void main(String[] args){

        Nqueens n = new Nqueens();
        ArrayList<ArrayList<String>> s = new ArrayList<>();
        s = n.solveNQueens(5);


    }

}
