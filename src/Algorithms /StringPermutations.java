import java.util.*;

public class StringPermutations {
	public static void main(String[] args){
		String str = "lse";
		System.out.println(permutate(str));
	}

	public static ArrayList<String> permutate(String str){
		ArrayList<String> res = new ArrayList<String>();

		if(str.length() == 1) {
			res.add(str);
			return res;
		}

		char first = str.charAt(0);
		
		//Get all permutations of length n-1
		ArrayList<String>permutations = permutate(str.substring(1)); //rest of the string

		for(String permutation: permutations){ //iterate over all permutations of length n-1
			res.addAll(insertAllPositions(first,permutation));
		}
		return res;

	}
	public static ArrayList<String> insertAllPositions(char ch, String s){
		ArrayList<String>listPerms = new ArrayList<String>();

		for(int i = 0; i <= s.length();++i){
			String inserted = s.substring(0,i) + ch + s.substring(i);
			listPerms.add(inserted);
		}
		return listPerms;
	}
}