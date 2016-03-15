package facebook;

import java.util.HashSet;
import java.util.Set;

/* 	
	Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

	For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence should be [1, 2, 3, 4]. Its length is 4.
	
	Link: http://www.programcreek.com/2013/01/leetcode-longest-consecutive-sequence-java/
	
	
	
	
	We can use a HashSet to add and remove elements. HashSet is implemented by using a hash table. 
	Elements are not ordered. The add, remove and contains methods have constant time complexity O(1).
	
	After an element is checked, it should be removed from the set. Otherwise, time complexity would 
	be O(mn) in which m is the average length of all consecutive sequences.

	To clearly see the time complexity, I suggest you use some simple examples and manually execute 
	the program. For example, given an array {1,2,4,5,3}, the program time is m. m is the length of 
	longest consecutive sequence.

	We do have an extreme case here: If n is number of elements, m is average length of consecutive 
	sequence, and m==n, then the time complexity is O(n^2). The reason is that in this case, no element 
	is removed from the set each time. You can use this array to get the point: {1,3,5,7,9}.
*/	
public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] num) {
		// if array is empty, return 0
		if (num.length == 0) {
			return 0;
		}
	 
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;
	 
		for (int e : num)
			set.add(e);
	 
		for (int e : num) {
			int left = e - 1;
			int right = e + 1;
			int count = 1;
	 
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
	 
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}
	 
			max = Math.max(count, max);
		}
	 
		return max;
	}
}
