package leetcode_online_judge.Java;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _162FindPeakElement {
    /*
    Find Peak Element
        A peak element is an element that is greater than its neighbors.

        Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

        The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

        You may imagine that num[-1] = num[n] = -∞.

        For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

    Note:
        Your solution should be in logarithmic complexity.
    */

    public int findPeak(int[] num) {
        return findPeakUtil(num, 0, num.length - 1, num.length);
    }

    private int findPeakUtil(int[] num, int low, int high, int length) {
        int mid = low + (high - low) / 2;
        if ((mid == 0 || num[mid - 1] <= num[mid])
                && (mid == length - 1 || num[mid + 1] <= num[mid])) {
            return mid;
        } else if (mid > 0 && num[mid - 1] > num[mid]) {
            return findPeakUtil(num, low, mid - 1, length);
        } else {
            return findPeakUtil(num, mid + 1, high, length);
        }
    }

    public int findPeakElement(int[] num) {
        int len = num.length;
        int l = 0, r = num.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if ((m == 0 || (num[m - 1] <= num[m]))
                    && (m == len - 1 || (num[m + 1] <= num[m]))) {
                return m;
            }
            if (m > 0 && num[m - 1] > num[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return 0;
    }
}
