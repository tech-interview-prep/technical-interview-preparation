//largest prime problem
import java.util.*;
public class Problem3 {
	public final static long NUM = 600851475143L;

	public static void main(String[] args){
		System.out.println(lgPrime(NUM));

	}
	public static long lgPrime(long num){
		for(long i = 2; i < num; ++i){ //start with first prime number
			while(num % i == 0){  //checking if its prime and prime factor
				num = num / i;
			}
		}
		return num;
	}

}