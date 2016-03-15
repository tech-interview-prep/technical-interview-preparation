package facebook;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/* 	
	Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
	Find all unique triplets in the array which gives the sum of zero.
	
	For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

	Link: http://www.programcreek.com/2012/12/leetcode-3sum/
		  http://www.lifeincode.net/programming/leetcode-two-sum-3-sum-3-sum-closest-and-4-sum-java/
*/	
public class ThreeSum {
	/*
	 
		1. Naive Approach: This problem is pretty straightforward. We can simply examine every possible pair of numbers in this integer array.
		Time complexity in worst case: O(n^3).

		2. Use two pointers if array is sorted.		
.
			Time complexity of this solution: O(n^2).
					
	*/
	public List<List<Integer>> threeSum(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
	 
		if (num.length < 3)
			return result;
	 
		// sort array
		Arrays.sort(num);
	 
		for (int i = 0; i < num.length - 2; i++) {
			// //avoid duplicate solutions
			if (i == 0 || num[i] > num[i - 1]) {
	 
				int diff = target-num[i];
	 
				int start = i + 1;
				int end = num.length - 1;
	 
				while (start < end) {
					//case 1
					if (num[start] + num[end] == diff) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[start]);
						temp.add(num[end]);
	 
						result.add(temp);
						start++;
						end--;
						//avoid duplicate solutions
						while (start < end && num[end] == num[end + 1])
							end--;
	 
						while (start < end && num[start] == num[start - 1])
							start++;
					//case 2
					} else if (num[start] + num[end] < diff) {
						start++;
					//case 3
					} else {
						end--;
					}
				}
	 
			}
		}
	 
		return result;
	}	
}
