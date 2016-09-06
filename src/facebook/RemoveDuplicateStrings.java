package facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
	Code a function that receives an array with duplicates and returns a new array keeping the original
	order of the elements but with the duplicates removed.

    For example, if the input were


    @[ @"dog", @"cat", @"dog", @"fish" ]
    the output would be


    @[ @"dog", @"cat", @"fish" ]
    Tell the complexity of the solution.

	Link: http://www.careercup.com/question?id=5086256895623168

*/
public class RemoveDuplicateStrings {
	public List<String> removeDuplicates(List<String> input) {
	  if(input == null || input.size() == 0) {
          return input;
      }

      HashSet<String> set = new HashSet<String>();
      List<String> newList = new ArrayList<String>();

      for(String s: input) {
          if(!set.contains(s)) {
              set.add(s);
              newList.add(s);
          }
      }

      return newList;
	}
}
