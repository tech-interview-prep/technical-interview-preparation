package facebook;

/* 	
	 Implement an algorithm to determine if a string has all unique characters.
	 What if you can not use additional data structures?
	
	Link: https://gist.github.com/zac-xin/2398387

*/	
public class HasUniqueCharactersString {
    // the time complexity is O(n), the space complexity is also O(n)
    public static boolean isUniqueChars2(String str) {
        if (str.length() > 256) {
            return false;
        }
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    // the time complexity is O(n), the space complexity is also O(1)
    public static boolean isUniqueChars(String str) {
        if (str.length() > 256) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }
}
