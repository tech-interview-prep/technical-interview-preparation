package leetcode.algorithms;

import utils.Utils;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 *
 * https://leetcode.com/problems/sqrtx/
 * http://n00tc0d3r.blogspot.com/2013/06/sqrtx.html
 */
public class Sqrt {
    public static void main(String[] args) {
        Solution_Sqrt sol = new Solution_Sqrt();

        Utils.printTestln(sol.sqrt(0), 0);
        Utils.printTestln(sol.sqrt(4), 2);
        Utils.printTestln(sol.sqrt(9), 3);
        Utils.printTestln(sol.sqrt(2147483647), 46341);
        Utils.printTestln(sol.sqrt(2), 1);

        System.out.println("\n>>>Below is the Newton Iteration version:");

        Utils.printTestln(sol.sqrt2(0), 0);
        Utils.printTestln(sol.sqrt2(3), 2);
        Utils.printTestln(sol.sqrt2(4), 2);
        Utils.printTestln(sol.sqrt2(9), 3);
        Utils.printTestln(sol.sqrt2(2147483647), 46341);
        Utils.printTestln(sol.sqrt2(2), 1);
    }
}

class Solution_Sqrt {
    public int sqrt(int x) {
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

    /*
        Babylonian method for square root

        Algorithm:
        This method can be derived from (but predates) Newton–Raphson method.


        1 Start with an arbitrary positive start value x (the closer to the
           root, the better).
        2 Initialize y = 1.
        3. Do following until desired approximation is achieved.
          a) Get the next approximation for root using average of x and y
          b) Set y = n/x

         http://www.geeksforgeeks.org/square-root-of-a-perfect-square/

    */

    // s_(n + 1) = (s_n + x / s_n) / 2;
    public int sqrt2(int x) {
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

    double squareRoot(double n) {
        /*We are using n itself as initial approximation
         This can definitely be improved */
        double x = n;
        double y = 1;
        double e = 0.000001; /* e decides the accuracy level*/
        while (x - y > e) {
            x = (x + y) / 2;
            y = n / x;
        }

        return x;
    }

    // https://gist.github.com/zac-xin/4353800
    public int sqrt3(int x) {
        long low = 0;
        long high = x;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long result = mid * mid;
            if (result == x) {
                return (int)mid;
            } else if (result > x) {
                high = mid - 1;
            } else {

                low = mid + 1;
            }
        }
        return (int)high;
    }
}
