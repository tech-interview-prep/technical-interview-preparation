import java.util.*;
public class ValidSudoku {
	public static boolean isValid(char[][] board){ //row,column
		if(board == null || board.length != 9 || board[0].length != 9){
			return false;
		}
		
		Hashtable<Character, Boolean>row = new Hashtable<Character, Boolean>();
        Hashtable<Character, Boolean>col = new Hashtable<Character, Boolean>();
        Hashtable<Character, Boolean>sq = new Hashtable<Character, Boolean>();

		for(int i = 0; i < 9; i++){
			row.clear(); //clears out the keys to start off with new numbers
			col.clear();
			for(int j = 0; j < 9; j++){
				if(board[i][j] != '.'){ //each column
					if(col.containsKey(board[i][j])){
						return false;
					} else {
						col.put(board[i][j],true);
					}

				}
				if(board[j][i] != '.'){ //each row
					if(row.containsKey(board[j][i])){
						return false;
					} else {
						row.put(board[j][i],true);
					}
				}

			}
		}

		//3 by 3 matrix
		for(int ii = 0; ii < 9; ii = ii + 3){
			for(int jj = 0; jj < 9; jj = jj + 3){ //entire sq
				sq.clear();
				for(int i = ii; i < ii + 3; i++){ //row
					for(int j = jj; j < jj + 3; j++){
						if(board[i][j] != '.'){
							//just have to do row by row
							if(sq.containsKey(board[i][j])){
								return false;
							}
							else {
								sq.put(board[i][j],true);
							}
						}
					}
				}
			}
		}

		return true;

	}

}