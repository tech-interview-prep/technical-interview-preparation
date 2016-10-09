import java.util.*;

public class PalindromePermutation {
	/**
	 * Given a string, write a function to check if it is a permutation of a palindrome.
	 * Input: "a", "aab", "racecar", Output: True
	 * Invalid cases: "ab",""
	 */ 
	public static boolean palindromePermutation(String phrase){
		Hashtable<Character,Integer>map = new Hashtable<Character,Integer>();
		for(char c: phrase.toCharArray()){
			if(!map.containsKey(c))
				map.put(c,1);
			else 
				map.put(c,map.get(c)+1);
		}

		for(Map.Entry<Character,Integer>entry: map.entrySet()){
			boolean foundOdd = false;
			if(entry.getValue() % 2 == 1){
				if(foundOdd == true)
					return false;
				foundOdd = true; //only set for odd count characters
			}
		}
		return true;
	}

	public static void main(String[] args){
		System.out.println(palindromePermutation("A man, a plan, a canal, panama"));
	}


}
