package leetcode_online_judge.Java;

import utils.Utils;

public class _050Pow {
    /*
    Implement pow(x, n).
    */
    public static double pow(double x, int n) {
        double ret = 1;

        long nl = n < 0 ? -(long)n : n;
        while (nl > 0) {
            if ((nl & 1) == 1) {
                ret *= x;
            }
            nl >>= 1;
            x *= x;
        }
        return n < 0 ? 1/ret : ret;
    }

    private static void test() {
        Utils.printTestln(pow(2, 10), 1024.0);
        Utils.printTestln(pow(3, 5), 243.0);
        Utils.printTestln(pow(3, -5), 1/243.0);
    }

    public static void main(String[] args) {
        test();
    }
}
