public class ReverseString {
	public static void main(String[] args){
		String a = "    Alex     ";
		reverseStr(a);

	}
	private static void reverseStr(String str){
		//at times you would need to trim if theres whitespace, ask the interviewer
		str = str.trim();
		char[] arr = str.toCharArray();
		int len = str.length()-1;

		if(str == null) throw new IllegalArgumentException("String is new and invalid");
		else if(str.length() == 0) return "";

		for(int i = 0; i < str.length()/2;++i){
			char temp = str.charAt(i); 
			arr[i] = arr[len];
			arr[len] = temp;
			len--; //decrement to get next element 
		}
		String newString = new String(arr);
		System.out.println(newString);
	}

	private static String recursiveStr(String str){
		if(str.length() < 2){
			return str;
		}

		return recursiveStr(str.substring(1) + str.charAt(0));
	}
}