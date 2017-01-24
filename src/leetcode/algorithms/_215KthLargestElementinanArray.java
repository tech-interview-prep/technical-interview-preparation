package leetcode.algorithms;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not
 * the kth distinct element.
 *
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * Note:
 * You may assume k is always valid, 1 <= k <= array's length.
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class _215KthLargestElementinanArray {
}

class Solution_KthLargestElementinanArray {
    // optimized quicksort
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, nums.length - k + 1, 0, nums.length - 1);
    }
    // k: order from smallest to largest
    public int findKthLargest(int[] nums, int k, int start, int end) {
        int pivot = nums[end];
        int left = start;
        int right = end;

        while (left < right) {
            while (nums[left] < pivot && left < right) left++;
            while (nums[right] >= pivot && right > left) right--;
            if (left < right) swap(nums, left, right);
        }
        swap(nums, left, end);
        // recursive
        if (left + 1 == k) return pivot;
        else if (left + 1 < k) return findKthLargest(nums, k, left + 1, end);
        else return findKthLargest(nums, k, start, left - 1);
    }
    // swap
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
