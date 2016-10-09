import java.util.*;
public class ValidParentheses {
	public static void main(String[] args){
		String valid = "()[]{}";
		String invalid = "([)]";
		String test3 = "(]{})";

		System.out.println(isValid(valid));
		System.out.println(isValid(invalid));
		System.out.println(isValid(test3));
	}
	public static boolean isValid(String s) {
		Map<Character,Character>validMap = new HashMap<Character,Character>();
		validMap.put('(',')');
		validMap.put('{','}');
		validMap.put('[',']');

		Stack<Character>stack = new Stack<Character>();
		for(int i = 0; i < s.length(); ++i){
			char curr = s.charAt(i);
			if(validMap.keySet().contains(curr)){
				stack.push(curr);
			} else if(validMap.values().contains(curr)){
				if(!stack.empty() && validMap.get(stack.peek()) == curr){
					//you know that is valid ie ()
					stack.pop(); //if its empty its true
				} else {
					return false;
				}
			}
		}
		return stack.empty(); 
    }
}
