package facebook;
import java.util.Arrays;
import java.util.HashMap;

/*
	Let's say there is a double square number X, which can be expressed as the sum of two perfect squares,
	for example, 10 is double square because 10 = 3^2 + 1^2

	Determine the number of ways which it can be written as the sum of two squares

	Link: http://www.careercup.com/question?id=5767787551129600
*/
public class SumOfPerfectSquares {
	/*

		1. Naive Approach: This problem is pretty straightforward. We can simply examine every possible pair of numbers in this integer array.
		Time complexity in worst case: O(n^2).

		2. Use HashMap to store the target value.
			Time complexity depends on the put and get operations of HashMap which is normally O(1).
			Time complexity of this solution: O(n).

		3. Use two pointers if array is sorted. If not sorting takes O(nlogn)
	*/
	public int[] perfectSquaresSum_HashMap(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];

		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i] * numbers[i];
			if (map.containsKey(number)) {
				int index = map.get(number);
				result[0] = index ;
				result[1] = i;
				break;
			} else {
				map.put(target - number, i);
			}
		}

		return result;
	}

	public void perfectSquaresSum_anyPair_afterSorting(int[] A, int x) {
		Arrays.sort(A);
		int start = 0;
		int end = A.length - 1;
		boolean found = false;
		while (!found && start < end) {
            int number = (A[start] * A[start]) + (A[end] * A[end]);
			if (number == x)
				found = true;
			else if (number > x)
				end--;
			else if (number < x)
				start++;
		}
		if (found)
			System.out.println("Sum " + x
					+ " is found, values the making sum are " + A[start] + " , "
					+ A[end]);
		else
			System.out.println("No pair exists whose sum is " + x);
	}
}
