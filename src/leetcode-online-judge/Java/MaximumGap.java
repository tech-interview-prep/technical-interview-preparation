package leetcode_online_judge;

import java.util.Arrays;

 /*
 https://oj.leetcode.com/problems/maximum-gap/

 Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Try to solve it in linear time/space.

 Return 0 if the array contains less than 2 elements.

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

 Link: https://oj.leetcode.com/discuss/18499/bucket-sort-java-solution-with-explanation-o-time-and-space
 */
public class MaximumGap {

	public static void main(String[] args) {
        MaximumGap c = new MaximumGap();
        int[] a = {1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 6, 9};
		System.out.println(c.maximumGap(a));
	}

	public int maximumGap(int[] num) {
		if (num.length < 2)
			return 0;

		// get min and max
		int max = num[0];
		int min = num[0];
		for (int i = 1; i < num.length; i++) {
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
		}

		// get delta
		int delta = (int) Math.ceil((double) (max - min) / (num.length - 1));

		// populate buckets
		int[] bmin = new int[num.length - 1];
		int[] bmax = new int[num.length - 1];

		Arrays.fill(bmin, Integer.MAX_VALUE);
		Arrays.fill(bmax, Integer.MIN_VALUE);

		for (int i = 0; i < num.length; i++) {
			if (min < num[i] && num[i] < max) {
				int idx = (num[i] - min) / delta;
				bmin[idx] = Math.min(num[i], bmin[idx]);
				bmax[idx] = Math.max(num[i], bmax[idx]);
			}
		}

		// find the gap
		int gap = 0;
		int prev = min;
		for (int i = 0; i < bmax.length; i++) {
			if (bmin[i] <= bmax[i]) {
				gap = Math.max(bmin[i] - prev, gap);
				prev = bmax[i];
			}
		}
		gap = Math.max(max - prev, gap);

		return gap;
	}
}