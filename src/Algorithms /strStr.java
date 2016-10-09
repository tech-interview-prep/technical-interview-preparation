public class strStr {
	//Return the index of the first occurence of needle in haystack, or -1 if needle is not part of haystack
	public static void main(String[] args){
		System.out.println(strStr("mississippi","issip"));
	}
	public static int strStr(String haystack, String needle){ //"mississippi" "issip"
		if(haystack == null || needle == null) return 0;

		if(needle.length() == 0) return 0;

		for(int i = 0; i < haystack.length();++i){
			int index = i;
            if(i + needle.length() > haystack.length()) return -1; //corner case
			for(int j = 0; j < needle.length();++j){
				if(needle.charAt(j) == haystack.charAt(index)){
					//need to know that the length of needle matches j last index spot 
					if(j == needle.length()-1) return i; //i should be 4
					index++; //increment index location instead of i iteration
				} else break;
			}
		}
		return -1;
	}

}