import java.util.*;
//Even Fibonacci numbers but starting with 1,2
class Problem2 {
	public final static int LIMIT = 4000000;

	public static int even_fibo(int limit){
		int sum = 0; 
		int a = 1;
		int b = 1;

		while(b < LIMIT){
			if(b % 2 == 0){
				sum = sum + b;
			}
			int res = a + b;
			a = b;
			b = res;
		}
		return sum;
	}

	
	public static void main(String[] args){
		Problem2 fibonacci = new Problem2();
		int sum = fibonacci.even_fibo(LIMIT);
		System.out.println(sum);
	}
}