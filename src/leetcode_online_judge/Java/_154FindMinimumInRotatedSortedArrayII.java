package leetcode_online_judge.Java;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _154FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] num) {
        int begin = 0;
        int end = num.length;
        int minimum = Integer.MAX_VALUE;
        while (begin != end) {
            int mid = (begin + end) / 2;
            minimum = Math.min(minimum, num[mid]);
            if (num[begin] < num[mid]) {
                minimum = Math.min(minimum, num[begin]);
                begin = mid + 1;
            } else if (num[begin] > num[mid]) {
                end = mid;
            } else if (num[begin] == num[mid]) {
                begin ++;
            }
        }
        return minimum;
    }
}
