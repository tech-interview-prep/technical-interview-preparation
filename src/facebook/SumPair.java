package facebook;

import java.util.Arrays;
import java.util.HashMap;

/**
 * You're given an array of integers(eg [3,4,7,1,2,9,8]) Find the index of values that satisfy A+B = C + D,
 * where A,B,C and D are integer values in the array.
 *
 * Eg: Given [3,4,7,1,2,9,8] array
 * The following
 * 3+7 = 1+ 9 satisfies A+B=C+D
 * so print (0,2,3,5)
 *
 * 1. Sort the Array
 * 2. Take two pointers left (start of the array) and right (end of the array)
 * 3. Find the sum of the left and right value in the array
 * 4. Look up iteratively the sum within the subarray , if sum is found print it
 *     a. if sum is greater value then increment left side ( i ) or else reduce the (j) value
 *
 *  http://www.careercup.com/question?id=5652354158297088
 */
public class SumPair {
    public static void indexSumPair(int arr[]) {
        //Return the array if Size less than 4
        if (arr.length < 4) {
            return;
        }
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }
        // Sort the array
        Arrays.sort(arr);
        // Take two pointer left and right
        int left = 0;
        int right = arr.length - 1;

        // decrease the right pointer on each pass * array is sorted
        for (; left < right; right--) {
            // Take sum of left and right
            int outSum = arr[left] + arr[right];
            int i = left + 1;
            int j = right - 1;
            // Apply Logic of Pairs in Array of Integers whose Sum is equal to a given Number
            // look up the sum within the subarray
            while (i < j) {
                if (arr[i] + arr[j] == outSum) {
                    System.out.println(" (" + indexMap.get(arr[i]) + " , " + indexMap.get(arr[j]) + ") = " + " (" + indexMap.get(arr[left]) + " , " + indexMap.get(arr[right]) + ")");
                    i++;
                    j--;
                } else if (arr[i] + arr[j] < outSum) {
                    i++;
                } else if (arr[i] + arr[j] > outSum) {
                    j--;
                }
            }
        }
    }
}
