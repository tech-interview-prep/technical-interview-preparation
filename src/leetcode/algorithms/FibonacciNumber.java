package leetcode.algorithms;

/*
    Write a method to generate the nth Fibonacci number.

     https://gist.github.com/zac-xin/3936282

*/
public class FibonacciNumber {
    public static int getFibonacci(int n) {
        int fib[] = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < fib.length ; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n - 1];
    }

    public static int fibonacci(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }

        return fibonacci(number - 1) + fibonacci(number - 2); //tail recursion
    }
}
