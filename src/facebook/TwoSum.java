package facebook;
import java.util.Arrays;
import java.util.HashMap;

/* 	
	Given an array of integers, find two numbers such that they add up to a specific target number.
	
	Input: numbers={2, 7, 11, 15}, target=9
	Output: index1=1, index2=2

	Link: http://www.programcreek.com/2012/12/leetcode-solution-of-two-sum-in-java/
		  http://www.lifeincode.net/programming/leetcode-two-sum-3-sum-3-sum-closest-and-4-sum-java/
*/	
public class TwoSum {
	/*
	 
		1. Naive Approach: This problem is pretty straightforward. We can simply examine every possible pair of numbers in this integer array.
		Time complexity in worst case: O(n^2).

		2. Use HashMap to store the target value.
			Time complexity depends on the put and get operations of HashMap which is normally O(1).
			Time complexity of this solution: O(n).
			
		3. Use two pointers if array is sorted. If not sorting takes O(nlogn)	
	*/
	public int[] twoSum_HashMap(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
	 
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				int index = map.get(numbers[i]);
				result[0] = index ;
				result[1] = i;
				break;
			} else {
				map.put(target - numbers[i], i);
			}
		}
	 
		return result;
	}	
	
	public static void twoSum_anyPair_afterSorting(int[] A, int x) {
		Arrays.sort(A);		
		int start = 0;
		int end = A.length - 1;
		boolean found = false;
		while (!found && start < end) {
			if (A[start] + A[end] == x)
				found = true;
			else if (A[start] + A[end] > x)
				end--;
			else if (A[start] + A[end] < x)
				start++;
		}
		if (found)
			System.out.println("Sum " + x
					+ " is found, values the making sum are " + A[start] + " , "
					+ A[end]);
		else
			System.out.println("No pair exists whose sum is " + x);
	}
	
	 public static void twoSum_allPairs_afterSorting(int[] A, int x) {
	 	Arrays.sort(A);
	 	
	 	for (int i = 0; i < A.length - 1; i++) {
	 		int tofind = x - A[i];
	 		int returned = Arrays.binarySearch(A, i + 1, A.length, tofind);
	 		if (returned > 0) {
	 			System.out.println("Sum " + x
	 					+ " is found, values the making sum are " + A[i]
	 					+ " , " + A[returned]);
	 		}
	 		}
	 }
}
