package leetcode_online_judge;

import utils.Utils;

import javax.rmi.CORBA.Util;
import java.util.List;
import java.util.ArrayList;

public class PermutationSequence {
    /*
    The set [1,2,3,�,n] contains a total of n! unique permutations.

    By listing and labeling all of the permutations in order,
    We get the following sequence (ie, for n = 3):

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"
    Given n and k, return the kth permutation sequence.

    Note: Given n will be between 1 and 9 inclusive.
     */
    public static String getPermutation(int n, int k) {
        StringBuffer ret = new StringBuffer();
        List<Integer> digits = new ArrayList <Integer>();
        int[] factorial = new int[n + 1];

        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            digits.add(i);
            factorial[i] = factorial[i - 1] * i;
        }

        for (int i = n; i >= 1; i--) {
            int digitIndex = (k - 1)/factorial[i - 1];
            ret.append(digits.get(digitIndex));
            digits.remove(digitIndex);
            k -= digitIndex * factorial[i - 1];
        }

        return ret.toString();
    }


    private static void test() {
        Utils.printTestln(getPermutation(3, 5), "312");
    }

    public static void main(String[] args) {
        test();
    }
    
}
