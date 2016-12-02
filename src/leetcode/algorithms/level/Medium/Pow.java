package leetcode.algorithms.level.Medium;

import utils.Utils;

/**
 * Implement pow(x, n).
 *
 * https://leetcode.com/problems/powx-n/
 * http://n00tc0d3r.blogspot.com/2013/05/powx-n.html
 */
public class Pow {
    public static void main(String[] args) {
        Solution_Pow sol = new Solution_Pow();
        Utils.printTestln(sol.pow(2, 10), 1024.0);
        Utils.printTestln(sol.pow(3, 5), 243.0);
        Utils.printTestln(sol.pow(3, -5), 1 / 243.0);
    }
}

class Solution_Pow {
    public double pow(double x, int n) {
        double ret = 1;

        long nl = n < 0 ? -(long)n : n;
        while (nl > 0) {
            if ((nl & 1) == 1) {
                ret *= x;
            }
            nl >>= 1;
            x *= x;
        }
        return n < 0 ? 1 / ret : ret;
    }
}
