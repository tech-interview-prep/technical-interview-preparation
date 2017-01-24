package leetcode.algorithms;

/**
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You
 * need to determine whether it is possible to measure exactly z litres using these two jugs.
 * <p>
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 * <p>
 * Operations allowed:
 * <p>
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 * Example 1: (From the famous "Die Hard" example)
 * <p>
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * Example 2:
 * <p>
 * Input: x = 2, y = 6, z = 5
 * Output: False
 * <p>
 * Tags: Math
 */
public class WaterAndJugProblem {

    private WaterAndJugProblem w;

    /**
     * Math, Bézout's identity.
     * Let a and b be nonzero integers and let d be their greatest common divisor.
     * Then there exist integers x and y such that ax+by=d, linear combination of x and y.
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        int gcd = gcd(x, y);
        return z % gcd == 0;
    }

    /**
     * Euclid's Algorithm.
     * gcd(a, 0) = a
     * gcd(a, b) = gcd(b, a mod b)
     * a mod b = a - b * floor(a / b)
     */
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
