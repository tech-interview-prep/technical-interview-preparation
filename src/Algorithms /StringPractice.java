import java.util.*;
import java.io.*;

/**
 * Practice String questions
 */

public class StringPractice {
	
	//Print duplicate characters from String
	public static void printDuplicate(String str){
		Hashtable<Character,Integer>map = new Hashtable<Character,Integer>();
		for(char ch: str.toCharArray()){
			if(!map.containsKey(ch))
				map.put(ch,1);
			else 
				map.put(ch, map.get(ch)+1);
		}
		for(Map.Entry<Character,Integer>entry: map.entrySet()){
			if(entry.getValue() > 1)
				System.out.println(entry.getKey());
		}
	}

	//Find first nonrepeated character - put into hashtable<Character,Integer>,
	//loop through hashtable and return key where value equals 1 


	//Find Number of Times Per Char 
	public static void numberofTimes(String str){
		Hashtable<Character,Integer>map = new Hashtable<Character,Integer>();

		for(char ch: str.toCharArray()){
			if(!map.containsKey(ch))
				map.put(ch,1);
			else 
				map.put(ch, map.get(ch)+1);
		}

		for(Map.Entry<Character,Integer>entry: map.entrySet()){
			System.out.println("char: " + entry.getKey() + " frequency: " +  entry.getValue());
		}
	}

	//Check if a String contains only digits
	public static boolean containsDigit(String str){
		for(int i = 0; i < str.length();++i){
			if(!Character.isDigit(str.charAt(i))) return false;
		}
		return true;
	}

	//Count number of vowels and consonants 
	public static void validator(String str){
		int vowelCount = 0;
		int consonantCount = 0;
		for(int i = 0; i < str.length();++i){
			if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || 
				str.charAt(i) == 'i' || str.charAt(i) == 'o' ||
				str.charAt(i) == 'u' ) vowelCount++;
			else consonantCount ++;
		}
		System.out.println(vowelCount + " vowels");
		System.out.println(consonantCount + " consonants");
	}	

	//Reverse words in a sentence
	public static String reverseSentence(String str){
		if(str == null) throw new IllegalArgumentException("String invalid!");
		String[] arr = str.split(" +"); //split on more than 1 space
		StringBuilder res = new StringBuilder();

		for(int i = arr.length-1; i >= 0; i--){
			res.append(arr[i].trim() + " ");
		}
		return res.toString();
	}


	//Remove an specific character from String
	public static String removeChar(String str, char value){
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < str.length();++i){
			if(str.charAt(i) != value) res.append(str.charAt(i) + "");
		}
		return res.toString();
	}

	//Remove all duplicate characters in String, remember to used a set
	//Input: 'Bananas'
	//Output: 'Bans'
	public static String allDuplicate(String str){
		Set<Character>set = new HashSet<Character>();
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < str.length();++i){
			if(!set.contains(str.charAt(i))){
				set.add(str.charAt(i));
				res.append(str.charAt(i) + "");
			} 
		}
		return res.toString();
	}

	
	//Find highest occured character in String
	public static char highestOccur(String str){
		Hashtable<Character,Integer>map = new Hashtable<Character,Integer>();
		int maxCount = 0;
		for(int i = 0; i < str.length();++i){
			if(!map.containsKey(str.charAt(i))) map.put(str.charAt(i),1);
			else map.put(str.charAt(i),map.get(str.charAt(i))+1);

			if(map.get(str.charAt(i)) > maxCount) maxCount = map.get(str.charAt(i));
		}
		for(Map.Entry<Character,Integer>entry: map.entrySet()){
			if(entry.getValue() == maxCount) return entry.getKey();
		}
		throw new IllegalArgumentException("no occurence found");		
	}

	//Count Word in String
	public static int countWord(String str){
		int count = 0;
		for(int i = 0; i < str.length();++i){
			if(str.charAt(i) == ' ') count ++;
		}
		count++; //account for last one
		return count;
	}

	//Find longest Substring Without Repeating Characters
	public static int lenOfLongestSubstring(String str){
		if(str == null) return 0;
		boolean[] flag = new boolean[256];
		int res = 0;
		int start = 0;
		char[] arr = str.toCharArray();

		for(int i = 0; i < arr.length;++i){
			char current = arr[i];
			if(flag[current]){
				res = Math.max(res, i - start);
				for(int k = start; k < i;++k){
					if(arr[k] == current){
						start = k + 1; //start is the endpoint of substring
						System.out.println("start: " + start);
						break;
					}
					flag[arr[k]] = false;
				}
			} else {
				flag[current] = true;
			}
		}
		res = Math.max(res, arr.length - start);
		return res;
	}

	//Implement a function to find the first character in a string which only appears once.
	//Input: "abaccdeff", Output:"b"

	public static String firstCharacterOnce(String str){
		HashMap<Character,Integer>map = new HashMap<Character,Integer>();
		for(int i = 0; i < str.length();++i){
			char ch = str.charAt(i);
			if(!map.containsKey(ch))
				map.put(ch,1);
			else 
				map.put(ch,map.get(ch)+1);
		}
		for(Map.Entry<Character,Integer>entry: map.entrySet()){
			if(entry.getValue() == 1) return entry.getKey().toString();
		}
		return "";
	}

	public static void main(String[] args){
		String str = "abaccdeff";
		System.out.println(firstCharacterOnce(str));
		
	}


}

