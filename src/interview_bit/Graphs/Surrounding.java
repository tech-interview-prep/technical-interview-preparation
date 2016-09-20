package interview_bit.graphs;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by priyavivek on 11/26/15.
 *
 * Problem statement
 *
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,

 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 *
 *
 */
public class Surrounding {

    boolean[][] visited;
    int M;
    int N;

    public void solve(ArrayList<ArrayList<Character>> a) {

        M = a.size();
        N = a.get(0).size();

        if(M == 0){
            return;
        }

        visited = new boolean[M][N];

        //Need to find the 'O' nodes on the edges. All the nodes that are connected to these nodes are not surrounded by 'X'


        //Find 'O' nodes for the first and last column
        for(int i=0;i<M;i++){
            if(a.get(i).get(0) == 'O'){
                if(!visited[i][0]) {
                    dfs(a, i, 0);
                }
            }

            if(a.get(i).get(N-1) == 'O'){
                if(!visited[i][N-1]) {
                    dfs(a, i, N - 1);
                }
            }
        }



        //Find 'O' nodes for the first and last row
        for(int i=0;i<N;i++){
            if(a.get(0).get(i) == 'O'){
                if(!visited[0][i]) {
                    dfs(a, 0, i);
                }
            }

            if(a.get(M-1).get(i) == 'O'){
                if(!visited[M-1][i]) {
                    dfs(a, M - 1, i);
                }
            }
        }

        //Fill in regions of 'O' surrounded by 'X'
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    a.get(i).set(j,'X');
                }
            }
        }


    }

    //Depth first search to find all the nodes connected to the edge 'O' nodes
    public void dfs(ArrayList<ArrayList<Character>> a,int row,int col){

        visited[row][col] = true;


        //Move up
        if(isValid(row-1,col)){
            if(!visited[row-1][col] && a.get(row-1).get(col) == 'O'){
                dfs(a,row-1,col);
            }

        }

        //Move down
        if(isValid(row+1,col)){
            if(!visited[row+1][col] && a.get(row+1).get(col) == 'O'){
                dfs(a,row+1,col);
            }

        }

        //Move left
        if(isValid(row,col-1)){
            if(!visited[row][col-1] && a.get(row).get(col-1) == 'O'){
                dfs(a,row,col-1);
            }

        }

        //Move right
        if(isValid(row,col + 1)){
            if(!visited[row][col + 1] && a.get(row).get(col + 1) == 'O'){
                dfs(a,row,col + 1);
            }

        }




    }

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

        Surrounding s = new Surrounding();
        ArrayList<Character> row1 = new ArrayList<Character>(Arrays.asList('X','X','X','X'));
        ArrayList<Character> row2 = new ArrayList<Character>(Arrays.asList('X','O','O','X'));
        ArrayList<Character> row3 = new ArrayList<Character>(Arrays.asList('X','X','O','X'));
        ArrayList<Character> row4 = new ArrayList<Character>(Arrays.asList('X','O','X','X'));

        ArrayList<ArrayList<Character>> ip = new ArrayList<>();
        ip.add(row1);
        ip.add(row2);
        ip.add(row3);
        ip.add(row4);

        s.solve(ip);

    }


}
