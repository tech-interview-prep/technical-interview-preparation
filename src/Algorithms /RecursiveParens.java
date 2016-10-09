import java.util.*;
public class RecursiveParens {
	//Algorithmn Approach: Insert a pair of parenthesis inside every existing pair of parenthesis(left, then right, as well as beginning)

	public static HashSet<String> recursiveParen(int input){
		HashSet<String>set = new HashSet<String>(); //set to catch duplicates 

		if(input == 0){
			set.add(""); //add blank slate
		} else {
			HashSet<String>prev = recursiveParen(input-1); //build the solution for input by adding pairs of parenthesis to input-1
			for(String s: prev){
				for(int i = 0; i < s.length();++i){
					if(s.charAt(i) == '('){
						//call a helper method to insert a pair of parethensis inside every existing pair of parenthesis, not forgetting beginning
						String res = insertInside(s,i);
						//add result from helper method
						set.add(res); //catches duplicates
					}
				}
				set.add("()" + s); //adds it to the front for corner case and for when input = 1
			}
		}
		return set;

	}
	private static String insertInside(String s, int leftIndex){
		//need to add () leftIndex +1, from substring 1
		String left = s.substring(0,leftIndex + 1); //since second parenth is exclusive
		String right = s.substring(leftIndex+1,s.length());
		return left + "()" + right;
	}

	public static void main(String[] args){
		System.out.println(recursiveParen(1));
	}

}