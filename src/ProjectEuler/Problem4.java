//largest palindrome product 
public class Problem4 {
	public static void main(String[] args){
		System.out.println(lgProduct());

	}

	public static int lgProduct(){
		int product, largest = 0;

		for(int i = 999; i >= 100; i--){
			for(int j = 999; j >= 100; j--){
				product = i * j;
				if(checkPalindrome(product) == true && product > largest){ //takes care of largest and valid palindrome 
					largest = product;
				}
			}
		}
		return largest;
	}

	//check to see if product is a palindrome
	public static boolean checkPalindrome(int num){
		String str = Integer.toString(num);
		boolean valid = true;

		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) != str.charAt(str.length() - i - 1)) 
				valid = false;
		}
		return valid;
	}

}