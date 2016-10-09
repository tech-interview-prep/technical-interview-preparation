public class ValidPalindrome {
	public static void main(String[] args){
		String a = "racecar";
		String invalid = "re";
		String b = "";
		String c = ".ab";
		System.out.println(valid(c));
	}
	public static boolean valid(String str){ //str = "racecar"
		//for cases like ".a"
		//removes all characters not in a-zA-Z0-9
		str = str.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println("new str: " + str);

		if(str == " " || str.length() == 0) return true;
		else if(str == null) throw new IllegalArgumentException("Invalid String");

		for(int i = 0; i < str.length();++i){
			if(str.charAt(i) != str.charAt(str.length()-i-1)) return false;
		}
		return true;
	}
}