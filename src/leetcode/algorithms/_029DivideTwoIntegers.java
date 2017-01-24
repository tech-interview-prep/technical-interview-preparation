package leetcode.algorithms;

/**
 * Divide two integers without using multiplication, division and mod operator.
 *
 * If it is overflow, return MAX_INT.
 *
 * https://leetcode.com/problems/divide-two-integers
 * https://gist.github.com/bittib/5734695
 * http://n00tc0d3r.blogspot.com/2013/02/divide-two-integers.html
 */
public class _029DivideTwoIntegers {
    public static void main(String[] args) {

    }
}

class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) throw new IllegalArgumentException("divisor cannot be 0");
        if (dividend == 0) return 0;

        boolean neg = (dividend > 0 != divisor > 0);
        long dend = Math.abs(dividend);
        long dsor = Math.abs(divisor);

        if (dsor == 1) {
            return neg ? new Long(-dend).intValue() : new Long(dend).intValue();
        }

        if (dend == dsor) {
            return neg ? -1 : 1;
        }

        int quotient = 0;

        while (dend >= dsor) {
            long tmp = dsor;
            int result = 1;

            while (dend >= (tmp + tmp)) {
                tmp <<= 1;
                result <<= 1;
            }

            quotient += result;
            dend -= tmp;
        }

        return neg ? -quotient : quotient;
    }
}
