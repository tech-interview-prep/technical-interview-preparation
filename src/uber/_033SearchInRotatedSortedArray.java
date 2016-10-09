/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 */

package uber;

import utils.Utils;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * @author bkoteshwarreddy
 */
public class _033SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution_SearchInRotatedSortedArray sol = new Solution_SearchInRotatedSortedArray();

        Utils.printTestln(sol.search(new int[] {3, 1}, 3), 0);
        Utils.printTestln(sol.search(new int[] {3, 1}, 1), 1);
        Utils.printTestln(sol.search(new int[] {1}, 2), -1);
        Utils.printTestln(sol.search(new int[] {1, 3}, 0), -1);
        Utils.printTestln(sol.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 7), 3);
        Utils.printTestln(sol.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 2), 6);
        Utils.printTestln(sol.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 4), 0);
    }
}

class Solution_SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] < target) {
                if (A[mid] > A[start]) {
                    start = mid + 1;
                } else {
                    if (target == A[end]) {
                        return end;
                    }
                    if (target < A[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            } else {
                if (A[mid] < A[start]) {
                    end = mid - 1;
                } else {
                    if (A[start] == target) {
                        return start;
                    }
                    if (A[start] > target) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }

        return -1;
    }

    public int search2(int a[], int x) {
        return search(a, 0 , a.length - 1, x);
    }

    private int search(int a[], int left, int right, int x) {
        int mid = (left + right) / 2;
        if (x == a[mid]) { // Found element
            return mid;
        }
        if (right < left) {
            return -1;
        }

        /* While there may be an inflection point due to the rotation, either the left or
         * right half must be normally ordered.  We can look at the normally ordered half
         * to make a determination as to which half we should search.
         */
        if (a[left] < a[mid]) { // Left is normally ordered.
            if (x >= a[left] && x <= a[mid]) {
                return search(a, left, mid - 1, x);
            } else {
                return search(a, mid + 1, right, x);
            }
        } else if (a[mid] < a[left]) { // Right is normally ordered.
            if (x >= a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x);
            } else {
                return search(a, left, mid - 1, x);
            }
        } else if (a[left] == a[mid]) { // Left is either all repeats OR loops around (with the right half being all dups)
            if (a[mid] != a[right]) { // If right half is different, search there
                return search(a, mid + 1, right, x);
            } else { // Else, we have to search both halves
                int result = search(a, left, mid - 1, x);
                if (result == -1) {
                    return search(a, mid + 1, right, x);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
}
