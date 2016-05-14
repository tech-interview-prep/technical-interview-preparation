package leetcode_online_judge.Java;

import utils.Utils;

import java.util.Arrays;

public class _016_3SumClosest {
    /*
    Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
    Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    */
	public static int threeSumClosest(int[] nums, int target) {
	    if (nums.length == 3) return nums[0]+nums[1]+nums[2];
	    Arrays.sort(nums);
	    int[] res = new int[3];
	    int len = nums.length;
	    int min = Integer.MAX_VALUE;

	    for (int i = 0;i < len - 2;i++) {
	        if (i > 0 && nums[i] == nums[i-1]) continue;
	        min = find(res, nums, i+1, len-1, nums[i], target, min);
	        if (min == 0) break;
	    }

	    return res[0] + res[1] + res[2];
	}

	public static int find(int[] res, int[] nums, int start, int end, int target, int target2, int min) {
	    int l = start;
	    int r = end;
	    int temp = 0;
	    while(l < r) {
	        if (Math.abs((temp = nums[l]+nums[r]+target - target2)) < min){
	            res[0] = target;
	            res[1] = nums[l];
	            res[2] = nums[r];
	            if (temp == 0) return 0;
	            if (temp < 0) l++;
	            else r--;
	            min = Math.abs(temp);

	        }
	        else if (temp < 0) {
	            l++;
	        }
	        else if (temp > 0) {
	            r--;
	        }
	        else return 0;
	    }
	    return min;
	}

    private static void test() {
        Utils.printTestln(threeSumClosest(new int[]{-1, 2, 1, -4}, 1), 2);
        Utils.printTestln(threeSumClosest(new int[]{0, 1, 2}, 3), 3);
    }

    public static void main(String[] args) {
        test();
    }
}
