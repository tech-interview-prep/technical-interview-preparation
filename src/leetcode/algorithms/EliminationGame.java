package leetcode.algorithms;

/**
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other
 * number afterward until you reach the end of the list.
 * <p>
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number
 * from the remaining numbers.
 * <p>
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * <p>
 * Find the last number that remains starting with a list of length n.
 * <p>
 * Example:
 * <p>
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 * <p>
 * Output:
 * 6
 */
public class EliminationGame {

    private EliminationGame eg;

    /**
     * Calculate the start point of next round with:
     * The start point of this round, the step, the number of removed integers.
     * If from left, start = start + step * len - step / 2
     * If from right, start = start - step * len + step / 2
     * step / 2 is actually the step of last round.
     * Stop when only one integer remain.
     */
    public int lastRemaining(int n) {
        int start = 1;
        int step = 2;
        int len = n;
        boolean isFromLeft = true;
        while (len != 1) {
            len >>= 1;
            if (isFromLeft) {
                start = start + step * len - step / 2;
            } else {
                start = start - step * len + step / 2;
            }
            step <<= 1;
            isFromLeft = !isFromLeft;
        }
        return start;
    }
}
