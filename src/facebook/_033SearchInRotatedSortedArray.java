package facebook;

import utils.Utils;

/**
 * Suppose nums sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given nums target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
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
    public int search(int[] nums, int target) {
        // binary search
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            }

            // find boundary
            if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target <= nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else { // nums[m] < nums[l]
                if (target >= nums[l] || target <= nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }

    public int search2(int nums[], int x) {
        return search(nums, 0 , nums.length - 1, x);
    }

    private int search(int nums[], int left, int right, int x) {
        int mid = left + (right - left) / 2;
        if (x == nums[mid]) { // Found element
            return mid;
        }
        if (right < left) {
            return -1;
        }

        /* While there may be an inflection point due to the rotation, either the left or
         * right half must be normally ordered.  We can look at the normally ordered half
         * to make nums determination as to which half we should search.
         */
        if (nums[left] < nums[mid]) { // Left is normally ordered.
            if (x >= nums[left] && x <= nums[mid]) {
                return search(nums, left, mid - 1, x);
            } else {
                return search(nums, mid + 1, right, x);
            }
        } else if (nums[mid] < nums[left]) { // Right is normally ordered.
            if (x >= nums[mid] && x <= nums[right]) {
                return search(nums, mid + 1, right, x);
            } else {
                return search(nums, left, mid - 1, x);
            }
        } else if (nums[left] == nums[mid]) { // Left is either all repeats OR loops around (with the right half being all dups)
            if (nums[mid] != nums[right]) { // If right half is different, search there
                return search(nums, mid + 1, right, x);
            } else { // Else, we have to search both halves
                int result = search(nums, left, mid - 1, x);
                if (result == -1) {
                    return search(nums, mid + 1, right, x);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
}
