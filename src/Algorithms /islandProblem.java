import java.util.*;
//http://www.careercup.com/question?id=14948781

public class islandProblem {
	public static void main(String[] args){
		int[][] world = { ///world length is 5
				{1,1,0,0,0},
				{0,1,0,0,1},
				{1,0,0,1,1},
				{0,0,0,0,0},
				{1,0,1,0,1}

		};

		System.out.println(bestIsland(world));
	}

	public static int islandValue(int[][] world, boolean[][] visited, int row, int column){
		int currentIslandValue = 0;

		for(int i = row - 1; i <= row + 1; i++){
			for(int j = column - 1; j <= column + 1; j++){
				if(i != row && j != column) continue;
				if(i < 0 || j > world.length - 1 /* deals with index*/ || j < 0 || j > world[0].length-1) continue;
				if(visited[i][j]) continue;

				visited[i][j] = true;
				currentIslandValue += islandValue(world,visited, i, j);
			}
		}
		return currentIslandValue;
	}

	public static int bestIsland(int[][] world){
  		boolean[][] visited = new boolean[world.length][world[0].length];

	  	for (int i = 0; i < world.length; i++) { //take in consideration the visited case 
		    for (int j = 0; j < world[0].length; j++) { //based upon 
		      visited[i][j] = (world[i][j] <= 0);
		    }
	  	}

	  	int bestIslandValue = 0;
    
  		for (int i = 0; i < world.length; i++) {
    		for (int j = 0; j < world[0].length; j++) {
      			if (!visited[i][j]) {
        			visited[i][j] = true;
        			bestIslandValue = Math.max(bestIslandValue, islandValue(world, visited, i, j));
      			}
    		}
  		}
  
  		return bestIslandValue;	
	} 
}


// 	public static int countIslands(int[][] world, boolean[][] visited, int row, int column){
		
// 		if(world == null || world.length == 0){
// 			return 0;
// 		}

// 		int result = 0;

// 		for(int row = 0; row < matrix.length; row++){
// 			for(int column = 0; column < matrix[row].length;column++){
// 				if(world[row][column] == 1){
// 					result++;
// 					doFill(world,row,column);
// 				}
// 			}
// 		}

// 		return result;
// 	}

// 	public static void doFill(int[][] world, int row, int column){
// 		if(row < 0 || column < 0 || row >= world.length || column >= world[0].length || world[row][column] == 0){
// 			return;
// 		}
// 		world[row][column] = 0;
// 		int dr[] = {-1,0,1,0};
// 		int dc[] = {0,1,0,-1};
// 		for(int i = 0; i< dr.length; i++){
// 			doFill(world,row + dr[i], column + dc[i]);
// 		}
// 	}

// }