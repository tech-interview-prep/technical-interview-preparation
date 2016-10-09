import java.util.*;

public class AnagramQuestions {
	
	/**
 	 * Given a list of words like [rats,star,arts,cie,ice]. Group same anagrams into buckets and output them.
 	 */

	public static void groupAnagram(ArrayList<String> list){
		Collections.sort(list); //makes the inner lists lexographic order
		Hashtable<String,List<String>>map = new Hashtable<String,List<String>>();
		for(String s : list){
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			String sortedStr = String.valueOf(arr);

			List<String>temp = new ArrayList<String>();

			if(!map.containsKey(sortedStr)){
				temp.add(s);
				map.put(sortedStr,temp);
			} else 
				map.get(sortedStr).add(s);
		}

		for(Map.Entry<String,List<String>>entry: map.entrySet()) System.out.println(entry.getValue());
	}
	
	/**
 	 * Given an array of strings, return all groups of strings
 	 * that are anagrams to each other.
 	 */

  	public static List<String> findAnagrams(String[] strs){
	    List<String>result = new ArrayList<String>();
	     
	    if(strs == null || strs.length == 0){
	      return result;
	    }else if(strs.length == 1){ 
	      result.add(strs[0]); //return original string 
	      return result;
	    }
	    
	    Hashtable<String, List<String>>map = new Hashtable<String, List<String>>();

	    for(int i = 0; i < strs.length;++i){
	      String origWord = strs[i];
	      char[] arr = origWord.toCharArray();
	      Arrays.sort(arr);
	      String sortedStr = String.valueOf(arr);
	      
	      List<String>tempList = new ArrayList<String>();

	      if(!map.containsKey(sortedStr)){
	        tempList.add(origWord);
	        map.put(sortedStr,tempList);
	      } else map.get(sortedStr).add(origWord); //adds origWord to existing key
	    }

	    for(Map.Entry<String,List<String>>entry: map.entrySet()){
	      if(entry.getValue().size() > 1){
	        result.addAll(entry.getValue());
	      }
	    }
	    return result; 
  }
  
	public static void main(String[] args){
		String[] strs = { "alex", "tiger", "gietr"};
      	List<String> anagrams = findAnagrams(strs);

		ArrayList<String> s = new ArrayList<String>();
		s.add("star");
		s.add("rats");
		s.add("ice");
		s.add("arts");
		s.add("cie");
		groupAnagram(s);
	}




}
