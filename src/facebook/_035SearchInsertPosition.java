package facebook;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not,
 * return the index where it would be if it were inserted in order. You may assume no duplicates in the array.
 *
 * Here are few examples.
 *     [1,3,5,6], 5 -> 2
 *     [1,3,5,6], 2 -> 1
 *     [1,3,5,6], 7 -> 4
 *     [1,3,5,6], 0 -> 0
 *
 * https://leetcode.com/problems/search-insert-position/
 * http://www.programcreek.com/2013/01/leetcode-search-insert-position/
 *
 * 1. Naive Solution: Naively, we can just iterate the array and compare target with ith and (i+1)th element.
 *     Time complexity is O(n)
 *
 * 2. Binary Search : O(logn)
 */
public class _035SearchInsertPosition {
    public static void main(String[] args) {
        Solution_SearchInsertPosition sol = new Solution_SearchInsertPosition();
        sol.searchInsert(null, 9);
    }
}

class Solution_SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }

        return searchInsert(A, target, 0, A.length - 1);
    }

    private int searchInsert(int[] A, int target, int start, int end) {
        int mid = (start + end) / 2;

        if (target == A[mid]) {
            return mid;
        } else if (target < A[mid]) {
            return start < mid ? searchInsert(A, target, start, mid - 1) : start;
        } else {
            return end > mid ? searchInsert(A, target, mid + 1, end) : (end + 1);
        }
    }
}
