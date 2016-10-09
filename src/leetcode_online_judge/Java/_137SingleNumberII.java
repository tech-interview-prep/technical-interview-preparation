package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _137SingleNumberII {
    /*
    Given an array of integers, every element appears three times except for one. Find that single one.

    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     */
    public static int singleNumber(int[] A) {
        byte[] a = new byte[32];
        for (int i : A) {
            xor3(a, i);
        }

        return byte2Int(a);
    }

    private static void xor3(byte[] a, int b) {
        for (int i = 31; i >= 0; i--) {
            a[i] = (byte)(((b & 1) + a[i]) % 3);
            b >>>= 1;
        }
    }

    private static int byte2Int(byte[] a) {
        int ret = a[0];
        for (int i = 1; i < 32; i++) {
            ret <<= 1;
            ret += a[i];
        }

        return ret;
    }

    private static void test() {
        Utils.printTestln(singleNumber(new int[] {1, 1, 1, 4}), 4);
        Utils.printTestln(singleNumber(new int[] {1, 1, 1, 3, 3, 3, 4}), 4);
    }

    public static void main(String[] args) {
        test();
    }


}
