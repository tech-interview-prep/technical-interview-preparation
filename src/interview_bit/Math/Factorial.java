package interview_bit.math;

/**
 * Created by priyavivek on 10/29/15.
 *
 * Problem statement
 *
 * Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.

 Example :

 n = 5
 n! = 120
 Number of trailing zeros = 1
 So, return 1
 */
public class Factorial {
    public int trailingZeroes(int n) {
        if (n < 0)
            return -1;

        int count = 0;
        for (long i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }

        return count;
    }

    public static void main(String[] args){

        Factorial f = new Factorial();
        int result = f.trailingZeroes(120);

    }
}
