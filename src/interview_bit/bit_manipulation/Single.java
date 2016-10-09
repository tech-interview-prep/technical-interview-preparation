package interview_bit.bit_manipulation;
import java.util.List;

/**
 * Created by priyavivek on 10/20/15.
 *
 * Problem statement
 *
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.

 Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Example :

 Input : [1 2 2 3 1]
 Output : 3
 */
public class Single {
    public int singleNumber(final List<Integer> a) {

        int x = 0;
        for (int b : a) {
            x = x ^ b;
        }
        return x;


    }
}
