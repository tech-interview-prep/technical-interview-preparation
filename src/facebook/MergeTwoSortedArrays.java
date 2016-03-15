package facebook;

/* 	
	Given two sorted integer arrays A and B, merge B into A as one sorted array.

	Link: http://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/
	      https://gist.github.com/zac-xin/3943308
*/	
public class MergeTwoSortedArrays {
	/*
	 
		The key to solve this problem is moving element of A and B backwards. 
		If B has some elements left after A is done, also need to handle that case.
			
	*/
	public static void merge(int[] a, int[] b, int lastA, int lastB) {
		int indexMerged = lastB + lastA - 1; /* Index of last location of merged array */
		int indexA = lastA - 1; /* Index of last element in array b */
		int indexB = lastB - 1; /* Index of last element in array a */
	
		/* Merge a and b, starting from the last element in each */
		while (indexB >= 0) {
			if (indexA >= 0 && a[indexA] > b[indexB]) { /* end of a is bigger than end of b */
				a[indexMerged] = a[indexA]; // copy element
				indexA--; 
			} else {
				a[indexMerged] = b[indexB]; // copy element
				indexB--;
			}
			indexMerged--; // move indices			
		}
	}
}
