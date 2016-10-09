package interview_bit.graphs;
import java.util.ArrayList;

/**
 * Created by priyavivek on 11/26/15.
 *
 * Problem statement
 *
 *
 * Given N * M field of O's and X's, where O=white, X=black
 Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

 Example:

 OOOXOOO
 OOXXOXO
 OXOOOXO

 answer is 3 shapes are  :
 (i)    X
 X X
 (ii)
 X
 (iii)
 X
 X
 Note that we are looking for connected shapes here.

 For example,

 XXX
 XXX
 XXX
 is just one single connected black shape.
 */
public class Black {

    boolean[][] visited;
    int M,N;

    public int black(ArrayList<String> a) {
        M = a.size();
        N = a.get(0).length();

        visited = new boolean[M][N];

        int count = 0;

        //Do a DFS to find all connected X's from a given X
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++) {
                if (!visited[i][j] && a.get(i).charAt(j) == 'X') {
                    dfs(a, i, j);
                    count++;
                }


            }

        }


        return count;



    }


    public void dfs(ArrayList<String> a,int row,int col){

        visited[row][col] = true;


        //Move up
        if(isValid(row-1,col)){
            if(!visited[row-1][col] && a.get(row-1).charAt(col) == 'X'){
                dfs(a,row-1,col);
            }

        }

        //Move down
        if(isValid(row+1,col)){
            if(!visited[row+1][col] && a.get(row+1).charAt(col) == 'X'){
                dfs(a,row+1,col);
            }

        }

        //Move left
        if(isValid(row,col-1)){
            if(!visited[row][col-1] && a.get(row).charAt(col - 1) == 'X'){
                dfs(a,row,col-1);
            }

        }

        //Move right
        if(isValid(row,col + 1)){
            if(!visited[row][col + 1] && a.get(row).charAt(col + 1) == 'X'){
                dfs(a,row,col + 1);
            }

        }




    }

    //Find if row and col vals are within bounds
    public boolean isValid(int i,int j){
        if(i < 0 || i >= M){
            return false;
        }

        if(j < 0 || j >= N){

            return false;

        }

        return true;

    }

    public static void main(String[] args){
        Black b = new Black();
        String row1 = new String();
        String row2 = new String();
        String row3 = new String();
        row1 = "OOOXOOO";
        row2 = "OOXXOXO";
        row3 = "OXOOOXO";


        ArrayList<String> ip = new ArrayList<>();
        ip.add(row1);
        ip.add(row2);
        ip.add(row3);


        int result = b.black(ip);

        System.out.println(result);



    }


}
