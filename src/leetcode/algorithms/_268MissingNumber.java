package leetcode.algorithms;

import java.util.ArrayList;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * For example,
 * Given nums = [0, 1, 3] return 2.
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * -----------------------------------------------------------------------------------------------------------
 *
 * An array A[1...n] contains all the integers from 0 to n except for
 * one number which is missing.
 * ===================================================
 * suppose we got numbers from 0 to n
 * if n+1 is even(eg. n=3), the numbers in the least significant bit are: 1010
 *         count(0)=count(1)
 * if n+1 is odd(eg. n=4), the numbers int the LSB are:01010
 *         count(0)=count(1)+1
 * ====================================================
 * n+1=4 we delete a 0  count(0) < count(1)
 *        we delete 1 count(0) > count(1)
 * n+1=5 delete 0 count(0) = count(1)
 *    delete 1    count(0) > count(1)
 * so whether n is ever or odd, if we delete a 0 count(0) <= count(1)
 * if we delete a 1 count(0) > count(1)
 *
 * we come back to the original problem, we miss a number
 * let's consider only the Least significant bit
 * if the number is odd, then it means we have delete a 1 so count(0) > count(1)
 * if the number is even, then we have delete a 0 so count(0) <= count(1)
 *
 * that means we can count 1 and 0 of all numbers' LSB
 * if count(0)>count(1) the number's last bit is 1 otherwise it is 0
 * in this way, we have detetmined the last bit
 *
 * if it is odd what we need to do is to test the list of odds and vice versa.
 * the SLSB in the odds or evens also satisfy the theory of count(0) & count(1)
 * now we can move a bit left to test the second LSB
 * continue until 2^column>n
 *
 * https://leetcode.com/problems/missing-number
 * https://gist.github.com/zac-xin/2728968
 */
public class _268MissingNumber {
}

class FindMissingNumber {
    public static boolean getBit(int n, int index) {
        return (n & (1 << index)) > 0;
    }
    // we try to find missing number from 1 - n;
    public static int findMissing(ArrayList<Integer> list, int column, int n) {
        if (Math.pow(2, column) > n) {
            return 0;
        }

        ArrayList<Integer> oddIndices = new ArrayList<Integer>();
        ArrayList<Integer> evenIndices = new ArrayList<Integer>();

        for (Integer i : list) {
            if (getBit(i, column)) {
                oddIndices.add(i);
            } else {
                evenIndices.add(i);
            }
        }

        if (oddIndices.size() >= evenIndices.size()) { // missing number has a 0 in the index of column
            /* the last zero in the return statement is that we got in this method
             * the rest we need to use recursion
             * in each recursion we just add a 0 or 1 to the last bit
             * the call to findMissing(evens, column+1) decide the rest
             */
            return findMissing(evenIndices, column + 1, n) << 1 | 0;
        } else {
            return findMissing(oddIndices, column + 1, n) << 1 | 1;
        }
    }
}
