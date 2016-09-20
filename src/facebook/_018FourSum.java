/*
    Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
    Find all unique quadruplets in the array which gives the sum of target.

    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)

    Link:   http://www.programcreek.com/2013/02/leetcode-4sum-java/
            http://www.lifeincode.net/programming/leetcode-two-sum-3-sum-3-sum-closest-and-4-sum-java/
*/

package facebook;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _018FourSum {
  public static void main(String[] args) {

  }
}

class Solution_FourSum {
	/*

		1. Naive Approach: This problem is pretty straightforward. We can simply examine every possible pair of numbers in this integer array.
		Time complexity in worst case: O(n^4).

		2. Use HashMap to store the target value.
			Time complexity depends on the put and get operations of HashMap which is normally O(1).
			Time complexity of this solution: O(n^3).

	*/
	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);

		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int k = j + 1;
				int l = num.length - 1;

				while (k < l) {
					int sum = num[i] + num[j] + num[k] + num[l];

					if (sum > target) {
						l--;
					} else if (sum < target) {
						k++;
					} else if (sum == target) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[k]);
						temp.add(num[l]);

						if (!hashSet.contains(temp)) {
							hashSet.add(temp);
							result.add(temp);
						}

						k++;
						l--;
					}
				}
			}
		}

		return result;
	}
}
