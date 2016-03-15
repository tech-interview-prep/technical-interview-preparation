package facebook;

/* 	
	Given two strings, return boolean True/False, if they are only one edit apart.
	Edit can be insert/delete/update of only one character in the string. 
	
	Eg: 
		-True 
			xyz,xz 
			xyz, xyk 
			xy, xyz 
		
		
		-False 
			xyz, xyz 
			xyz,xzy 
			x, xyz
	
	Link: http://www.careercup.com/question?id=5092486548553728
	      https://gist.github.com/bittib/5677448

*/	
public class OneEdit {
	public boolean onlyOneEdit(String first, String second) {
	  if(first.equals(second)) {
	    return false;
	  }
	    
	  int l1 = first.length();
	  int l2 = second.length();
	    
	  if(l1 - l2 > 1 || l2 - l1 > 1) {
	    // At least two edits .. no need to continue
	    return false;
	  }
	    
	  String longer = (l1 > l2)? first : second;
	  String shorter = (l1 > l2)? second : first;
	    
	  for(int i = 0; i < shorter.length(); i++) {
	    if(longer.charAt(i) != shorter.charAt(i)) {
	        int shift = (l1 == l2)? 0 : 1;
	        return longer.substring(i + 1 + shift).equals(shorter.substring(i + 1));
	    }
	  }
	  // No difference detected until the end of the shorter string  
	  return true;
	}
}
