/*
    Median in a stream of integers (running integers)

    Given that integers are read from a data stream. Find median of elements read so for
    in efficient way. For simplicity assume there are no duplicates.

    For example, let us consider the stream 5, 15, 1, 3 …

    After reading 1st element of stream - 5 -> median - 5
    After reading 2nd element of stream - 5, 15 -> median - 10
    After reading 3rd element of stream - 5, 15, 1 -> median - 5
    After reading 4th element of stream - 5, 15, 1, 3 -> median - 4, so on...

    Link: http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/

*/
package facebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _295FindMedianFromDataStream {

}

class Solution_FindMedianFromDataStream {
	private static Comparator<Integer> heapComparator;
	private static PriorityQueue<Integer> maxHeap;
	private static PriorityQueue<Integer> minHeap;

	public static void addNewNumber(int randomNumber) {
		/* Note: addNewNumber maintains a condition that maxHeap.size() >= minHeap.size() */
		if (maxHeap.size() == minHeap.size()) {
			if ((minHeap.peek() != null) &&
					randomNumber > minHeap.peek()) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(randomNumber);
			} else {
				maxHeap.offer(randomNumber);
			}
		}
		else {
			if(randomNumber < maxHeap.peek()){
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(randomNumber);
			}
			else {
				minHeap.offer(randomNumber);
			}
		}
	}

	public static double getMedian() {
		/* maxHeap is always at least as big as minHeap. So if maxHeap is empty, then minHeap is also. */
		if (maxHeap.isEmpty()) {
			return 0;
		}
		if (maxHeap.size() == minHeap.size()) {
			return ((double)minHeap.peek() + (double) maxHeap.peek()) / 2;
		} else {
			/* If maxHeap and minHeap are of different sizes, then maxHeap must have one extra element. Return maxHeap’s top element.*/
			return maxHeap.peek();
		}
	}

	public static void addNewNumberAndPrintMedian(int randomNumber) {
		addNewNumber(randomNumber);
		System.out.println("Random Number = " + randomNumber);
		printMinHeapAndMaxHeap();
		System.out.println("\nMedian = " + getMedian() + "\n");
	}

	public static void printMinHeapAndMaxHeap(){
		Integer[] minHeapArray = minHeap.toArray(
				new Integer[minHeap.size()]);
		Integer[] maxHeapArray = maxHeap.toArray(
				new Integer[maxHeap.size()]);

		Arrays.sort(minHeapArray, heapComparator);
		Arrays.sort(maxHeapArray, heapComparator);
		System.out.print("MinHeap =");
		for (int i = minHeapArray.length - 1; i >= 0 ; i--){
			System.out.print(" " + minHeapArray[i]);
		}
		System.out.print("\nMaxHeap =");
		for (int i = 0; i < maxHeapArray.length; i++){
			System.out.print(" " + maxHeapArray[i]);
		}
	}
}
