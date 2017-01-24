package leetcode.algorithms;

import utils.Utils;

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 *
 * Write a function to determine if a given target is in the array.
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii
 * http://n00tc0d3r.blogspot.com/2013/05/search-in-rotated-sorted-array.html
 */
public class _081SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        Solution_SearchInRotatedSortedArrayII sol = new Solution_SearchInRotatedSortedArrayII();

        Utils.printTestln(sol.search(new int[] {1, 1, 3, 1}, 2), false);
        Utils.printTestln(sol.search(new int[] {1, 1, 3, 1}, 2), false);
        Utils.printTestln(sol.search(new int[] {0, 0, 1, 1, 2, 0}, 2), true);
        Utils.printTestln(sol.search(new int[] {1, 2, 0, 1, 1, 1}, 0), true);
        Utils.printTestln(sol.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0), true);
        Utils.printTestln(sol.search(new int[] {3, 4, 5, 1, 2}, 3), true);
        Utils.printTestln(sol.search(new int[] {3, 4, 5, 1, 2}, 2), true);
        Utils.printTestln(sol.search(new int[] {3, 4, 5, 1, 2}, 11), false);
    }
}

class Solution_SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;

        while (start <= end) {
            while (start < end && nums[start] == nums[end]) {
                start++;
            }
            mid = (start + end) >>> 1;

            if (nums[mid] == target || nums[start] == target || nums[end] == target) {
                return true;
            }

            if (nums[mid] < target) {
                if (nums[start] < nums[end] || target < nums[end] || nums[mid] > nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[start] < nums[end] || target > nums[end] || nums[mid] <= nums[end]) {
                    end = mid - 1;
                } else {
                    start  = mid + 1;
                }
            }
        }
        return false;
    }

    public boolean search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            while (start < end && nums[end] == nums[end - 1])
                end--;
            int mid = start + (end - start) / 2;
            if (target == nums[mid])
                return true;
            else if (target < nums[mid]) {
                if (nums[mid] >= nums[end] && target < nums[start])
                    start = mid + 1;
                else
                    end = mid - 1;
            } else {
                if (nums[mid] < nums[end] && target > nums[end])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return false;
    }
}
