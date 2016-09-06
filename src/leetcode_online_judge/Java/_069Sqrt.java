package leetcode_online_judge.Java;

import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */

public class _069Sqrt {
    /*
    Implement int sqrt(int x).

    Compute and return the square root of x.
     */
    public static int sqrt(int x) {
        int start = 0, end = x, mid = start, minDiff = Integer.MAX_VALUE;

        while ( start <= end ) {
            mid = (start + end) >>> 1;
            long pow;
            if ((pow = (long)mid * (long)mid) == x) {
                return mid;
            }

            if (Math.abs(pow - x) < minDiff) {
                minDiff = (int)Math.abs(pow - x);
            }

            if (pow < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    // s_(n + 1) = (s_n + x / s_n) / 2;
    public static int sqrt2(int x) {
        if (x <= 1) {
            return x;
        }
        double s0 = 1, s1 = 2;
        while (Math.abs(s0 - s1) > 0.0001) {
            s0 = s1;
            s1 = (s0 + x / s0) / 2.0;
        }

        return (int)Math.round(s1);
    }

    private static void test() {
        Utils.printTestln(sqrt(0), 0);
        Utils.printTestln(sqrt(4), 2);
        Utils.printTestln(sqrt(9), 3);
        Utils.printTestln(sqrt(2147483647), 46341);
        Utils.printTestln(sqrt(2), 1);

        System.out.println("\n>>>Below is the Newton Iteration version:");

        Utils.printTestln(sqrt2(0), 0);
        Utils.printTestln(sqrt2(3), 2);
        Utils.printTestln(sqrt2(4), 2);
        Utils.printTestln(sqrt2(9), 3);
        Utils.printTestln(sqrt2(2147483647), 46341);
        Utils.printTestln(sqrt2(2), 1);
    }

    public static void main(String[] args) {
        test();
    }
}
