package facebook;

/* 	
	Write a program to sum two binary numbers represented as strings. 

	Input: "110", "01101" 
	Output: "10011" 
	
	Method signature: 
	public String addBinaryNumbers(String num1, String num2);
	
	Link: http://www.careercup.com/question?id=15420859
		  http://www.careercup.com/question?id=5735540389314560
		  http://www.geeksforgeeks.org/add-two-bit-strings/
		  https://gist.github.com/zac-xin/4381455

*/	
public class SumOfBitStrings {	 
	// The main function that adds two bit sequences and returns the addition
	String addBitStrings( String first, String second ){
		String result = "";  // To store the sum bits
		
	    int len1 = first.length();
	    int len2 = second.length();
	    // make the lengths same before adding

	    if (len1 < len2)
	    {
	        for (int i = 0 ; i < len2 - len1 ; i++)
	        	first = '0' + first;
	    }
	    else if (len1 > len2)
	    {
	        for (int i = 0 ; i < len1 - len2 ; i++)
	        	second = '0' + second;
	    }
	 
	    int length = first.length();
	 
	    int carry = 0;  // Initialize carry
	 
	    // Add all bits one by one
	    for (int i = length-1 ; i >= 0 ; i--)
	    {
	        int firstBit = first.charAt(i) - '0';
	        int secondBit = second.charAt(i) - '0';
	 
	        // boolean expression for sum of 3 bits
	        int sum = (firstBit ^ secondBit ^ carry)+'0';
	 
	        result = (char)sum + result;
	 
	        // boolean expression for 3-bit addition
	        carry = (firstBit & secondBit) | (secondBit & carry) | (firstBit & carry);
	    }
	 
	    // if overflow, then add a leading 1
	    if (carry > 0)
	        result = '1' + result;
	 
	    return result;
	}
}
