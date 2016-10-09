import java.util.*;
import java.io.*;

/* Constraints:
 * 1. n > 0
 * 2. n is in the low thousands range for faster result 
 */

//Find the 3rd, 58th, and 10,001th prime number
public class FindNthPrime {
	public static int findPrime(int num){
		if(num < 1) return 0;

		int currentNum, count = 0;
		//count used to iterate and keep in place the nth placement for 
		//the prime number you're looking for.
		for(currentNum = 2; count < num; currentNum++){
			if(isPrime(currentNum)){
				count++;
			}
		}
		System.out.println("currentNum is: " + currentNum);
		System.out.println("count is: " + count);
		return currentNum - 1;
	}

	//optimized version of isPrime used sqrt
	public static boolean isPrime(int num){
		if(num < 2) return false;

		int sqrt = (int) Math.sqrt(num);

		for(int i = 2; i <= sqrt; i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args){
		System.out.println(FindNthPrime.findPrime(3));
		System.out.println(FindNthPrime.findPrime(58));
		System.out.println(FindNthPrime.findPrime(100001));
	} 
}

