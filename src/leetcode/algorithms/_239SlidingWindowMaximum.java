package leetcode.algorithms;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very
 * right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 *
 * Note:
 * You may assume k is always valid, ie: 1 <= k <= input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 *
 * -----------------------------------------------------------------------------------------------------------
 * A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the
 * array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards
 * by one position. Following is an example:
 *
 * The array is [1 3 -1 -3 5 3 6 7], and w is 3.
 *
 * https://leetcode.com/problems/sliding-window-maximum/
 * https://gist.github.com/zac-xin/4134041
 * http://leetcode.com/2011/01/sliding-window-maximum.html
 * https://gist.github.com/bittib/5566920
 * http://n00tc0d3r.blogspot.com/2013/04/sliding-window-maximum.html
*/
public class _239SlidingWindowMaximum {

}

class Solution_SlidingWindowMaximum {
    public static int[] slidingWindowMaximum(int arr[], int w) {
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] b = new int[arr.length - w + 1];

        for (int i = 0; i < w; i++) {
            while (deque.size() != 0 && arr[deque.peekLast()] < arr[i])
                deque.removeLast();
            deque.addLast(i);
        }

        for (int i = w; i < arr.length; i++) {
            b[i - w] = arr[deque.peekFirst()];
            if (deque.peekFirst() <= i - w)
                deque.removeFirst();
            while (deque.size() != 0 && arr[deque.peekLast()] < arr[i])
                deque.removeLast();
            deque.addLast(i);
        }
        b[arr.length - w] = arr[deque.peekFirst()];
        return b;

    }

    /*
     * Time Complexity: O(n)
     */
    public int[] minOfSlidingWindow(int[] A, int k) {
        int n = A.length;
        int[] B = new int[n - k + 1];
        int[] queue = new int[n];
        int head = 0, tail = 0;
        for (int i = 0; i < n; i++) {
            while (head < tail && A[i] <= A[queue[tail - 1]])
                tail--;
            queue[tail++] = i;
            if (i >= k - 1) {
                while (head < tail && i - queue[head] >= k)
                    head++;
                B[i - k + 1] = A[queue[head]];
            }
        }
        return B;
    }
}
