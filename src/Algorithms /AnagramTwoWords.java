import java.util.*;

public class AnagramTwoWords {
	
	public static void main(String[]args){
		String s1 = "word";
		String s2 = "rowd";
		System.out.println(optimizedFindAnagram(s1,s2));
	}

	public static boolean findAnagrams(String word, String anagram){
		if(word.length() != anagram.length()) return false; 

		if(word == null || anagram == null || word.length() == 0 || anagram.length() == 0) return false;

		char[] wordArr = word.toCharArray();
		char[] anagramArr = anagram.toCharArray();
		Arrays.sort(wordArr);
		Arrays.sort(anagramArr);

		return Arrays.equals(wordArr,anagramArr); //O(nlog n) where n is the number of characters and logn is the sorting
	}

	//Optimized: O(n) solution
	public static boolean optimizedFindAnagram(String word, String anagram){
		if(word.length() != anagram.length()) return false;

		Hashtable<Character,Integer>map = new Hashtable<Character,Integer>();

		for(int i = 0; i < word.length();++i){
			if(!map.containsKey(word.charAt(i))) map.put(word.charAt(i),1);
			else map.put(word.charAt(i), map.get(word.charAt(i))+1);
		}

		for(int j = 0; j < anagram.length();++j){
			if(map.get(anagram.charAt(j)) == null) return false;
			else if(map.get(anagram.charAt(j)) == 1) map.remove(anagram.charAt(j)); //eventually it will be empty
			else map.put(anagram.charAt(j),map.get(anagram.charAt(j))-1);
		}
		return map.isEmpty();
	}
}