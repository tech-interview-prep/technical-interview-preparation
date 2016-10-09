//Given a string and array of strings, find whether the array contains
//a string with one character difference from the given string.
//Array may contain string of different lengths? 

import java.util.*;
public class FindStringByCharDiff {
	public static void main(String[] args){
		String[] arr = {"bana","apple", "banaba","bonanza", "banamf"};
		System.out.println(findStringByDiff("banana",arr));
	}
	//findStringByDiff("banana",[bana,apple, banaba,bonanza, banamf])
	//return true for banaba and banana
	public static boolean findStringByDiff(String str, String[] arr){
		//check to see if arr is null
		if(arr == null || str == null) throw new NullPointerException();

		for(int i = 0; i < arr.length; ++i){

			String x = arr[i]; //
			if(x.length() == str.length()){ //equal lengths
				
				//Definitely create a hashmap of all the chracters in string
				HashMap<Character,Integer>map = new HashMap<Character,Integer>();
				for(int j = 0; i < x.length();++i){
					if(!map.containsKey(x.charAt(i))){
						map.put(x.charAt(i),1);
					} else {
						map.put(x.charAt(i), map.get(x.charAt(i)+1));
					}
				}
				//check str against characters in hash map
				for(int k = 0; k < str.length(); ++i){
					if(map.containsKey(str.charAt(k))){
						int count = map.get(str.charAt(k)).intValue();
						count = count - 1;
						if(count == 0){
							map.remove(str.charAt(k));
						} else {
							map.put(str.charAt(k),count);
						}
					}
				}
				if(map.size() == 1){
					return true; //find a string that differs by one
				}
			}

		}
		return false;

	}
}