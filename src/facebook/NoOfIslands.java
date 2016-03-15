package facebook;

import java.util.Arrays;

/*
    Number of Islands
	int arr [][]= {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1}};
	
	Link: https://github.com/poplav92/ProgrammingProblems/blob/master/NumberOfIslands.java

*/	
public class NoOfIslands {
    void noOfIslands(int[][] arr) {
        boolean visited [][] = new boolean[arr.length][arr[0].length];
        for(int i=0; i<visited.length; i++)
            Arrays.fill(visited[i], false);
        int count = 0;
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[i].length; j++)
            {
                if(arr[i][j] == 1 && !visited[i][j])
                {
                    dfs(arr, i, j, visited);
                    count++;
                }
            }
        }
        System.out.println("Number of islands = " + count);
    }

    void dfs(int arr[][], int row, int col, boolean[][] visited)
    {
        int rowNbr[] = {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = {-1,  0,  1, -1, 1, -1, 0, 1};
        visited[row][col] = true;
        for(int i=0; i<8; i++)
        {
            int newRow = row + rowNbr[i];
            int newCol = col + colNbr[i];
            if(newRow>=0 && newRow < arr.length && newCol>=0 && newCol<arr[0].length
                    && arr[newRow][newCol] == 1 && !visited[newRow][newCol])
            {
                dfs(arr, newRow, newCol, visited);
            }
        }
    }
}
