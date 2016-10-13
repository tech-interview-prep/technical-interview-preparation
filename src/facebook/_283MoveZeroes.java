package facebook;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of
 * the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 *   1. You must do this in-place without making a copy of the array.
 *   2. Minimize the total number of operations.
 *
 * https://leetcode.com/problems/move-zeroes/
 * http://www.careercup.com/question?id=5668212962230272
 */
public class _283MoveZeroes {
}

class Solution_MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int counter = 0;
        int length = nums.length;
        for (int j = 0; j < length; j++) {
            if (nums[j] == 0) {
                counter++;
            } else {
                nums[j - counter] = nums[j];

            }
        }
        while (counter > 0) {
            nums[length - counter] = 0;
            counter--;
        }
    }

    public int[] moveZeroesToEnd(int[] input) {
        if (input == null || input.length == 0) {
            return input; //Talk to interviewer on what should be returned
        }

        int i = 0;
        int j = input.length - 1;
        while (i < j) {
            if (input[j] == 0) {
                j--;
            } else if (input[i] != 0) {
                i++;
            } else {
                int temp = input[j];
                input[j] = input[i];
                input[i] = temp;
                i++;
                j--;
            }
        }

        return input;
    }

    static void moveZeroesToEnd(int arr[], int n) {
        int i = 0;
        for (int j = 0; j < n; ++j) {
            if (arr[j] != 0) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
            }
        }
    }
}
